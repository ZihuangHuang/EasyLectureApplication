package use_case;

/**
 * The input data for the commonSummaryFactory Use Case.
 */
public class SummaryServiceInputData {
    private final String transcript;
    /**
     * Constructs a new {@code SummaryServiceInputData} instance with the specified transcript.
     *
     * @param transcript the transcript of the lecture to be summarized; must not be {@code null} or empty
     */

    public SummaryServiceInputData(String transcript) {
        if (transcript == null || transcript.isEmpty()) {
            throw new IllegalArgumentException("Transcript must not be null or empty");
        }
        this.transcript = transcript;
    }

    /**
     * Returns the transcript of the lecture.
     *
     * @return the lecture transcript
     */
    public String getTranscript() {
        return transcript;
    }
}
