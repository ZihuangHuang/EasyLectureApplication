package use_case.summary_to_quiz;

/**
 * DAO for the QuizService Use Case.
 */
public interface QuizServiceUserDataAccessInterface {
    /**
     * Summarizes the content given a transcript.
     * @param lecture the transcript fetched from a YouTube URL.
     * @return The summary
     */
    Summary getSummary(Lecture lecture);
}
