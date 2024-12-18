/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.types;

import com.cohere.api.core.ObjectMappers;
import com.cohere.api.types.CitationStartEventDelta;
import com.cohere.api.types.IChatStreamEventType;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CitationStartEvent.Builder.class)
public final class CitationStartEvent implements IChatStreamEventType {
    private final Optional<Integer> index;

    private final Optional<CitationStartEventDelta> delta;

    private final Map<String, Object> additionalProperties;

    private CitationStartEvent(
            Optional<Integer> index,
            Optional<CitationStartEventDelta> delta,
            Map<String, Object> additionalProperties) {
        this.index = index;
        this.delta = delta;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("index")
    public Optional<Integer> getIndex() {
        return index;
    }

    @JsonProperty("delta")
    public Optional<CitationStartEventDelta> getDelta() {
        return delta;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CitationStartEvent && equalTo((CitationStartEvent) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CitationStartEvent other) {
        return index.equals(other.index) && delta.equals(other.delta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.index, this.delta);
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
        private Optional<Integer> index = Optional.empty();

        private Optional<CitationStartEventDelta> delta = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(CitationStartEvent other) {
            index(other.getIndex());
            delta(other.getDelta());
            return this;
        }

        @JsonSetter(value = "index", nulls = Nulls.SKIP)
        public Builder index(Optional<Integer> index) {
            this.index = index;
            return this;
        }

        public Builder index(Integer index) {
            this.index = Optional.of(index);
            return this;
        }

        @JsonSetter(value = "delta", nulls = Nulls.SKIP)
        public Builder delta(Optional<CitationStartEventDelta> delta) {
            this.delta = delta;
            return this;
        }

        public Builder delta(CitationStartEventDelta delta) {
            this.delta = Optional.of(delta);
            return this;
        }

        public CitationStartEvent build() {
            return new CitationStartEvent(index, delta, additionalProperties);
        }
    }
}
