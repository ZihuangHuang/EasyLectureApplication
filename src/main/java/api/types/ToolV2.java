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
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ToolV2.Builder.class)
public final class ToolV2 {
    private final Optional<String> type;

    private final Optional<ToolV2Function> function;

    private final Map<String, Object> additionalProperties;

    private ToolV2(Optional<String> type, Optional<ToolV2Function> function, Map<String, Object> additionalProperties) {
        this.type = type;
        this.function = function;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("type")
    public Optional<String> getType() {
        return type;
    }

    /**
     * @return The function to be executed.
     */
    @JsonProperty("function")
    public Optional<ToolV2Function> getFunction() {
        return function;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ToolV2 && equalTo((ToolV2) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ToolV2 other) {
        return type.equals(other.type) && function.equals(other.function);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.type, this.function);
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
        private Optional<String> type = Optional.empty();

        private Optional<ToolV2Function> function = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ToolV2 other) {
            type(other.getType());
            function(other.getFunction());
            return this;
        }

        @JsonSetter(value = "type", nulls = Nulls.SKIP)
        public Builder type(Optional<String> type) {
            this.type = type;
            return this;
        }

        public Builder type(String type) {
            this.type = Optional.of(type);
            return this;
        }

        @JsonSetter(value = "function", nulls = Nulls.SKIP)
        public Builder function(Optional<ToolV2Function> function) {
            this.function = function;
            return this;
        }

        public Builder function(ToolV2Function function) {
            this.function = Optional.of(function);
            return this;
        }

        public ToolV2 build() {
            return new ToolV2(type, function, additionalProperties);
        }
    }
}