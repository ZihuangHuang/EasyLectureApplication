package use_case;



import java.io.IOException;


public class TranscriptionToSummary {
    /**
     * The entry point of the application. Reads a transcription from a specified file path,
     * generates a summary using the {@link SummaryService}, and prints the summary to the console.
     *
     * @param args Command-line arguments where:
     *             <ul>
     *                 <li>{@code args[0]} (optional): The file path to the transcription text file.</li>
     *             </ul>
     *             If no arguments are provided, it defaults to {@code "path/to/transcription.txt"}.
     */
    public static void main(String[] args) {
        String transcriptionFilePath = "path/to/transcription.txt";

        try {
            String transcription = TranscriptionReader.readTranscription(transcriptionFilePath);
            String summary = SummaryService.generateSummary(transcription);
            System.out.println("Lecture commonSummaryFactory:\n" + summary);
        } catch (IOException e) {
            System.err.println("Error reading transcription file: " + e.getMessage());
        }
    }
}

