/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.types;

import com.cohere.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GenerateStreamText.Builder.class)
public final class GenerateStreamText implements IGenerateStreamEvent {
    private final String text;

    private final Optional<Integer> index;

    private final boolean isFinished;

    private final Map<String, Object> additionalProperties;

    private GenerateStreamText(
            String text, Optional<Integer> index, boolean isFinished, Map<String, Object> additionalProperties) {
        this.text = text;
        this.index = index;
        this.isFinished = isFinished;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return A segment of text of the generation.
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * @return Refers to the nth generation. Only present when <code>num_generations</code> is greater than zero, and only when text responses are being streamed.
     */
    @JsonProperty("index")
    public Optional<Integer> getIndex() {
        return index;
    }

    @JsonProperty("is_finished")
    public boolean getIsFinished() {
        return isFinished;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GenerateStreamText && equalTo((GenerateStreamText) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GenerateStreamText other) {
        return text.equals(other.text) && index.equals(other.index) && isFinished == other.isFinished;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.text, this.index, this.isFinished);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TextStage builder() {
        return new Builder();
    }

    public interface TextStage {
        IsFinishedStage text(String text);

        Builder from(GenerateStreamText other);
    }

    public interface IsFinishedStage {
        _FinalStage isFinished(boolean isFinished);
    }

    public interface _FinalStage {
        GenerateStreamText build();

        _FinalStage index(Optional<Integer> index);

        _FinalStage index(Integer index);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TextStage, IsFinishedStage, _FinalStage {
        private String text;

        private boolean isFinished;

        private Optional<Integer> index = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(GenerateStreamText other) {
            text(other.getText());
            index(other.getIndex());
            isFinished(other.getIsFinished());
            return this;
        }

        /**
         * <p>A segment of text of the generation.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("text")
        public IsFinishedStage text(String text) {
            this.text = text;
            return this;
        }

        @Override
        @JsonSetter("is_finished")
        public _FinalStage isFinished(boolean isFinished) {
            this.isFinished = isFinished;
            return this;
        }

        /**
         * <p>Refers to the nth generation. Only present when <code>num_generations</code> is greater than zero, and only when text responses are being streamed.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage index(Integer index) {
            this.index = Optional.of(index);
            return this;
        }

        @Override
        @JsonSetter(value = "index", nulls = Nulls.SKIP)
        public _FinalStage index(Optional<Integer> index) {
            this.index = index;
            return this;
        }

        @Override
        public GenerateStreamText build() {
            return new GenerateStreamText(text, index, isFinished, additionalProperties);
        }
    }
}
