package data_access.transcript;

import entity.Transcript;
import use_case.transcript.TranscriptDataUserAccessInterface;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TranscriptDAO implements TranscriptDataUserAccessInterface {
    private final String apiKey;
    private final HttpClient httpClient;
    private final ObjectMapper objectMapper;

    public TranscriptDAO(String apiKey) {
        this.apiKey = apiKey;
        this.httpClient = HttpClient.newHttpClient();
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Transcript getTranscript(String youtubeUrl) {
        try {
            String apiUrl = "https://youtube-transcripts.p.rapidapi.com/youtube/transcript"
                    + "?url=" + youtubeUrl
                    + "&chunkSize=500";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .header("x-rapidapi-key", apiKey)
                    .header("x-rapidapi-host", "youtube-transcripts.p.rapidapi.com")
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("API request failed with status code: " + response.statusCode());
            }

            JsonNode jsonResponse = objectMapper.readTree(response.body());
            JsonNode contentArray = jsonResponse.get("content");

            StringBuilder transcription = new StringBuilder();
            for (JsonNode contentObject : contentArray) {
                String text = contentObject.get("text").asText();
                transcription.append(text).append(System.lineSeparator());
            }

            return new Transcript(transcription.toString(), youtubeUrl);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch transcript: " + e.getMessage(), e);
        }
    }
}