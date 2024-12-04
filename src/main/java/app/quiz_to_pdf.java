package app;

import com.itextpdf.text.DocumentException;
import interface_adapter.quiz_to_pdf.PdfFileWriter;
import use_case.quiz_to_pdf.PdfGenerator;

import java.io.IOException;

public class quiz_to_pdf {
    private final PdfFileWriter pdfWriter;

    public quiz_to_pdf() {
        PdfGenerator converter = new use_case.quiz_to_pdf.PdfGenerator();
        this.pdfWriter = new PdfFileWriter(converter);
    }

    public void generatePdf(String jsonFilePath, String outputPdfPath) {
        try {
            pdfWriter.writePdf(jsonFilePath, outputPdfPath);
        } catch (IOException e) {
            System.err.println("Error generating PDF: " + e.getMessage());
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }
    }
}
