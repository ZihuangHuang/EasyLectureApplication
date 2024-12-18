/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SummarizeRequestExtractiveness {
    LOW("low"),

    MEDIUM("medium"),

    HIGH("high");

    private final String value;

    SummarizeRequestExtractiveness(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}
