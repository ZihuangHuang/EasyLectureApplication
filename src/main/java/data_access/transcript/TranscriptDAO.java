package data_access.transcript;

import entity.Transcript;
import use_case.transcript.TranscriptDataUserAccessInterface;
import exception.TranscriptFetchException; // Import the custom exception

/**
 * Mock DAO implementation for testing purposes.
 */
public class TranscriptDAO implements TranscriptDataUserAccessInterface {
    private final boolean shouldThrowException;

    /**
     * Constructs a MockTranscriptDAO.
     *
     * @param shouldThrowException Determines if the DAO should throw an exception
     */
    public TranscriptDAO(boolean shouldThrowException) {
        this.shouldThrowException = shouldThrowException;
    }

    /**
     * Default constructor that does not throw exceptions.
     */
    public TranscriptDAO() {
        this(false);
    }

    /**
     * Returns a mock Transcript or throws an exception based on configuration.
     *
     * @param youtubeURL The YouTube URL for the transcript
     * @return A mock Transcript object
     * @throws RuntimeException if shouldThrowException is true
     */
    @Override
    public Transcript getTranscript(String youtubeURL) {
        if (shouldThrowException) {
            // Throwing the custom exception with a descriptive message
            throw new RuntimeException("Simulated DAO exception");
        }

        // Return a mock Transcript object
        String mockTranscript = "This is a mock transcript for URL: " + youtubeURL;
        return new Transcript(mockTranscript, youtubeURL);
    }
}
