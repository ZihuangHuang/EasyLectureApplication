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
@JsonDeserialize(builder = ToolMessageV2.Builder.class)
public final class ToolMessageV2 {
    private final String toolCallId;

    private final Optional<ToolMessageV2Content> content;

    private final Map<String, Object> additionalProperties;

    private ToolMessageV2(
            String toolCallId, Optional<ToolMessageV2Content> content, Map<String, Object> additionalProperties) {
        this.toolCallId = toolCallId;
        this.content = content;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The id of the associated tool call that has provided the given content
     */
    @JsonProperty("tool_call_id")
    public String getToolCallId() {
        return toolCallId;
    }

    /**
     * @return A single or list of outputs from a tool. The content should formatted as a JSON object string, or a list of tool content blocks
     */
    @JsonProperty("content")
    public Optional<ToolMessageV2Content> getContent() {
        return content;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ToolMessageV2 && equalTo((ToolMessageV2) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ToolMessageV2 other) {
        return toolCallId.equals(other.toolCallId) && content.equals(other.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.toolCallId, this.content);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ToolCallIdStage builder() {
        return new Builder();
    }

    public interface ToolCallIdStage {
        _FinalStage toolCallId(String toolCallId);

        Builder from(ToolMessageV2 other);
    }

    public interface _FinalStage {
        ToolMessageV2 build();

        _FinalStage content(Optional<ToolMessageV2Content> content);

        _FinalStage content(ToolMessageV2Content content);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ToolCallIdStage, _FinalStage {
        private String toolCallId;

        private Optional<ToolMessageV2Content> content = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(ToolMessageV2 other) {
            toolCallId(other.getToolCallId());
            content(other.getContent());
            return this;
        }

        /**
         * <p>The id of the associated tool call that has provided the given content</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("tool_call_id")
        public _FinalStage toolCallId(String toolCallId) {
            this.toolCallId = toolCallId;
            return this;
        }

        /**
         * <p>A single or list of outputs from a tool. The content should formatted as a JSON object string, or a list of tool content blocks</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage content(ToolMessageV2Content content) {
            this.content = Optional.of(content);
            return this;
        }

        @Override
        @JsonSetter(value = "content", nulls = Nulls.SKIP)
        public _FinalStage content(Optional<ToolMessageV2Content> content) {
            this.content = content;
            return this;
        }

        @Override
        public ToolMessageV2 build() {
            return new ToolMessageV2(toolCallId, content, additionalProperties);
        }
    }
}