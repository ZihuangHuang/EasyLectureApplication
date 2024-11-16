/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EmbedRequestTruncate {
    NONE("NONE"),

    START("START"),

    END("END");

    private final String value;

    EmbedRequestTruncate(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}