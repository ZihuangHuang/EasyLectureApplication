package use_case;

/**
 * Utility class responsible for building prompts for the Cohere API.
 */

public class PromptBuilder {
    /**
     * Builds a prompt for summarizing the lecture transcription.
     *
     * @param transcription The lecture transcription text.
     * @return The prompt string.
     */
    public static String buildSummaryPrompt(String transcription) {
        return String.format(
                "Summarize the following lecture transcription into a concise and clear summary:\n\n%s",
                transcription);
    }
}
