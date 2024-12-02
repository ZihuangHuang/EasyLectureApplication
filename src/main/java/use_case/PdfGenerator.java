package use_case;

import entity.JsonDataAccess;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.IOException;

public class PdfGenerator {
    public void convert(JsonDataAccess jsonData, String outputPdfPath) throws IOException {
        PdfWriter writer = new PdfWriter(outputPdfPath);
        PdfDocument pdfDoc = new PdfDocument(writer);
        Document document = new Document(pdfDoc);

        // Convert JSON data to PDF content
        for (Map.Entry<String, Object> entry : jsonData.getData().entrySet()) {
            document.add(new Paragraph(entry.getKey() + ": " + entry.getValue()));
        }

        document.close();
        System.out.println("PDF generated: " + outputPdfPath);
    }
}

