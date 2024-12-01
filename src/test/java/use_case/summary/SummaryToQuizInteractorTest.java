package use_case.summary;

import data_access.DataAccessObject;
import org.junit.jupiter.api.Test;
import use_case.summary_to_quiz.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SummaryToQuizInteractorTest {
     /**
             * Tests the successful execution of the interactor.
     */
    @Test
    public void testExecute_Success() {
        // Create the Input Data object
        String summary = "This is a sample summary for testing.";
        SummaryToQuizInputData inputData = new SummaryToQuizInputData(summary);

        // Create a presenter that implements the output boundary
        TestSummaryToQuizPresenter presenter = new TestSummaryToQuizPresenter();

        // Create the DAO (does not throw exception)
        SummaryToQuizUserDataAccessInterface quizDAO = new DataAccessObject();

        // Create the interactor and inject the presenter and DAO
        SummaryToQuizInputBoundary interactor = new QuizServiceInteractor(quizDAO, presenter);

        // Invoke the interactor with the input data
        interactor.execute(inputData);

        // Validate the output data
        assertNotNull(presenter.outputData, "Output data should not be null");
        assertFalse(presenter.outputData.isUseCaseFailed(), "Use case should not have failed");
        assertEquals("This is a mock summary of the lecture.", presenter.outputData.getcontent(), "Quiz content text does not match");
        List<String> expectedchoices = List.of("A: 1", "B: 2", "C: 3");
        assertEquals(expectedchoices, presenter.outputData.getchoices(), "Choices do not match");
    }

    /**
     * Tests the execution of the interactor when the DAO throws an exception.
     */
    @Test
    public void testExecute_Failure() {
        // Create the Input Data object
        String summary = "This is a sample summary for testing.";
        SummaryToQuizInputData inputData = new SummaryToQuizInputData(summary);

        // Create a presenter that implements the output boundary
        TestSummaryToQuizPresenter presenter = new TestSummaryToQuizPresenter();

        // Create the DAO that will throw an exception
        SummaryToQuizUserDataAccessInterface summaryDAO = new DataAccessObject(true);

        // Create the interactor and inject the presenter and DAO
        SummaryToQuizInputBoundary interactor = new QuizServiceInteractor(summaryDAO, presenter);

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
    private class TestSummaryToQuizPresenter implements SummaryToQuizOutputBoundary {
        SummaryToQuizOutputData outputData;
        String errorMessage;

        public void prepareSuccessView(SummaryToQuizOutputData outputData) {
            this.outputData = outputData;
        }

        public void prepareFailView(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }
}
