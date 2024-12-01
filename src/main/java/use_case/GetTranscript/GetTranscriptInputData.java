package use_case.GetTranscript;

/**
 * Input data for the GetTranscript Use Case.
 * Contains the information required to fetch the transcript.
 */
public class GetTranscriptInputData {
    private final String youtubeUrl;

    /**
     * Constructor to initialize the input data.
     * @param youtubeUrl the YouTube video URL for which the transcript is requested
     */
    public GetTranscriptInputData(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

    /**
     * Gets the YouTube video URL.
     * @return the YouTube video URL
     */
    public String getYoutubeUrl() {
        return youtubeUrl;
    }
}
