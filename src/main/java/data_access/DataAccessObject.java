package data_access;

import entity.Quiz;
import use_case.summary_to_quiz.SummaryToQuizUserDataAccessInterface;

import java.util.Arrays;
import java.util.List;

/**
 * Mock DAO implementation for testing purposes.
 */
public class DataAccessObject implements SummaryToQuizUserDataAccessInterface {
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
     * Returns a mock Quiz or throws an exception based on configuration.
     *
     * @param summary The summary object.
     * @return A mock Quiz object.
     */
    public Quiz getQuiz(String summary) {
        if (shouldThrowException) {
            throw new RuntimeException("Simulated DAO exception");
        }
        // Return a fixed-content quiz and topics for testing
        String quizText = "This is a mock summary of the lecture.";
        List<String> choices = Arrays.asList("A: 1", "B: 2", "C: 3");
        String answer = new String("A");
        return new Quiz(quizText, choices, answer);
    }
}
