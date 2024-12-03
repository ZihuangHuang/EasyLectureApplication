package use_case.Summary;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Utility class responsible for reading the transcription from a file.
 */
public class TranscriptionReader {
    /**
     * Reads the transcription from the given file path.
     *
     * @param filePath Path to the transcription file.
     * @return Transcription text.
     * @throws IOException If an I/O error occurs.
     */
    public static String readTranscription(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}


