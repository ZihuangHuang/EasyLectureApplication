package use_case.quiz_to_pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import entity.JsonQuizFile;
import interface_adapter.quiz_to_pdf.PdfController;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class PdfGeneratorInteractor implements PdfGeneratorInputBoundary {
    private final PdfGeneratorOutputBoundary outputBoundary;

    public PdfGeneratorInteractor(PdfGeneratorOutputBoundary outputBoundary) {
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void generate(PdfGeneratorInputData inputData) {
        String jsonFilePath = inputData.getJsonFilePath();
        String outputPdfPath = inputData.getOutputPdfPath();

        try {
            // Step 1: Read JSON data
            PdfController reader = new PdfController();
            JsonQuizFile jsonData = reader.readJsonFromFile(jsonFilePath);

            // Step 2: Generate PDF
            OutputStream outputStream = Files.newOutputStream(Paths.get(outputPdfPath));
            Document document = new Document();
            PdfWriter.getInstance(document, outputStream);
            document.open();

            for (Map.Entry<String, Object> entry : jsonData.getData().entrySet()) {
                document.add(new Paragraph(entry.getKey() + ": " + entry.getValue()));
            }

            document.close();
            outputStream.close();

            // Notify success
            outputBoundary.present(new PdfGeneratorOutputData(true, "PDF generated: " + outputPdfPath));
        } catch (IOException | DocumentException e) {
            // Notify failure
            outputBoundary.present(new PdfGeneratorOutputData(false, "Cannot generate PDF: " + e.getMessage()));
        }
    }

}

