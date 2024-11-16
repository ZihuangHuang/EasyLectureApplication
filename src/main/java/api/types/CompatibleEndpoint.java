/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CompatibleEndpoint {
    CHAT("chat"),

    EMBED("embed"),

    CLASSIFY("classify"),

    SUMMARIZE("summarize"),

    RERANK("rerank"),

    RATE("rate"),

    GENERATE("generate");

    private final String value;

    CompatibleEndpoint(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}