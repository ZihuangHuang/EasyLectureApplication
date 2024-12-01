package use_case.GetTranscript;

/**
 * Output data for the GetTranscript Use Case.
 * Contains the result of the GetTranscript operation.
 */
public class GetTranscriptOutputData {
    private final String transcriptPath;

    /**
     * Constructor to initialize the output data.
     * @param transcriptPath the path where the transcript is saved
     */
    public GetTranscriptOutputData(String transcriptPath) {
        this.transcriptPath = transcriptPath;
    }

    /**
     * Gets the path where the transcript is saved.
     * @return the path of the saved transcript
     */
    public String getTranscriptPath() {
        return transcriptPath;
    }
}
