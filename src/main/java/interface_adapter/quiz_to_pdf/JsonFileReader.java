package interface_adapter.quiz_to_pdf;

import entity.JsonDataAccess;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonFileReader {
    public JsonDataAccess readJsonFromFile(String jsonFilePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> data = objectMapper.readValue(new File(jsonFilePath), Map.class);
        return new JsonDataAccess(data);
    }
}

