package interface_adapter.Summary;

import use_case.Summary.SummaryServiceInputBoundary;
import use_case.Summary.SummaryServiceInputData;

/**
 * Controller class that handles user input for lecture summarization.
 */
public class SummaryController {
    /**
     * The SummaryController.
     */
    private final SummaryServiceInputBoundary summaryServiceUseCaseInteractor;

    public SummaryController(SummaryServiceInputBoundary summaryServiceUseCaseInteractor) {
        this.summaryServiceUseCaseInteractor = summaryServiceUseCaseInteractor;
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
