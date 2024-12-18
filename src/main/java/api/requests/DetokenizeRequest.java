/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.requests;

import com.cohere.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.*;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = DetokenizeRequest.Builder.class)
public final class DetokenizeRequest {
    private final List<Integer> tokens;

    private final String model;

    private final Map<String, Object> additionalProperties;

    private DetokenizeRequest(List<Integer> tokens, String model, Map<String, Object> additionalProperties) {
        this.tokens = tokens;
        this.model = model;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The list of tokens to be detokenized.
     */
    @JsonProperty("tokens")
    public List<Integer> getTokens() {
        return tokens;
    }

    /**
     * @return An optional parameter to provide the model name. This will ensure that the detokenization is done by the tokenizer used by that model.
     */
    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DetokenizeRequest && equalTo((DetokenizeRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(DetokenizeRequest other) {
        return tokens.equals(other.tokens) && model.equals(other.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.tokens, this.model);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ModelStage builder() {
        return new Builder();
    }

    public interface ModelStage {
        _FinalStage model(String model);

        Builder from(DetokenizeRequest other);
    }

    public interface _FinalStage {
        DetokenizeRequest build();

        _FinalStage tokens(List<Integer> tokens);

        _FinalStage addTokens(Integer tokens);

        _FinalStage addAllTokens(List<Integer> tokens);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ModelStage, _FinalStage {
        private String model;

        private List<Integer> tokens = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(DetokenizeRequest other) {
            tokens(other.getTokens());
            model(other.getModel());
            return this;
        }

        /**
         * <p>An optional parameter to provide the model name. This will ensure that the detokenization is done by the tokenizer used by that model.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("model")
        public _FinalStage model(String model) {
            this.model = model;
            return this;
        }

        /**
         * <p>The list of tokens to be detokenized.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllTokens(List<Integer> tokens) {
            this.tokens.addAll(tokens);
            return this;
        }

        /**
         * <p>The list of tokens to be detokenized.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addTokens(Integer tokens) {
            this.tokens.add(tokens);
            return this;
        }

        @Override
        @JsonSetter(value = "tokens", nulls = Nulls.SKIP)
        public _FinalStage tokens(List<Integer> tokens) {
            this.tokens.clear();
            this.tokens.addAll(tokens);
            return this;
        }

        @Override
        public DetokenizeRequest build() {
            return new DetokenizeRequest(tokens, model, additionalProperties);
        }
    }
}
