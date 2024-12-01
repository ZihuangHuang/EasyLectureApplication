package use_case.transcript;

public class TranscriptOutputData {

    private final String transcript;
    private final boolean useCaseFailed;

    public TranscriptOutputData(String transcript, boolean useCaseFailed) {
        this.transcript = transcript;
        this.useCaseFailed = useCaseFailed;
    }

    public String getTranscript() {
        return transcript;
    }
    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
