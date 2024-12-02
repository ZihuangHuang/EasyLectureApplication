package app;

import interface_adapter.quiz_to_pdf.PdfFileWriter;
import use_case.PdfGenerator;

import java.io.IOException;

public class JsonToPdfService {
    private final PdfFileWriter pdfWriter;

    public JsonToPdfService() {
        PdfGenerator converter = new PdfGenerator();
        this.pdfWriter = new PdfFileWriter(converter);
    }

    public void generatePdf(String jsonFilePath, String outputPdfPath) {
        try {
            pdfWriter.writePdf(jsonFilePath, outputPdfPath);
        } catch (IOException e) {
            System.err.println("Error generating PDF: " + e.getMessage());
        }
    }
}
