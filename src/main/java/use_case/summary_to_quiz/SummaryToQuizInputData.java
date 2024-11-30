package use_case.summary_to_quiz;

/**
 * The input data for the commonQuizFactory Use Case.
 */
public class QuizServiceInputData {
    private final String transcript;

    public QuizServiceInputData(String transcript) {
        this.transcript = transcript;
    }

    String getTranscript() {
        return transcript;
    }
}
