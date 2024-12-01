package use_case.summary_to_quiz;

/**
 * Input Boundary for actions which are related to summary to quiz.
 */

public interface SummaryToQuizInputBoundary {
    /**
     * Executes the SummaryToQuiz use case.
     * @param summaryToQuizInputData the input data
     */
    void execute(SummaryToQuizInputData summaryToQuizInputData);
}
