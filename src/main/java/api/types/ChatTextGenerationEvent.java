/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.types;

import com.cohere.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ChatTextGenerationEvent.Builder.class)
public final class ChatTextGenerationEvent implements IChatStreamEvent {
    private final String text;

    private final Map<String, Object> additionalProperties;

    private ChatTextGenerationEvent(String text, Map<String, Object> additionalProperties) {
        this.text = text;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The next batch of text generated by the model.
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ChatTextGenerationEvent && equalTo((ChatTextGenerationEvent) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ChatTextGenerationEvent other) {
        return text.equals(other.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.text);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TextStage builder() {
        return new Builder();
    }

    public interface TextStage {
        _FinalStage text(String text);

        Builder from(ChatTextGenerationEvent other);
    }

    public interface _FinalStage {
        ChatTextGenerationEvent build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TextStage, _FinalStage {
        private String text;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(ChatTextGenerationEvent other) {
            text(other.getText());
            return this;
        }

        /**
         * <p>The next batch of text generated by the model.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("text")
        public _FinalStage text(String text) {
            this.text = text;
            return this;
        }

        @Override
        public ChatTextGenerationEvent build() {
            return new ChatTextGenerationEvent(text, additionalProperties);
        }
    }
}
