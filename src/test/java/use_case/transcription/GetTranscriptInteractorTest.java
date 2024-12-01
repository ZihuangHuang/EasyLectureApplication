package use_case.transcription;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import use_case.GetTranscript.GetTranscriptInputData;
import use_case.GetTranscript.GetTranscriptInputBoundary;
import use_case.GetTranscript.GetTranscriptInteractor;
import use_case.GetTranscript.GetTranscriptOutputData;

/**
 * Test class for GetTranscriptInteractor.
 */
public class GetTranscriptInteractorTest {

    /**
     * Tests the successful execution of the interactor.
     */
    @Test
    public void testExecute_Success() {
        // Create the input data object
        String youtubeUrl = "https://www.youtube.com/watch?v=example";
        GetTranscriptInputData inputData = new GetTranscriptInputData(youtubeUrl);

        // Mock API client
        TestTranscriptApiClient apiClient = new TestTranscriptApiClient(false);

        // Create the presenter
        TestTranscriptPresenter presenter = new TestTranscriptPresenter();

        // Create the interactor
        GetTranscriptInputBoundary interactor = new GetTranscriptInteractor(presenter, apiClient);

        // Execute the interactor
        interactor.execute(inputData);

        // Validate the output data
        assertNotNull(presenter.outputData, "Output data should not be null");
        assertEquals("mock_transcript.txt", presenter.outputData.getTranscriptPath(), "Transcript path does not match");

        // Check that the transcript file was created with mock data
        try {
            String content = Files.readString(Paths.get("mock_transcript.txt"));
            assertTrue(content.contains("Mock transcript line 1"), "Transcript content does not match expected output");
        } catch (IOException e) {
            fail("Transcript file could not be read");
        }
    }

    /**
     * Tests the execution of the interactor when an error occurs during the API call.
     */
    @Test
    public void testExecute_Failure() {
        // Create the input data object
        String youtubeUrl = "https://www.youtube.com/watch?v=example";
        GetTranscriptInputData inputData = new GetTranscriptInputData(youtubeUrl);

        // Mock API client that throws an exception
        TestTranscriptApiClient apiClient = new TestTranscriptApiClient(true);

        // Create the presenter
        TestTranscriptPresenter presenter = new TestTranscriptPresenter();

        // Create the interactor
        GetTranscriptInputBoundary interactor = new GetTranscriptInteractor(presenter, apiClient);

        // Execute the interactor
        interactor.execute(inputData);

        // Validate the failure output
        assertNull(presenter.outputData, "Output data should be null on failure");
        assertNotNull(presenter.errorMessage, "Error message should not be null");
        assertEquals("Failed to fetch transcript: Simulated API error", presenter.errorMessage, "Error message does not match");
    }

    /**
     * Mock API client for testing.
     */
    private static class TestTranscriptApiClient implements TranscriptApiClient {
        private final boolean shouldThrowError;

        public TestTranscriptApiClient(boolean shouldThrowError) {
            this.shouldThrowError = shouldThrowError;
        }

        @Override
        public JSONObject fetchTranscript(String youtubeUrl) throws Exception {
            if (shouldThrowError) {
                throw new Exception("Simulated API error");
            }
            // Mock API response
            JSONObject jsonResponse = new JSONObject();
            JSONArray contentArray = new JSONArray();
            contentArray.put(new JSONObject().put("text", "Mock transcript line 1"));
            contentArray.put(new JSONObject().put("text", "Mock transcript line 2"));
            jsonResponse.put("content", contentArray);
            return jsonResponse;
        }
    }

    /**
     * Mock presenter for testing.
     */
    private static class TestTranscriptPresenter implements GetTranscriptOutputBoundary {
        GetTranscriptOutputData outputData;
        String errorMessage;

        @Override
        public void prepareSuccessView(GetTranscriptOutputData outputData) {
            this.outputData = outputData;
        }

        @Override
        public void prepareFailView(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }
}
