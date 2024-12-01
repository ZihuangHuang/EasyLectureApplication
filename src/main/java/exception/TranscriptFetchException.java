package exception;

public class TranscriptFetchException extends Exception {

    // Constructor that accepts a message
    public TranscriptFetchException(String message) {
        super(message);
    }

    // Constructor that accepts a message and a cause (another throwable)
    public TranscriptFetchException(String message, Throwable cause) {
        super(message, cause);
    }
}
