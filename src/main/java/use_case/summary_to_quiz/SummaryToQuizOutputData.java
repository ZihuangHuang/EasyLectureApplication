package use_case.summary_to_quiz;

import java.util.List;
/**
 * Output Data for the commonQuizFactory Use Case.
 */
public class SummaryToQuizOutputData {

    private final String content;
    private final List<String> choices;
    private final String answer;
    private final boolean useCaseFailed;

    public SummaryToQuizOutputData(String content, List<String> choices, String answer, boolean useCaseFailed) {
        this.content = content;
        this.choices = choices;
        this.answer = answer;
        // maybe some exception-relating items added later.
        this.useCaseFailed = useCaseFailed;
    }

    public String getcontent() {
        return content;
    }

    public List<String> getchoices() {
        return choices;
    }

    public String getanswer() {
        return answer;
    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

}
