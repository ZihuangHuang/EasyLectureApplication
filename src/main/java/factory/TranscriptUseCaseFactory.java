package factory;

import data_access.transcript.TranscriptDAO;
import interface_adapter.transcript.TranscriptPresenter;
import use_case.transcript.TranscriptDataUserAccessInterface;
import use_case.transcript.TranscriptOutputBoundary;
import use_case.transcript.TranscriptInputBoundary;
import use_case.transcript.TranscriptInteractor;
import view.transcript.TranscriptView;

/**
 * Factory class for creating and wiring transcript-related components
 */
public class TranscriptUseCaseFactory {
    private static final String API_KEY = "e0a48d17cemshc6cc044bc5093cep180108jsn722dec23cf18";  // In real app, get from config/env

    /**
     * Creates a fully configured transcript use case with all its dependencies
     * @param view The view that will display the results
     * @return Configured TranscriptInputBoundary
     */
    public static TranscriptInputBoundary createTranscriptUseCase(TranscriptView view) {
        // Create the DAO with API key
        TranscriptDataUserAccessInterface transcriptDAO = new TranscriptDAO(API_KEY);

        // Create the presenter
        TranscriptOutputBoundary presenter = new TranscriptPresenter(view);

        // Create and return the interactor with all its dependencies
        return new TranscriptInteractor(transcriptDAO, presenter);
    }
}