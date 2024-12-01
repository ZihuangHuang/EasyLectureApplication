package data_access;

import entity.Summary;
import entity.Lecture;
import use_case.Summary.SummaryServiceUserDataAccessInterface;
import java.util.List;
import java.util.Arrays;
/**
 * Mock DAO implementation for testing purposes.
 */
public class DataAccessObject implements SummaryServiceUserDataAccessInterface {
    private final boolean shouldThrowException;

    /**
     * Constructs a MockSummaryDAO.
     *
     * @param shouldThrowException Determines if the DAO
     *                             should throw an exception.
     */
    public DataAccessObject(boolean shouldThrowException) {
        this.shouldThrowException = shouldThrowException;
    }

    /**
     * Default constructor that does not throw exceptions.
     */
    public DataAccessObject() {
        this(false);
    }

    /**
     * Returns a mock Summary or throws an exception based on configuration.
     *
     * @param lecture The Lecture object containing the transcript.
     * @return A mock Summary object.
     */
    @Override
    public Summary getSummary(Lecture lecture) {
        if (shouldThrowException) {
            throw new RuntimeException("Simulated DAO exception");
        }
        // Return a fixed summary and topics for testing
        String summaryText = "This is a mock summary of the lecture.";
        List<String> topics = Arrays.asList("Topic 1", "Topic 2", "Topic 3");
        return new Summary(summaryText, topics);
    }
}
