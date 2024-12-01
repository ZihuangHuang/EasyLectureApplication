package use_case.transcript;

/**
 * Interactor for handling transcript retrieval requests.
 * Implements Template Method Pattern for execution flow and Strategy Pattern for error handling.
 */
public class TranscriptInteractor implements TranscriptInputBoundary {
    private final TranscriptDataUserAccessInterface transcriptDataAccessObject;
    private final TranscriptOutputBoundary transcriptPresenter;
    private final TranscriptValidator transcriptValidator;

    /**
     * Constructs a new TranscriptInteractor with required dependencies.
     *
     * @param transcriptDataAccessObject Data access object for retrieving transcripts
     * @param transcriptPresenter Presenter for preparing the view
     * @param transcriptValidator Validator for URL validation (optional, can be null)
     */
    public TranscriptInteractor(
            TranscriptDataUserAccessInterface transcriptDataAccessObject,
            TranscriptOutputBoundary transcriptPresenter,
            TranscriptValidator transcriptValidator) {
        this.transcriptDataAccessObject = transcriptDataAccessObject;
        this.transcriptPresenter = transcriptPresenter;
        this.transcriptValidator = transcriptValidator != null ?
                transcriptValidator : new DefaultTranscriptValidator();
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
            // Step 1: Validate input
            validateInput(transcriptInputData);

            // Step 2: Process request
            String youtubeUrl = transcriptInputData.getYoutubeURL();
            entity.Transcript transcript = transcriptDataAccessObject.getTranscript(youtubeUrl);

            // Step 3: Prepare success response
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
    private void validateInput(TranscriptInputData inputData) {
        if (!transcriptValidator.isValidUrl(inputData.getYoutubeURL())) {
            throw new IllegalArgumentException("Invalid YouTube URL format");
        }
    }
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