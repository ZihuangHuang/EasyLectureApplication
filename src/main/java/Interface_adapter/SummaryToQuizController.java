package Interface_adapter;

import use_case.summary_to_quiz.SummaryToQuizInputBoundary;
import use_case.summary_to_quiz.SummaryToQuizInputData;

/**
 * Controller class that handles user input for quiz.
 */
public class SummaryToQuizController {
    /**
     * The SummaryToQuizController.
     */
    private final SummaryToQuizInputBoundary summaryToQuizUseCaseInteractor;

    public SummaryToQuizController(SummaryToQuizInputBoundary summaryServiceUseCaseInteractor) {
        this.summaryToQuizUseCaseInteractor = summaryServiceUseCaseInteractor;
    }

    public SummaryToQuizController() {
        summaryToQuizUseCaseInteractor = null;
    }

    /**
     * Executes the summarytoquiz Use Case.
     * @param summary The summary of the lecture to generate the quiz.
     */
    public void execute(String summary) {
        final SummaryToQuizInputData summaryToQuizInputData = new SummaryToQuizInputData(summary);
        summaryToQuizUseCaseInteractor.execute(summaryToQuizInputData);
    }
}