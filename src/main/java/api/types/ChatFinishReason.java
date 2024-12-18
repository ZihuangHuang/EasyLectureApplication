/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ChatFinishReason {
    COMPLETE("complete"),

    STOP_SEQUENCE("stop_sequence"),

    MAX_TOKENS("max_tokens"),

    TOOL_CALL("tool_call"),

    ERROR("error"),

    CONTENT_BLOCKED("content_blocked"),

    ERROR_LIMIT("error_limit");

    private final String value;

    ChatFinishReason(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
