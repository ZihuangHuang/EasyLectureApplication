package use_case;

/**
 * The input data for the commonSummaryFactory Use Case.
 */
public class SummaryServiceInputData {
    private final String transcript;

    public SummaryServiceInputData(String transcript) {
        this.transcript = transcript;
    }

    String getTranscript() {
        return transcript;
    }
}
