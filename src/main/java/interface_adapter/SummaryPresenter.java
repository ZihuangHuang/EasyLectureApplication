package interface_adapter;

import use_case.Summary.SummaryServiceOutputBoundary;
import use_case.Summary.SummaryServiceOutputData;
/**
 * Presenter class that formats and presents the summary and topics.
 */
public class SummaryPresenter implements SummaryServiceOutputBoundary {
    private final SummaryViewModel summaryViewModel;

    public SummaryPresenter(SummaryViewModel summaryViewModel) {
        this.summaryViewModel = summaryViewModel;
    }

    /**
     * Prepares the success view for the Summary related Use Cases.
     *
     * @param summary the output data
     */
    @Override
    public void prepareSuccessView(SummaryServiceOutputData summary) {
        summaryViewModel.setSummary(summary.getSummaryText());
        summaryViewModel.setTopics(summary.getTopics());

    }
    /**
     * Prepares the failure view for the Summary related Use Cases.
     *
     * @param errorMessage the explanation of the failure
     */
    @Override
    public void prepareFailView(String errorMessage){
        summaryViewModel.setSummary("Error:" + errorMessage);
        summaryViewModel.setTopics(null);
    }


}
