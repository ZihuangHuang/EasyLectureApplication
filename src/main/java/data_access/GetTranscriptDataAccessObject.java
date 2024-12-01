package data_access;

import java.io.FileWriter;
import java.io.IOException;
import use_case.GetTranscript.GetTranscriptDataAccessUserInterface;

/**
 * Data Access Object (DAO) for the GetTranscript Use Case.
 * Implements the methods to interact with the data source, such as saving the transcript to a file.
 */
public class GetTranscriptDataAccessObject implements GetTranscriptDataAccessUserInterface {

    /**
     * Saves the transcript text to a file.
     * @param transcriptText the transcript text to be saved
     * @param filePath the file path where the transcript will be saved
     * @return true if the transcript was successfully saved, false otherwise
     */
    @Override
    public boolean saveTranscript(String transcriptText, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(transcriptText);
            return true;
        } catch (IOException e) {
            System.err.println("Failed to save transcript: " + e.getMessage());
            return false;
        }
    }
}
