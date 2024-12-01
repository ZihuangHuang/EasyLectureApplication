package interface_adapter.GetTranscript;

import use_case.GetTranscript.GetTranscriptOutputBoundary;
import use_case.GetTranscript.GetTranscriptOutputData;

/**
 * Presenter for the GetTranscript Use Case.
 * Prepares the output view based on the result from the interactor.
 */
public class GetTranscriptPresenter implements GetTranscriptOutputBoundary {
    private final GetTranscriptViewModel viewModel;

    /**
     * Constructor to initialize the presenter.
     * @param viewModel the view model that will hold the state of the view
     */
    public GetTranscriptPresenter(GetTranscriptViewModel viewModel) {
        this.viewModel = viewModel;
    }

    /**
     * Prepares the success view for the GetTranscript Use Case.
     * @param outputData the output data containing the path of the saved transcript
     */
    @Override
    public void prepareSuccessView(GetTranscriptOutputData outputData) {
        viewModel.setTranscriptPath(outputData.getTranscriptPath());
        viewModel.setMessage("Transcript fetched successfully!");
    }

    /**
     * Prepares the failure view for the GetTranscript Use Case.
     * @param errorMessage the error message to be displayed
     */
    @Override
    public void prepareFailView(String errorMessage) {
        viewModel.setMessage("Error: " + errorMessage);
    }
}
