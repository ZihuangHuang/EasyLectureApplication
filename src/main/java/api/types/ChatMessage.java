/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.types;

import com.cohere.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.*;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ChatMessage.Builder.class)
public final class ChatMessage {
    private final String message;

    private final Optional<List<ToolCall>> toolCalls;

    private final Map<String, Object> additionalProperties;

    private ChatMessage(String message, Optional<List<ToolCall>> toolCalls, Map<String, Object> additionalProperties) {
        this.message = message;
        this.toolCalls = toolCalls;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Contents of the chat message.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("tool_calls")
    public Optional<List<ToolCall>> getToolCalls() {
        return toolCalls;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ChatMessage && equalTo((ChatMessage) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ChatMessage other) {
        return message.equals(other.message) && toolCalls.equals(other.toolCalls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.message, this.toolCalls);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static MessageStage builder() {
        return new Builder();
    }

    public interface MessageStage {
        _FinalStage message(String message);

        Builder from(ChatMessage other);
    }

    public interface _FinalStage {
        ChatMessage build();

        _FinalStage toolCalls(Optional<List<ToolCall>> toolCalls);

        _FinalStage toolCalls(List<ToolCall> toolCalls);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements MessageStage, _FinalStage {
        private String message;

        private Optional<List<ToolCall>> toolCalls = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(ChatMessage other) {
            message(other.getMessage());
            toolCalls(other.getToolCalls());
            return this;
        }

        /**
         * <p>Contents of the chat message.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("message")
        public _FinalStage message(String message) {
            this.message = message;
            return this;
        }

        @Override
        public _FinalStage toolCalls(List<ToolCall> toolCalls) {
            this.toolCalls = Optional.of(toolCalls);
            return this;
        }

        @Override
        @JsonSetter(value = "tool_calls", nulls = Nulls.SKIP)
        public _FinalStage toolCalls(Optional<List<ToolCall>> toolCalls) {
            this.toolCalls = toolCalls;
            return this;
        }

        @Override
        public ChatMessage build() {
            return new ChatMessage(message, toolCalls, additionalProperties);
        }
    }
}
