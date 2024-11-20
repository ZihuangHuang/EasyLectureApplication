package use_case;

import com.cohere.api.Cohere;
import com.cohere.api.resources.v2.requests.V2ChatRequest;
import com.cohere.api.types.ChatMessageV2;
import com.cohere.api.types.ChatResponse;
import com.cohere.api.types.UserMessage;
import com.cohere.api.types.UserMessageContent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


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

