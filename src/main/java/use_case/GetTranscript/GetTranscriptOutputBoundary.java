package use_case.GetTranscript;

/**
 * Output boundary for the GetTranscript Use Case.
 * Defines the interface for preparing the success or failure view.
 */
public interface GetTranscriptOutputBoundary {

    /**
     * Prepares the success view for the GetTranscript Use Case.
     * @param outputData the output data containing the path of the saved transcript
     */
    void prepareSuccessView(GetTranscriptOutputData outputData);

    /**
     * Prepares the failure view for the GetTranscript Use Case.
     * @param errorMessage the error message to be displayed
     */
    void prepareFailView(String errorMessage);
}
