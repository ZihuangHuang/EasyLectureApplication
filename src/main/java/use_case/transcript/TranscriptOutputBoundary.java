package use_case.transcript;

/**
 * The output boundary for Transcription Use Case
 */
public interface TranscriptOutputBoundary {
    /**
     * Prepares the success view for the Transcription Use Case
     * @param outputData: the output data
     */
    public void prepareSuccessView(TranscriptOutputData outputData);

    /**
     * Prepares the failure view for the Transcription Use Case
     * @param errorMessage the explanation of the failure
     */
    public void prepareFailView(String errorMessage);
}
