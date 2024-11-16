/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ChatRequestCitationQuality {
    FAST("fast"),

    ACCURATE("accurate"),

    OFF("off");

    private final String value;

    ChatRequestCitationQuality(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}