package use_case;

/**
 * The output boundary for the commonSummaryFactory Use Case.
 */
public interface SummaryServiceOutputBoundary {
    /**
     * Prepares the success view for the commonSummaryFactory Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(SummaryServiceOutputData outputData);

    /**
     * Prepares the failure view for the commonSummaryFactory Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
