/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.requests;

import com.cohere.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TokenizeRequest.Builder.class)
public final class TokenizeRequest {
    private final String text;

    private final String model;

    private final Map<String, Object> additionalProperties;

    private TokenizeRequest(String text, String model, Map<String, Object> additionalProperties) {
        this.text = text;
        this.model = model;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The string to be tokenized, the minimum text length is 1 character, and the maximum text length is 65536 characters.
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    /**
     * @return An optional parameter to provide the model name. This will ensure that the tokenization uses the tokenizer used by that model.
     */
    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TokenizeRequest && equalTo((TokenizeRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(TokenizeRequest other) {
        return text.equals(other.text) && model.equals(other.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.text, this.model);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TextStage builder() {
        return new Builder();
    }

    public interface TextStage {
        ModelStage text(String text);

        Builder from(TokenizeRequest other);
    }

    public interface ModelStage {
        _FinalStage model(String model);
    }

    public interface _FinalStage {
        TokenizeRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TextStage, ModelStage, _FinalStage {
        private String text;

        private String model;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(TokenizeRequest other) {
            text(other.getText());
            model(other.getModel());
            return this;
        }

        /**
         * <p>The string to be tokenized, the minimum text length is 1 character, and the maximum text length is 65536 characters.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("text")
        public ModelStage text(String text) {
            this.text = text;
            return this;
        }

        /**
         * <p>An optional parameter to provide the model name. This will ensure that the tokenization uses the tokenizer used by that model.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("model")
        public _FinalStage model(String model) {
            this.model = model;
            return this;
        }

        @Override
        public TokenizeRequest build() {
            return new TokenizeRequest(text, model, additionalProperties);
        }
    }
}