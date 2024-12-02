package data_access.transcript;

import entity.Transcript;
import use_case.transcript.TranscriptDataUserAccessInterface;

public class TranscriptAccessObject implements TranscriptDataUserAccessInterface {
    private final String apiKey;
    private final boolean shouldThrowException;

    public TranscriptAccessObject(String apiKey) {
        this(apiKey, false);
    }

    public TranscriptAccessObject(String apiKey, boolean shouldThrowException) {
        this.apiKey = apiKey;
        this.shouldThrowException = shouldThrowException;
    }

    @Override
    public Transcript getTranscript(String youtubeUrl) {
        if (shouldThrowException) {
            throw new RuntimeException("Simulated DAO exception");
        }
        // Mock implementation
        String mockTranscript = "This is a mock transcript for video: " + youtubeUrl;
        return new Transcript(mockTranscript, youtubeUrl);
    }
}