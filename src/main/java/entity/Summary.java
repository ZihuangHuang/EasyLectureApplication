package entity;

import java.util.List;

public class Summary {
    private final String summaryText;
    private final List<String> topics;

    public Summary (String summaryText, List<String> topics) {
        this.summaryText = summaryText;
        this.topics = topics;
    }

    public String getSummaryText() {
        return summaryText;
    }

    public List<String> getTopics() {
        return topics;
    }
}
