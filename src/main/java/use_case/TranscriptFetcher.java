package use_case;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TranscriptFetcher {
    /**
     * Fetches the transcription for a YouTube video from the RapidAPI service.
     *
     * @param youtubeUrl The URL of the YouTube video.
     * @return The transcription of the video as a String.
     * @throws IOException If an I/O error occurs while making the HTTP request.
     * @throws InterruptedException If the request is interrupted.
     */
    public static String fetchTranscript(String youtubeUrl) throws IOException, InterruptedException {
        // Build the API URL
        String apiUrl = "https://youtube-transcripts.p.rapidapi.com/youtube/transcript"
                + "?url=" + youtubeUrl
                + "&chunkSize=500";

        // Build the HTTP request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .header("x-rapidapi-key", "e0a48d17cemshc6cc044bc5093cep180108jsn722dec23cf18")
                .header("x-rapidapi-host", "youtube-transcripts.p.rapidapi.com")
                .GET()
                .build();

        // Send the request and get the response
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        // Parse the response using Jackson ObjectMapper
        String responseBody = response.body();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonResponse = objectMapper.readTree(responseBody);

        // Extract the content array and build the transcription string
        StringBuilder transcription = new StringBuilder();
        JsonNode contentArray = jsonResponse.get("content");

        for (JsonNode contentObject : contentArray) {
            String text = contentObject.get("text").asText();
            transcription.append(text).append(System.lineSeparator());
        }

        return transcription.toString();
    }
}
