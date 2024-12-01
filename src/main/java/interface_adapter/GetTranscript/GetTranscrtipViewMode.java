package interface_adapter.GetTranscript;

/**
 * ViewModel for the GetTranscript Use Case.
 * Holds the state of the view, such as the transcript path and message.
 */
public class GetTranscriptViewModel {
    private String transcriptPath;
    private String message;

    /**
     * Gets the path where the transcript is saved.
     * @return the path of the saved transcript
     */
    public String getTranscriptPath() {
        return transcriptPath;
    }

    /**
     * Sets the path where the transcript is saved.
     * @param transcriptPath the path of the saved transcript
     */
    public void setTranscriptPath(String transcriptPath) {
        this.transcriptPath = transcriptPath;
    }

    /**
     * Gets the message to be displayed in the view.
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message to be displayed in the view.
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
