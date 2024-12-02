package interface_adapter.quiz_to_pdf;

import entity.JsonDataAccess;
import use_case.PdfGenerator;

import java.io.IOException;

public class PdfFileWriter {
    private final PdfGenerator converter;

    public PdfFileWriter(PdfGenerator converter) {
        this.converter = converter;
    }

    public void writePdf(String jsonFilePath, String outputPdfPath) throws IOException {
        JsonFileReader reader = new JsonFileReader();
        JsonDataAccess jsonData = reader.readJsonFromFile(jsonFilePath);
        converter.convert(jsonData, outputPdfPath);
    }
}

