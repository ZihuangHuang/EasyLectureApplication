package use_case.transcription_to_quiz;

import com.cohere.api.Cohere;
import com.cohere.api.resources.v2.requests.V2ChatRequest;
import com.cohere.api.types.*;
import java.util.List;

/**
 * Service class responsible for interacting with the Cohere API to generate quizzes from the transcription.
 */
public class QuizService {
    private static final String QUIZ_MODEL_NAME = "command-r-plus";
        /**
         * Generates a quiz of the given transcription using the Cohere API.
         *
         * @param transcription The lecture transcription text.
         * @param apiKey        The API key for Cohere.
         * @return The generated quiz.
         */
        public static String generateQuizframe(String transcription, String apiKey) {
            Cohere cohere = Cohere.builder().token("<<apiKey>>").clientName("Quizgenerator").build();

            String quizframe = String.format("Summarize the following lecture transcription into a quiz frame:\n\n%s",
                    transcription);

            ChatResponse response =
                    cohere.v2()
                            .chat(
                                    V2ChatRequest.builder()
                                            .model(QUIZ_MODEL_NAME)
                                            .messages(
                                                    List.of(
                                                            ChatMessageV2.user(
                                                                    UserMessage.builder()
                                                                            .content(
                                                                                    UserMessageContent
                                                                                            .of(quizframe))
                                                                            .build())))
                                            .build());

            return String.valueOf(response.getMessage());
    }
}
