package interface_adapter.summary_to_quiz;

import use_case.summary_to_quiz.SummaryToQuizOutputBoundary;
import use_case.summary_to_quiz.SummaryToQuizOutputData;
/**
 * Presenter class that formats and presents the quizzes.
 */
public class SummaryToQuizPresenter implements SummaryToQuizOutputBoundary {
    private final SummaryToQuizViewModel summaryToQuizViewModel;

    public SummaryToQuizPresenter(SummaryToQuizViewModel summaryToQuizViewModel) {
        this.summaryToQuizViewModel = summaryToQuizViewModel;
    }

    /**
     * Prepares the success view for the quiz related Use Cases.
     *
     * @param quiz the output data
     */
    public void prepareSuccessView(SummaryToQuizOutputData quiz) {
        summaryToQuizViewModel.setQuiz(quiz.getcontent());
        summaryToQuizViewModel.setChoices(quiz.getchoices());

    }
    /**
     * Prepares the failure view for the quiz related Use Cases.
     *
     * @param errorMessage the explanation of the failure
     */
    public void prepareFailView(String errorMessage){
        summaryToQuizViewModel.setQuiz(null);
        summaryToQuizViewModel.setChoices(null);
    }


}
