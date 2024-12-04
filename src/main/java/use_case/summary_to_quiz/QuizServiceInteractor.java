package use_case.summary_to_quiz;

import entity.Quiz;

/**
 * Interactor for converting a summary into a quiz.
 * Implements the SummaryToQuizInputBoundary, processing the input data,
 * delegating to the data access interface for quiz generation, and preparing
 * the output data for the presenter.
 */
public class QuizServiceInteractor implements SummaryToQuizInputBoundary {

    private final SummaryToQuizUserDataAccessInterface dataAccessInterface;
    private final SummaryToQuizOutputBoundary outputBoundary;

    /**
     * Constructs the interactor with the required data access and output boundary.
     *
     * @param dataAccessInterface the interface to handle data access, such as using the Cohere API.
     * @param outputBoundary the boundary for preparing and displaying the output.
     */
    public QuizServiceInteractor(SummaryToQuizUserDataAccessInterface dataAccessInterface,
                                 SummaryToQuizOutputBoundary outputBoundary) {
        this.dataAccessInterface = dataAccessInterface;
        this.outputBoundary = outputBoundary;
    }

    /**
     * Executes the use case for generating a quiz from a summary.
     *
     * @param inputData the input data containing the summary to convert.
     */
    @Override
    public void execute(SummaryToQuizInputData inputData) {
        try {
            // Extract the summary from input data
            String summary = inputData.getSummary();

            // Generate the quiz using the data access interface
            Quiz quiz = dataAccessInterface.generateQuiz(summary);

            // Create output data to pass to the presenter
            SummaryToQuizOutputData outputData = new SummaryToQuizOutputData(
                    quiz.getContent(),
                    quiz.getChoices(),
                    quiz.getAnswer(),
                    false
            );

            // Pass the success output to the presenter
            outputBoundary.prepareSuccessView(outputData);

        } catch (Exception e) {
            // Handle any errors during the quiz generation process
            e.printStackTrace();

            // Pass the failure message to the presenter
            outputBoundary.prepareFailView("An error occurred while generating the quiz.");
        }
    }
}
