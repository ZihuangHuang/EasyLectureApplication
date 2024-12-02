package interface_adapter.transcript;

import use_case.transcript.TranscriptOutputBoundary;
import use_case.transcript.TranscriptOutputData;


/**
 * Presenter class that formats and presents the transcription
 */
public class TranscriptPresenter implements TranscriptOutputBoundary {
    private final TranscriptViewModel transcriptViewModel;

    public TranscriptPresenter(TranscriptViewModel transcriptViewModel){
        this.transcriptViewModel = transcriptViewModel;
    }

    /**
     * Prepares the success view for the Transcription related Use Case
     *
     * @param transcription retrieve the output data
     */
    @Override
    public void prepareSuccessView(TranscriptOutputData transcription) {
        transcriptViewModel.setTranscript(transcription.getTranscript());
    }
    /**
     * Prepares the failure view for the Transcription Use Cases.
     *
     * @param error the explanation of the failure
     */
    @Override
    public void prepareFailView(String error){
        transcriptViewModel.setTranscript("Error:" + error);
    }
}
