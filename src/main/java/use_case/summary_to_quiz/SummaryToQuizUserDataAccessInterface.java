package use_case.summary_to_quiz;

import entity.Quiz;

/**
 * DAO for the SummaryToQuiz Use Case.
 */
public interface SummaryToQuizUserDataAccessInterface {
    /**
     * Generate the quiz given a summary.
     *
     * @param summary from the input.
     * @return The quiz.
     */
    static Quiz getQuiz(String summary) {
        return null;
    }
    // more methods may be added here.
}
