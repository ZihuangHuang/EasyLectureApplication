package use_case;



import java.io.IOException;



public class TranscriptionToSummary {
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

