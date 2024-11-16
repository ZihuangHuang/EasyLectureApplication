/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.types;

import com.cohere.api.core.ObjectMappers;
import com.cohere.api.types.ChatContentDeltaEventDeltaMessageContent;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ChatContentDeltaEventDeltaMessage.Builder.class)
public final class ChatContentDeltaEventDeltaMessage {
    private final Optional<ChatContentDeltaEventDeltaMessageContent> content;

    private final Map<String, Object> additionalProperties;

    private ChatContentDeltaEventDeltaMessage(
            Optional<ChatContentDeltaEventDeltaMessageContent> content, Map<String, Object> additionalProperties) {
        this.content = content;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("content")
    public Optional<ChatContentDeltaEventDeltaMessageContent> getContent() {
        return content;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ChatContentDeltaEventDeltaMessage && equalTo((ChatContentDeltaEventDeltaMessage) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ChatContentDeltaEventDeltaMessage other) {
        return content.equals(other.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.content);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<ChatContentDeltaEventDeltaMessageContent> content = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ChatContentDeltaEventDeltaMessage other) {
            content(other.getContent());
            return this;
        }

        @JsonSetter(value = "content", nulls = Nulls.SKIP)
        public Builder content(Optional<ChatContentDeltaEventDeltaMessageContent> content) {
            this.content = content;
            return this;
        }

        public Builder content(ChatContentDeltaEventDeltaMessageContent content) {
            this.content = Optional.of(content);
            return this;
        }

        public ChatContentDeltaEventDeltaMessage build() {
            return new ChatContentDeltaEventDeltaMessage(content, additionalProperties);
        }
    }
}