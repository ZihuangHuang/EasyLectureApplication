package use_case.quiz_to_pdf;

import use_case.quiz_to_pdf.PdfGeneratorInputData;

public class PdfGeneratorUserAccessInterface {
    private final use_case.quiz_to_pdf.PdfGeneratorInputBoundary inputBoundary;

    public PdfGeneratorUserAccessInterface(use_case.quiz_to_pdf.PdfGeneratorInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public void generatePdf(String jsonFilePath, String outputPdfPath) {
        PdfGeneratorInputData inputData = new PdfGeneratorInputData(jsonFilePath, outputPdfPath);
        inputBoundary.generate(inputData);
    }
}
