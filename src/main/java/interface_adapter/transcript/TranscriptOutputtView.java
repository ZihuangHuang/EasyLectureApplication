package interface_adapter.transcript;

/**
 * Interface OutputView - intermediary between Transcript Presenter and Transcript View
 * Avoids violation of DIP
 */

public interface TranscriptOutputtView {
    void setTranscript(String transcript);
}
