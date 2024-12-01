package use_case.GetTranscript;

import java.io.FileWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

public class GetTranscriptInteractor implements GetTranscriptInputBoundary {
    private final GetTranscriptOutputBoundary outputBoundary;
    private final String apiKey;

    // Constructor to initialize the interactor
    public GetTranscriptInteractor(GetTranscriptOutputBoundary outputBoundary, String apiKey) {
        this.outputBoundary = outputBoundary;
        this.apiKey = apiKey;
    }

    // Executes the GetTranscript Use Case
    @Override
    public void execute(GetTranscriptInputData getTranscriptInputData) {
        String youtubeUrl = getTranscriptInputData.getYoutubeUrl();
        String apiUrl = "https://youtube-transcripts.p.rapidapi.com/youtube/transcript"
                + "?url=" + youtubeUrl
                + "&chunkSize=500";

        try {
            // Build the HTTP request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .header("x-rapidapi-key", apiKey)
                    .header("x-rapidapi-host", "youtube-transcripts.p.rapidapi.com")
                    .GET()
                    .build();

            // Send the request and get the response
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Parse the response
            JSONObject jsonResponse = new JSONObject(response.body());
            JSONArray contentArray = jsonResponse.getJSONArray("content");

            // Write the transcript content to a file
            String transcriptPath = "transcript.txt";
            try (FileWriter writer = new FileWriter(transcriptPath)) {
                for (int i = 0; i < contentArray.length(); i++) {
                    JSONObject contentObject = contentArray.getJSONObject(i);
                    writer.write(contentObject.getString("text") + System.lineSeparator());
                }
            }

            // Prepare the success view
            outputBoundary.prepareSuccessView(new GetTranscriptOutputData(transcriptPath));
        } catch (Exception e) {
            // Prepare the failure view if an error occurs
            outputBoundary.prepareFailView("Failed to fetch transcript: " + e.getMessage());
        }
    }
}
