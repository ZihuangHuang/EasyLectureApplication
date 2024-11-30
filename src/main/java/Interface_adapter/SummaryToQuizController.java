package interface_adapter;

import use_case.summary_to_quiz.SummaryToQuizInputBoundary;

/**
 * Controller class that handles user input for quiz.
 */
public class SummaryToQuizController {
    /**
     * The SummaryToQuizController.
     */
    private final SummaryToQuizInputBoundary summaryToQuizUseCaseInteractor;

    public SummaryController(SummaryServiceInputBoundary summaryServiceUseCaseInteractor) {
        this.summaryServiceUseCaseInteractor = summaryServiceUseCaseInteractor;
    }

    public SummaryToQuizController() {
        summaryToQuizUseCaseInteractor = null;
    }

    /**
     * Executes the summary Use Case.
     * @param transcript The transcript of the lecture to summarize.
     */
    public void execute(String transcript) {
        final SummaryServiceInputData summaryServiceInputData = new SummaryServiceInputData(transcript);
        summaryServiceUseCaseInteractor.execute(summaryServiceInputData);
    }
}