package use_case.Summary;
/**
 * The commonSummaryFactory Service Use Case.
 */
public interface SummaryServiceInputBoundary {

    /**
     * Execute the commonSummaryFactory Use Case.
     * @param summaryServiceInputData the input data for this use case
     */
    void execute(SummaryServiceInputData summaryServiceInputData);
}
