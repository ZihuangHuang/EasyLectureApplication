package interface_adapter.transcript;

public interface TranscriptController {
    /**
     * Execute the transcript generation for a given YouTube URL
     * @param youtubeUrl the URL of the YouTube video
     */
    void execute(String youtubeUrl);
}