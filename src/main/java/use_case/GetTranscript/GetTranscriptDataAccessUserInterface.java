package use_case.GetTranscript;

/**
 * Interface for the Data Access Object (DAO) that interacts with the data source
 * for the GetTranscript Use Case.
 */
public interface GetTranscriptDataAccessUserInterface {

    /**
     * Saves the transcript text to a file.
     * @param transcriptText the transcript text to be saved
     * @param filePath the file path where the transcript will be saved
     * @return true if the transcript was successfully saved, false otherwise
     */
    boolean saveTranscript(String transcriptText, String filePath);
}
