package entity;

import java.util.Map;

public class JsonDataAccess {
    private Map<String, Object> data;

    public JsonDataAccess(Map<String, Object> data) {
        this.data = data;
    }

    public Map<String, Object> getData() {
        return data;
    }
}