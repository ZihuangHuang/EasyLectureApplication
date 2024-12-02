package use_case;

import com.itextpdf.text.DocumentException;
import entity.JsonDataAccess;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

//Use case to combine all functions and generate the PDF
public class PdfGenerator {
    public void execute(JsonDataAccess jsonData, String outputPdfPath) throws IOException, DocumentException {
        OutputStream outputStream = Files.newOutputStream(Paths.get(outputPdfPath));

        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);
        document.open();

        // Convert JSON data to PDF content
        for (Map.Entry<String, Object> entry : jsonData.getData().entrySet()) {
            document.add(new Paragraph(entry.getKey() + ": " + entry.getValue()));
        }

        document.close();
        System.out.println("PDF generated: " + outputPdfPath);
    }
}

