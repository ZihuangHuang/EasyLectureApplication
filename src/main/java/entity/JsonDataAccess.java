package entity;

import java.util.Map;

//object to be used for PdfGenerator, converted from the Json file
public class JsonDataAccess {
    private Map<String, Object> data;

    public JsonDataAccess(Map<String, Object> data) {
        this.data = data;
    }

    public Map<String, Object> getData() {
        return data;
    }
}