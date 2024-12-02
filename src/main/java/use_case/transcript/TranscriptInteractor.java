package use_case.transcript;

/**
 * Interactor for handling transcript retrieval requests.
 * Implements Template Method Pattern for execution flow and Strategy Pattern for error handling.
 */
public class TranscriptInteractor implements TranscriptInputBoundary {
    private final TranscriptDataUserAccessInterface transcriptDataAccessObject;
    private final TranscriptOutputBoundary transcriptPresenter;

    /**
     * Constructs a new TranscriptInteractor with required dependencies.
     *
     * @param transcriptDataAccessObject Data access object for retrieving transcripts
     * @param transcriptPresenter Presenter for preparing the view
     */
    public TranscriptInteractor(
            TranscriptDataUserAccessInterface transcriptDataAccessObject,
            TranscriptOutputBoundary transcriptPresenter) {
        this.transcriptDataAccessObject = transcriptDataAccessObject;
        this.transcriptPresenter = transcriptPresenter;
    }

    /**
     * Executes the transcript retrieval use case.
     * Implements Template Method Pattern for the execution flow.
     *
     * @param transcriptInputData Input data containing YouTube URL
     */
    @Override
    public void execute(TranscriptInputData transcriptInputData) {
        try {

            // Step 1: Process request
            String youtubeUrl = transcriptInputData.getYoutubeURL();
            entity.Transcript transcript = transcriptDataAccessObject.getTranscript(youtubeUrl);

            // Step 2: Prepare success response
            TranscriptOutputData outputData = new TranscriptOutputData(
                    transcript.getTranscript(),
                    false
            );
            transcriptPresenter.prepareSuccessView(outputData);

        } catch (IllegalArgumentException e) {
            // Handle validation errors
            transcriptPresenter.prepareFailView("Invalid YouTube URL: " + e.getMessage());
        } catch (RuntimeException e) {
            // Handle technical errors
            transcriptPresenter.prepareFailView("Error retrieving transcript: " + e.getMessage());
        }
    }

    /**
     * Validates the input data using the validator strategy.
     *
     * @param inputData Input data to validate
     * @throws IllegalArgumentException if validation fails
     */
}

/**
 * Strategy interface for URL validation
 */
interface TranscriptValidator {
    boolean isValidUrl(String url);
}

/**
 * Default implementation of TranscriptValidator
 */
class DefaultTranscriptValidator implements TranscriptValidator {
    @Override
    public boolean isValidUrl(String url) {
        // Basic URL validation
        return url != null &&
                url.trim().length() > 0 &&
                url.toLowerCase().contains("youtube.com/");
    }
}