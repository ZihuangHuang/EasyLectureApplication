package use_case;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

public class TranscriptFetcher {
    public static void main(String[] args) {
        // Create a scanner to take user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a YouTube video URL:");
        String youtubeUrl = scanner.nextLine().trim(); // Get the URL from the user

        try {
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

            // Parse the response
            String responseBody = response.body();
            JSONObject jsonResponse = new JSONObject(responseBody);

            // Extract the content array
            JSONArray contentArray = jsonResponse.getJSONArray("content");

            // Write the text fields to a file
            FileWriter fileWriter = new FileWriter("transcript.txt");
            for (int i = 0; i < contentArray.length(); i++) {
                JSONObject contentObject = contentArray.getJSONObject(i);
                String text = contentObject.getString("text");
                fileWriter.write(text + System.lineSeparator());
            }
            fileWriter.close();

            System.out.println("Transcript saved to transcript.txt");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IOException | InterruptedException e) {
            System.err.println("An error occurred while fetching or saving the transcript: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
