package entity;

public class Transcript {
    private final String transcript;
    private final String url;

    public Transcript(String transcript, String url){
        this.transcript = transcript;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public String getTranscript() {
        return transcript;
    }
}
