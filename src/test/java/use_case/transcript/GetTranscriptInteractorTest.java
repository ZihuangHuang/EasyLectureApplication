package use_case.transcript;

import entity.Transcript;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TranscriptInteractorTest {

    private class SuccessfulMockDAO implements TranscriptDataUserAccessInterface {
        @Override
        public Transcript getTranscript(String youtubeUrl) {
            return new Transcript("Sample transcript for " + youtubeUrl, youtubeUrl);
        }
    }

    private class InvalidURLMockDAO implements TranscriptDataUserAccessInterface {
        @Override
        public Transcript getTranscript(String youtubeUrl) {
            throw new IllegalArgumentException("Invalid URL format");
        }
    }

    private class RuntimeErrorMockDAO implements TranscriptDataUserAccessInterface {
        @Override
        public Transcript getTranscript(String youtubeUrl) {
            throw new RuntimeException("Network error");
        }
    }

    private class TestPresenter implements TranscriptOutputBoundary {
        private String preparedTranscript;
        private boolean successCalled = false;
        private boolean failCalled = false;

        @Override
        public void prepareSuccessView(TranscriptOutputData transcription) {
            this.preparedTranscript = transcription.getTranscript();
            this.successCalled = true;
        }

        @Override
        public void prepareFailView(String error) {
            this.preparedTranscript = error;
            this.failCalled = true;
        }

        public String getPreparedTranscript() {
            return preparedTranscript;
        }

        public boolean isSuccessCalled() {
            return successCalled;
        }

        public boolean isFailCalled() {
            return failCalled;
        }
    }

    @Test
    void execute_WhenValidURL_ShouldPrepareSuccessView() {
        // Arrange
        String validUrl = "https://youtube.com/validurl";
        TranscriptInputData inputData = new TranscriptInputData(validUrl);
        TestPresenter testPresenter = new TestPresenter();
        TranscriptInteractor interactor = new TranscriptInteractor(
                new SuccessfulMockDAO(),
                testPresenter
        );

        // Act
        interactor.execute(inputData);

        // Assert
        assertTrue(testPresenter.isSuccessCalled());
        assertFalse(testPresenter.isFailCalled());
        assertEquals("Sample transcript for " + validUrl, testPresenter.getPreparedTranscript());
    }

    @Test
    void execute_WhenInvalidURL_ShouldPrepareFailView() {
        // Arrange
        String invalidUrl = "invalid-url";
        TranscriptInputData inputData = new TranscriptInputData(invalidUrl);
        TestPresenter testPresenter = new TestPresenter();
        TranscriptInteractor interactor = new TranscriptInteractor(
                new InvalidURLMockDAO(),
                testPresenter
        );

        // Act
        interactor.execute(inputData);

        // Assert
        assertFalse(testPresenter.isSuccessCalled());
        assertTrue(testPresenter.isFailCalled());
        assertTrue(testPresenter.getPreparedTranscript().contains("Invalid YouTube URL"));
    }

    @Test
    void execute_WhenRuntimeErrorOccurs_ShouldPrepareFailView() {
        // Arrange
        String url = "https://youtube.com/error-url";
        TranscriptInputData inputData = new TranscriptInputData(url);
        TestPresenter testPresenter = new TestPresenter();
        TranscriptInteractor interactor = new TranscriptInteractor(
                new RuntimeErrorMockDAO(),
                testPresenter
        );

        // Act
        interactor.execute(inputData);

        // Assert
        assertFalse(testPresenter.isSuccessCalled());
        assertTrue(testPresenter.isFailCalled());
        assertTrue(testPresenter.getPreparedTranscript().contains("Error retrieving transcript"));
    }
}