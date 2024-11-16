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
@JsonDeserialize(builder = ChatMessageStartEventDeltaMessage.Builder.class)
public final class ChatMessageStartEventDeltaMessage {
    private final Optional<String> role;

    private final Map<String, Object> additionalProperties;

    private ChatMessageStartEventDeltaMessage(Optional<String> role, Map<String, Object> additionalProperties) {
        this.role = role;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The role of the message.
     */
    @JsonProperty("role")
    public Optional<String> getRole() {
        return role;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ChatMessageStartEventDeltaMessage && equalTo((ChatMessageStartEventDeltaMessage) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ChatMessageStartEventDeltaMessage other) {
        return role.equals(other.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.role);
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
        private Optional<String> role = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ChatMessageStartEventDeltaMessage other) {
            role(other.getRole());
            return this;
        }

        @JsonSetter(value = "role", nulls = Nulls.SKIP)
        public Builder role(Optional<String> role) {
            this.role = role;
            return this;
        }

        public Builder role(String role) {
            this.role = Optional.of(role);
            return this;
        }

        public ChatMessageStartEventDeltaMessage build() {
            return new ChatMessageStartEventDeltaMessage(role, additionalProperties);
        }
    }
}