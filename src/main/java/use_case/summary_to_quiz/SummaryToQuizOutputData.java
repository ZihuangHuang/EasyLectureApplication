package use_case.summary_to_quiz;

import java.util.List;
/**
 * Output Data for the commonQuizFactory Use Case.
 */
public class QuizServiceOutputData {

    private final String summaryText;
    private final List<String> topics;
    private final boolean useCaseFailed;

    public QuizServiceOutputData(String summaryText, List<String> topic, boolean useCaseFailed) {
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
