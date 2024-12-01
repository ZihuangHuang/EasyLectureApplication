package interface_adapter.transcript;

import use_case.transcript.TranscriptInputBoundary;
import use_case.transcript.TranscriptInputData;

/**
 * Controller class that handles user input for transcription retrieval.
 */
public class TranscriptController {
    /**
     * The Interactor for handling transcription-related use cases.
     */
    private final TranscriptInputBoundary transcriptInteractor;

    /**
     * Constructs the TranscriptController.
     * @param transcriptInteractor The interactor implementing the transcription use case.
     */
    public TranscriptController(TranscriptInputBoundary transcriptInteractor) {
        this.transcriptInteractor = transcriptInteractor; // DEPENDENCY INJECTION
    }

    /**
     * Executes the transcription use case.
     * @param youtubeURL The URL of the video to get transcription from.
     */
    public void execute(String youtubeURL) {
        if (youtubeURL == null || youtubeURL.isEmpty()) {
            throw new IllegalArgumentException("YouTube URL cannot be null or empty");
        }

        // Prepare input data for the interactor
        final TranscriptInputData transcriptionInputData = new TranscriptInputData(youtubeURL);

        // Delegate the execution to the interactor
        try {
            transcriptInteractor.execute(transcriptionInputData);
        } catch (Exception e) {
            // Handle exceptions (log, rethrow, or notify the view)
            System.err.println("Error executing transcription use case: " + e.getMessage());
            throw e; // Or handle gracefully depending on requirements
        }
    }
}
