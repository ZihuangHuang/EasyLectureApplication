package use_case.summary_to_quiz;

import entity.Quiz;

/**
 * The SummaryToQuiz Interactor.
 */
public class QuizServiceInteractor implements SummaryToQuizInputBoundary {
    private final SummaryToQuizUserDataAccessInterface quizDataAccessObject;
    private final SummaryToQuizOutputBoundary quizPresenter;

    public QuizServiceInteractor(SummaryToQuizUserDataAccessInterface quizDataAccessObject,
                                 SummaryToQuizOutputBoundary quizPresenter) {
        this.quizDataAccessObject = quizDataAccessObject;
        this.quizPresenter = quizPresenter;
    }

    @Override
    public void execute(SummaryToQuizInputData summaryServiceInputData) {
        try {
            // Assuming we have a way to get the summary, should be done by zihuang Huang.
            String summary = summaryServiceInputData.getSummary();
            Quiz quiz = SummaryToQuizUserDataAccessInterface.getQuiz(summary);

            SummaryToQuizOutputData outputData = new SummaryToQuizOutputData(
                    quiz.getcontent(),
                    quiz.getchoices(),
                    quiz.getanswer(),
                    false
            );

            SummaryToQuizOutputBoundary.prepareSuccessView(outputData);
        } catch (Exception e) {
            e.printStackTrace();
            SummaryToQuizOutputBoundary.prepareFailView("An error occurred while generating the quiz.");
        }
    }
}

