package use_case.quiz_to_pdf;

public class PdfGeneratorInputData {
    private final String jsonFilePath;
    private final String outputPdfPath;

    public PdfGeneratorInputData(String jsonFilePath, String outputPdfPath) {
        this.jsonFilePath = jsonFilePath;
        this.outputPdfPath = outputPdfPath;
    }

    public String getJsonFilePath() {
        return jsonFilePath;
    }

    public String getOutputPdfPath() {
        return outputPdfPath;
    }
}

