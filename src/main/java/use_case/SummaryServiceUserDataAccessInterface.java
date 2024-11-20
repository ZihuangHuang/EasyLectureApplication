package use_case;

import entity.Lecture;
import entity.Summary;

/**
 * The interface of the DAO for the commonSummaryFactory Use Case.
 */
public interface SummaryServiceUserDataAccessInterface {

    /**
     * Summarizes the content given a transcript.
     * @param lecture the transcript fetched from a YouTube URL.
     * @return The summary
     */
    Summary getSummary(Lecture lecture);
}
