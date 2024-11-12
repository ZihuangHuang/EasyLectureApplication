/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.types;

import com.cohere.api.core.ObjectMappers;
import com.cohere.api.types.AssistantMessageContent;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AssistantMessage.Builder.class)
public final class AssistantMessage {
    private final Optional<List<ToolCallV2>> toolCalls;

    private final Optional<String> toolPlan;

    private final Optional<AssistantMessageContent> content;

    private final Optional<List<Citation>> citations;

    private final Map<String, Object> additionalProperties;

    private AssistantMessage(
            Optional<List<ToolCallV2>> toolCalls,
            Optional<String> toolPlan,
            Optional<AssistantMessageContent> content,
            Optional<List<Citation>> citations,
            Map<String, Object> additionalProperties) {
        this.toolCalls = toolCalls;
        this.toolPlan = toolPlan;
        this.content = content;
        this.citations = citations;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("tool_calls")
    public Optional<List<ToolCallV2>> getToolCalls() {
        return toolCalls;
    }

    @JsonProperty("tool_plan")
    public Optional<String> getToolPlan() {
        return toolPlan;
    }

    @JsonProperty("content")
    public Optional<AssistantMessageContent> getContent() {
        return content;
    }

    @JsonProperty("citations")
    public Optional<List<Citation>> getCitations() {
        return citations;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AssistantMessage && equalTo((AssistantMessage) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(AssistantMessage other) {
        return toolCalls.equals(other.toolCalls)
                && toolPlan.equals(other.toolPlan)
                && content.equals(other.content)
                && citations.equals(other.citations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.toolCalls, this.toolPlan, this.content, this.citations);
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
        private Optional<List<ToolCallV2>> toolCalls = Optional.empty();

        private Optional<String> toolPlan = Optional.empty();

        private Optional<AssistantMessageContent> content = Optional.empty();

        private Optional<List<Citation>> citations = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(AssistantMessage other) {
            toolCalls(other.getToolCalls());
            toolPlan(other.getToolPlan());
            content(other.getContent());
            citations(other.getCitations());
            return this;
        }

        @JsonSetter(value = "tool_calls", nulls = Nulls.SKIP)
        public Builder toolCalls(Optional<List<ToolCallV2>> toolCalls) {
            this.toolCalls = toolCalls;
            return this;
        }

        public Builder toolCalls(List<ToolCallV2> toolCalls) {
            this.toolCalls = Optional.of(toolCalls);
            return this;
        }

        @JsonSetter(value = "tool_plan", nulls = Nulls.SKIP)
        public Builder toolPlan(Optional<String> toolPlan) {
            this.toolPlan = toolPlan;
            return this;
        }

        public Builder toolPlan(String toolPlan) {
            this.toolPlan = Optional.of(toolPlan);
            return this;
        }

        @JsonSetter(value = "content", nulls = Nulls.SKIP)
        public Builder content(Optional<AssistantMessageContent> content) {
            this.content = content;
            return this;
        }

        public Builder content(AssistantMessageContent content) {
            this.content = Optional.of(content);
            return this;
        }

        @JsonSetter(value = "citations", nulls = Nulls.SKIP)
        public Builder citations(Optional<List<Citation>> citations) {
            this.citations = citations;
            return this;
        }

        public Builder citations(List<Citation> citations) {
            this.citations = Optional.of(citations);
            return this;
        }

        public AssistantMessage build() {
            return new AssistantMessage(toolCalls, toolPlan, content, citations, additionalProperties);
        }
    }
}
