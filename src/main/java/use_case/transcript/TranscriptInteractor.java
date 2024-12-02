package use_case.transcript;

/**
 * Interactor for handling transcript retrieval requests.
 */
public class TranscriptInteractor implements TranscriptInputBoundary {

    private final GenerateTranscript transcriptGenerator;
    private final TranscriptOutputBoundary transcriptOutputBoundary;

    /**
     * Constructs a new TranscriptInteractor with required dependencies.
     *
     * @param transcriptGenerator    Class responsible for generating transcripts.
     * @param transcriptOutputBoundary Interface to prepare the view output.
     */
    public TranscriptInteractor(
            GenerateTranscript transcriptGenerator,
            TranscriptOutputBoundary transcriptOutputBoundary) {
        this.transcriptGenerator = transcriptGenerator;
        this.transcriptOutputBoundary = transcriptOutputBoundary;
    }

    /**
     * Executes the transcript retrieval use case.
     *
     * @param transcriptInputData Input data containing the YouTube URL.
     */
    @Override
    public void execute(TranscriptInputData transcriptInputData) {
        try {
            // Step 1: Retrieve the YouTube URL from input data
            String youtubeUrl = transcriptInputData.getYoutubeURL();

            // Step 2: Use GenerateTranscript to retrieve the transcript
            String transcript = transcriptGenerator.retrieveTranscript(youtubeUrl);

            // Step 3: Create output data to store the transcript
            TranscriptOutputData outputData = new TranscriptOutputData(
                    transcript,
                    false // Use case succeeded
            );

            // Step 4: Pass the output data to the output boundary for view preparation
            transcriptOutputBoundary.prepareSuccessView(outputData);

        } catch (IllegalArgumentException e) {
            // Handle invalid input
            TranscriptOutputData outputData = new TranscriptOutputData(
                    "Invalid YouTube URL: " + e.getMessage(),
                    true // Use case failed
            );
            transcriptOutputBoundary.prepareFailView(outputData);

        } catch (RuntimeException e) {
            // Handle technical or API errors
            TranscriptOutputData outputData = new TranscriptOutputData(
                    "Error retrieving transcript: " + e.getMessage(),
                    true // Use case failed
            );
            transcriptOutputBoundary.prepareFailView(outputData);
        }
    }
}
