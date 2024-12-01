package use_case;

import java.io.IOException;
import java.util.Scanner;

public class TranscriptionToSummary {
    public static void main(String[] args) {
        // Create a scanner to take user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a YouTube video URL:");
        String youtubeUrl = scanner.nextLine().trim(); // Get the URL from the user

        try {
            // Fetch the transcription using TranscriptFetcher
            String transcription = TranscriptFetcher.fetchTranscript(youtubeUrl);

            // Generate the summary using the transcription
            String summary = SummaryService.generateSummary(transcription);

            // Output the summary
            System.out.println("Lecture Summary:\n" + summary);
        } catch (IOException | InterruptedException e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
