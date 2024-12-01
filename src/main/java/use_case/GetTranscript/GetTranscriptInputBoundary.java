package use_case.GetTranscript;

/**
 * Input boundary for the GetTranscript Use Case.
 */
public interface GetTranscriptInputBoundary {

    /**
     * Executes the GetTranscript Use Case.
     * @param getTranscriptInputData the input data for this use case
     */
    void execute(GetTranscriptInputData getTranscriptInputData);
}
