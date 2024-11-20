package interface_adapter;

import use_case.SummaryServiceInputBoundary;
import use_case.SummaryServiceInputData;

/**
 * Controller class that handles user input for lecture summarization.
 */
public class SummaryController {
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
