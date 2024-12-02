package interface_adapter.transcript;

import use_case.transcript.TranscriptInputBoundary;
import use_case.transcript.TranscriptInputData;

public class TranscriptControllerImpl implements TranscriptController {
    private final TranscriptInputBoundary transcriptUseCase;

    public TranscriptControllerImpl(TranscriptInputBoundary transcriptUseCase) {
        this.transcriptUseCase = transcriptUseCase;
    }

    @Override
    public void execute(String youtubeUrl) {
        TranscriptInputData inputData = new TranscriptInputData(youtubeUrl);
        transcriptUseCase.execute(inputData);
    }
}