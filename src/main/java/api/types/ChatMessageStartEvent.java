/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.types;

import com.cohere.api.core.ObjectMappers;
import com.cohere.api.types.IChatStreamEventType;
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
@JsonDeserialize(builder = ChatMessageStartEvent.Builder.class)
public final class ChatMessageStartEvent implements IChatStreamEventType {
    private final Optional<String> id;

    private final Optional<ChatMessageStartEventDelta> delta;

    private final Map<String, Object> additionalProperties;

    private ChatMessageStartEvent(
            Optional<String> id, Optional<ChatMessageStartEventDelta> delta, Map<String, Object> additionalProperties) {
        this.id = id;
        this.delta = delta;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Unique identifier for the generated reply.
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    @JsonProperty("delta")
    public Optional<ChatMessageStartEventDelta> getDelta() {
        return delta;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ChatMessageStartEvent && equalTo((ChatMessageStartEvent) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ChatMessageStartEvent other) {
        return id.equals(other.id) && delta.equals(other.delta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.delta);
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
        private Optional<String> id = Optional.empty();

        private Optional<ChatMessageStartEventDelta> delta = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ChatMessageStartEvent other) {
            id(other.getId());
            delta(other.getDelta());
            return this;
        }

        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public Builder id(Optional<String> id) {
            this.id = id;
            return this;
        }

        public Builder id(String id) {
            this.id = Optional.of(id);
            return this;
        }

        @JsonSetter(value = "delta", nulls = Nulls.SKIP)
        public Builder delta(Optional<ChatMessageStartEventDelta> delta) {
            this.delta = delta;
            return this;
        }

        public Builder delta(ChatMessageStartEventDelta delta) {
            this.delta = Optional.of(delta);
            return this;
        }

        public ChatMessageStartEvent build() {
            return new ChatMessageStartEvent(id, delta, additionalProperties);
        }
    }
}
