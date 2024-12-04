package interface_adapter.quiz_to_pdf;

import entity.JsonQuizFile;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

//reads Json file and execute into a JsonDataAccess format to be used by PdfFileWriter
public class PdfController {
    public JsonQuizFile readJsonFromFile(String jsonFilePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> data = objectMapper.readValue(new File(jsonFilePath), Map.class);
        return new JsonQuizFile(data);
    }
}

