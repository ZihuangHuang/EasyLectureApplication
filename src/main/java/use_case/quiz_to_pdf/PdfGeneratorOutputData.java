package use_case.quiz_to_pdf;

public class PdfGeneratorOutputData {
    private final boolean success;
    private final String message;

    public PdfGeneratorOutputData(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
