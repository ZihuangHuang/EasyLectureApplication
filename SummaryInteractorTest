package use_case.summary;
import data_access.DataAccessObject;
import entity.Summary;
import org.junit.jupiter.api.Test;
import use_case.SummaryServiceInputBoundary;
import use_case.SummaryServiceInputData;
import use_case.SummaryServiceInteractor;
import use_case.SummaryServiceUserDataAccessInterface;
import use_case.*;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;

/**
 * Test class for SummaryServiceInteractor.
 */
public class SummaryServiceInteractorTest {

    /**
     * Tests the successful execution of the interactor.
     */
    @Test
    public void testExecute_Success() {
        // Create the Input Data object
        String transcript = "This is a sample lecture transcript for testing.";
        SummaryServiceInputData inputData = new SummaryServiceInputData(transcript);

        // Create a presenter that implements the output boundary
        TestSummaryPresenter presenter = new TestSummaryPresenter();

        // Create the DAO (does not throw exception)
        SummaryServiceUserDataAccessInterface summaryDAO = new DataAccessObject();

        // Create the interactor and inject the presenter and DAO
        SummaryServiceInputBoundary interactor = new SummaryServiceInteractor(summaryDAO, presenter);

        // Invoke the interactor with the input data
        interactor.execute(inputData);

        // Validate the output data
        assertNotNull(presenter.outputData, "Output data should not be null");
        assertFalse(presenter.outputData.isUseCaseFailed(), "Use case should not have failed");
        assertEquals("This is a mock summary of the lecture.", presenter.outputData.getSummaryText(), "Summary text does not match");
        List<String> expectedTopics = List.of("Topic 1", "Topic 2", "Topic 3");
        assertEquals(expectedTopics, presenter.outputData.getTopics(), "Topics do not match");
    }

    /**
     * Tests the execution of the interactor when the DAO throws an exception.
     */
    @Test
    public void testExecute_Failure() {
        // Create the Input Data object
        String transcript = "This is a sample lecture transcript for testing.";
        SummaryServiceInputData inputData = new SummaryServiceInputData(transcript);

        // Create a presenter that implements the output boundary
        TestSummaryPresenter presenter = new TestSummaryPresenter();

        // Create the DAO that will throw an exception
        SummaryServiceUserDataAccessInterface summaryDAO = new DataAccessObject(true);

        // Create the interactor and inject the presenter and DAO
        SummaryServiceInputBoundary interactor = new SummaryServiceInteractor(summaryDAO, presenter);

        // Invoke the interactor with the input data
        interactor.execute(inputData);

        // Validate that the use case failed
        assertNull(presenter.outputData, "Output data should be null on failure");
        assertNotNull(presenter.errorMessage, "Error message should not be null");
        assertEquals("An error occurred while generating the summary.", presenter.errorMessage, "Error message does not match");
    }

    /**
     * Presenter class for testing that captures the output data.
     */
    private class TestSummaryPresenter implements SummaryServiceOutputBoundary {
        SummaryServiceOutputData outputData;
        String errorMessage;

        @Override
        public void prepareSuccessView(SummaryServiceOutputData outputData) {
            this.outputData = outputData;
        }

        @Override
        public void prepareFailView(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }
}
