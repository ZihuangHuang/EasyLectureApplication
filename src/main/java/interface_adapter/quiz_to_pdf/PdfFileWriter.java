package interface_adapter.quiz_to_pdf;

import com.itextpdf.text.DocumentException;
import entity.JsonQuizFile;
import use_case.quiz_to_pdf.PdfGenerator;
import use_case.summary_to_quiz.SummaryToQuizOutputData;

import java.io.IOException;

//initiates JsonFileReader and execute JsonDataAccess into a PDF for PdfGenerator to use
public class PdfFileWriter {
    private final PdfGenerator converter;

    public PdfFileWriter(PdfGenerator converter) {
        this.converter = converter;
    }

    public void writePdf(String jsonFilePath, String outputPdfPath) throws IOException, DocumentException {
        PdfController reader = new PdfController();
        JsonQuizFile jsonData = reader.readJsonFromFile(jsonFilePath);
        PdfGenerator.execute();
    }
}

