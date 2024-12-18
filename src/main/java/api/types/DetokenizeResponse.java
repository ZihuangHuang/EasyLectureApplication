/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.types;

import com.cohere.api.core.ObjectMappers;
import com.cohere.api.types.ApiMeta;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = DetokenizeResponse.Builder.class)
public final class DetokenizeResponse {
    private final String text;

    private final Optional<ApiMeta> meta;

    private final Map<String, Object> additionalProperties;

    private DetokenizeResponse(String text, Optional<ApiMeta> meta, Map<String, Object> additionalProperties) {
        this.text = text;
        this.meta = meta;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return A string representing the list of tokens.
     */
    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("meta")
    public Optional<ApiMeta> getMeta() {
        return meta;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DetokenizeResponse && equalTo((DetokenizeResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(DetokenizeResponse other) {
        return text.equals(other.text) && meta.equals(other.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.text, this.meta);
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

        Builder from(DetokenizeResponse other);
    }

    public interface _FinalStage {
        DetokenizeResponse build();

        _FinalStage meta(Optional<ApiMeta> meta);

        _FinalStage meta(ApiMeta meta);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TextStage, _FinalStage {
        private String text;

        private Optional<ApiMeta> meta = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(DetokenizeResponse other) {
            text(other.getText());
            meta(other.getMeta());
            return this;
        }

        /**
         * <p>A string representing the list of tokens.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("text")
        public _FinalStage text(String text) {
            this.text = text;
            return this;
        }

        @Override
        public _FinalStage meta(ApiMeta meta) {
            this.meta = Optional.of(meta);
            return this;
        }

        @Override
        @JsonSetter(value = "meta", nulls = Nulls.SKIP)
        public _FinalStage meta(Optional<ApiMeta> meta) {
            this.meta = meta;
            return this;
        }

        @Override
        public DetokenizeResponse build() {
            return new DetokenizeResponse(text, meta, additionalProperties);
        }
    }
}
