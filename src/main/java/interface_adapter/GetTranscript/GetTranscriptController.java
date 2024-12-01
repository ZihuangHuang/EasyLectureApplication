package interface_adapter.GetTranscript;

import use_case.GetTranscript.GetTranscriptInputBoundary;
import use_case.GetTranscript.GetTranscriptInputData;

public class GetTranscriptController {
    private final GetTranscriptInputBoundary interactor;
    private final GetTranscriptPresenter presenter;

    // Constructor to initialize the controller with the interactor and presenter
    public GetTranscriptController(GetTranscriptInputBoundary interactor, GetTranscriptPresenter presenter) {
        this.interactor = interactor;
        this.presenter = presenter;
    }

    // This method triggers the execution of the GetTranscript Use Case and handles the output
    public void fetchTranscript(GetTranscriptInputData inputData) {
        interactor.execute(inputData);
    }
}
