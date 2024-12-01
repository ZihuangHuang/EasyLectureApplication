package use_case.summary_to_quiz;

/**
 * The input data for the commonQuizFactory Use Case.
 */
public class SummaryToQuizInputData {
    private static String summary = "";

    public SummaryToQuizInputData(String summary) {
        this.summary = summary;
    }

    static String getSummary() {
        return summary;
    }
}
