package use_case.transcript;
/**
 * Input data for Transcription use case
 */
public class TranscriptInputData {
    private final String youtubeURL;
    /**
     * Constructs a new instance with the specified youtubeURL.
     *
     * @param youtubeURL: the url of the lecture video.
     */

    public TranscriptInputData(String youtubeURL) {
        if (youtubeURL == null || youtubeURL.isEmpty()) {
            throw new IllegalArgumentException("Youtube URL cannot be null or empty");
        }
        this.youtubeURL = youtubeURL;
    }

    /**
     * Returns youtube URL
     *
     * @return youtube URL
     */
    public String getYoutubeURL() {
        return youtubeURL;
    }
}
