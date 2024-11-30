package use_case.summary_to_quiz;

/**
 * The output boundary for the Login Use Case.
 */
public interface QuizServiceOutputBoundary {
        /**
         * Prepares the success view for the Login Use Case.
         * @param outputData the output data
         */
        void prepareSuccessView(QuizServiceOutputData outputData);

        /**
         * Prepares the failure view for the Login Use Case.
         * @param errorMessage the explanation of the failure
         */
        void prepareFailView(String errorMessage);
    }
