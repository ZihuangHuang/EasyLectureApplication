/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CitationOptionsMode {
    FAST("FAST"),

    ACCURATE("ACCURATE"),

    OFF("OFF");

    private final String value;

    CitationOptionsMode(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}