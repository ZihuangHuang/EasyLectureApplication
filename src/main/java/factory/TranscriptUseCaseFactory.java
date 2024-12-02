package factory;

import data_access.transcript.TranscriptDAO;
import interface_adapter.transcript.TranscriptPresenter;
import interface_adapter.transcript.TranscriptViewModel;
import use_case.transcript.*;
import view.transcript.TranscriptView;

/**
 * Factory class for creating and wiring transcript-related components
 */
public class TranscriptUseCaseFactory {
    private static final String API_KEY = "e0a48d17cemshc6cc044bc5093cep180108jsn722dec23cf18";

    /**
     * Creates a fully configured transcript use case with all its dependencies
     * @param view The view that will display the results
     * @return Configured TranscriptInputBoundary
     */
    public static TranscriptInputBoundary createTranscriptUseCase(TranscriptView view) {
        // Create the ViewModel
        TranscriptViewModel viewModel = new TranscriptViewModel();

        // Create the DAO with API key
        TranscriptDataUserAccessInterface transcriptDAO = new TranscriptDAO(API_KEY);

        // Create the presenter with the ViewModel
        TranscriptOutputBoundary presenter = new TranscriptPresenter(viewModel);

        // Create and return the interactor with all its dependencies
        return new TranscriptInteractor(transcriptDAO, presenter);
    }
}