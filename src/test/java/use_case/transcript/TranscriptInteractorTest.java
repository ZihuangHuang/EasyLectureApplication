package use_case.transcript;

import entity.Transcript;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class TranscriptInteractorTest {
    private TranscriptDataUserAccessInterface mockDAO;
    private TranscriptOutputBoundary mockPresenter;
    private TranscriptInteractor interactor;
    private static final String VALID_URL = "https://youtube.com/watch?v=123";
    private static final String VALID_TRANSCRIPT = "Sample transcript text";

    @BeforeEach
    void setUp() {
        // Create mock objects
        mockDAO = Mockito.mock(TranscriptDataUserAccessInterface.class);
        mockPresenter = Mockito.mock(TranscriptOutputBoundary.class);

        // Create interactor with mock dependencies
        interactor = new TranscriptInteractor(mockDAO, mockPresenter);
    }

    @Test
    void execute_SuccessfulCase() {
        // Arrange
        TranscriptInputData inputData = new TranscriptInputData(VALID_URL);
        Transcript mockTranscript = new Transcript(VALID_TRANSCRIPT, VALID_URL);
        when(mockDAO.getTranscript(VALID_URL)).thenReturn(mockTranscript);

        // Act
        interactor.execute(inputData);

        // Assert
        verify(mockDAO).getTranscript(VALID_URL);
        verify(mockPresenter).prepareSuccessView(any(TranscriptOutputData.class));

        // Capture and verify the output data
        ArgumentCaptor<TranscriptOutputData> outputDataCaptor = ArgumentCaptor.forClass(TranscriptOutputData.class);
        verify(mockPresenter).prepareSuccessView(outputDataCaptor.capture());

        TranscriptOutputData capturedOutput = outputDataCaptor.getValue();
        assertEquals(VALID_TRANSCRIPT, capturedOutput.getTranscript());
        assertFalse(capturedOutput.isUseCaseFailed());
    }

    @Test
    void execute_DAOThrowsIllegalArgumentException() {
        // Arrange
        TranscriptInputData inputData = new TranscriptInputData(VALID_URL);
        String errorMessage = "Invalid URL format";
        when(mockDAO.getTranscript(VALID_URL))
                .thenThrow(new IllegalArgumentException(errorMessage));

        // Act
        interactor.execute(inputData);

        // Assert
        verify(mockPresenter).prepareFailView("Invalid YouTube URL: " + errorMessage);
    }

    @Test
    void execute_DAOThrowsRuntimeException() {
        // Arrange
        TranscriptInputData inputData = new TranscriptInputData(VALID_URL);
        String errorMessage = "API connection failed";
        when(mockDAO.getTranscript(VALID_URL))
                .thenThrow(new RuntimeException(errorMessage));

        // Act
        interactor.execute(inputData);

        // Assert
        verify(mockPresenter).prepareFailView("Error retrieving transcript: " + errorMessage);
    }
}