package use_case.summary_to_quiz;

/**
 * The output boundary for the SummaryToQuiz Case.
 */
public interface SummaryToQuizOutputBoundary {
    /**
     * Prepares the success view for the SummaryToQuiz Use Case.
     *
     * @param outputData the output data
     */
    static void prepareSuccessView(SummaryToQuizOutputData outputData) {

    }

    /**
     * Prepares the failure view for the SummaryToQuiz Use Case.
     *
     * @param errorMessage the explanation of the failure
     */
    static void prepareFailView(String errorMessage) {
        
    }
}
