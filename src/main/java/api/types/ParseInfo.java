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
@JsonDeserialize(builder = ParseInfo.Builder.class)
public final class ParseInfo {
    private final Optional<String> separator;

    private final Optional<String> delimiter;

    private final Map<String, Object> additionalProperties;

    private ParseInfo(
            Optional<String> separator, Optional<String> delimiter, Map<String, Object> additionalProperties) {
        this.separator = separator;
        this.delimiter = delimiter;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("separator")
    public Optional<String> getSeparator() {
        return separator;
    }

    @JsonProperty("delimiter")
    public Optional<String> getDelimiter() {
        return delimiter;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ParseInfo && equalTo((ParseInfo) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ParseInfo other) {
        return separator.equals(other.separator) && delimiter.equals(other.delimiter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.separator, this.delimiter);
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
        private Optional<String> separator = Optional.empty();

        private Optional<String> delimiter = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ParseInfo other) {
            separator(other.getSeparator());
            delimiter(other.getDelimiter());
            return this;
        }

        @JsonSetter(value = "separator", nulls = Nulls.SKIP)
        public Builder separator(Optional<String> separator) {
            this.separator = separator;
            return this;
        }

        public Builder separator(String separator) {
            this.separator = Optional.of(separator);
            return this;
        }

        @JsonSetter(value = "delimiter", nulls = Nulls.SKIP)
        public Builder delimiter(Optional<String> delimiter) {
            this.delimiter = delimiter;
            return this;
        }

        public Builder delimiter(String delimiter) {
            this.delimiter = Optional.of(delimiter);
            return this;
        }

        public ParseInfo build() {
            return new ParseInfo(separator, delimiter, additionalProperties);
        }
    }
}
