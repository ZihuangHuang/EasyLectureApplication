package use_case;

import com.cohere.api.Cohere;
import com.cohere.api.resources.v2.requests.V2ChatRequest;
import com.cohere.api.types.ChatMessageV2;
import com.cohere.api.types.ChatResponse;
import com.cohere.api.types.UserMessage;
import com.cohere.api.types.UserMessageContent;

import java.util.List;

/**
 * Service class responsible for interacting with the Cohere API to generate summaries.
 */
public class SummaryService {
    private static final String MODEL_NAME = "command-r-plus";

    /**
     * Generates a summary of the given transcription using the Cohere API.
     *
     * @param transcription The lecture transcription text.
     * @param apiKey        The API key for Cohere.
     * @return The generated summary.
     */
    public static String generateSummary(String transcription, String apiKey) {
        Cohere cohere = Cohere.builder()
                .token(apiKey)
                .clientName("LectureSummaryGenerator")
                .build();

        String prompt = PromptBuilder.buildSummaryPrompt(transcription);

        ChatResponse response = cohere.v2()
                .chat(V2ChatRequest.builder()
                        .model(MODEL_NAME)
                        .messages(List.of(
                                ChatMessageV2.user(UserMessage.builder()
                                        .content(UserMessageContent.of(prompt))
                                        .build())
                        ))
                        .build());

        return response.getMessage();
    }
}

