package entity;

/**
 * A simple implementation of the Lecture interface.
 */
public class Lecture{

    private final String url;
    private final String transcript;

    public Lecture(String url, String transcript) {
        this.url = url;
        this.transcript = transcript;
    }


    public String getUrl() {
        return url;
    }

    public String getTranscript() {
        return transcript;
    }
}
