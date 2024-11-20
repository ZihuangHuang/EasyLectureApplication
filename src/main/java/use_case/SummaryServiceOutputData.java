package use_case;
import java.util.List;
/**
 * Output Data for the commonSummaryFactory Use Case.
 */
public class SummaryServiceOutputData {

    private final String summaryText;
    private final List<String> topics;
    private final boolean useCaseFailed;

    public SummaryServiceOutputData(String summaryText, List<String> topic, boolean useCaseFailed) {
        this.summaryText = summaryText;
        this.topics = topic;
        this.useCaseFailed = useCaseFailed;
    }

    public String getSummaryText() {
        return summaryText;
    }

    public List<String> getTopics() {
        return topics;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}

