/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.types;

import com.cohere.api.types.TextResponseFormatV2;
import com.fasterxml.jackson.annotation.*;

import java.util.Objects;
import java.util.Optional;

public final class ResponseFormatV2 {
    private final Value value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    private ResponseFormatV2(Value value) {
        this.value = value;
    }

    public <T> T visit(Visitor<T> visitor) {
        return value.visit(visitor);
    }

    public static ResponseFormatV2 text(TextResponseFormatV2 value) {
        return new ResponseFormatV2(new TextValue(value));
    }

    public static ResponseFormatV2 jsonObject(JsonResponseFormatV2 value) {
        return new ResponseFormatV2(new JsonObjectValue(value));
    }

    public boolean isText() {
        return value instanceof TextValue;
    }

    public boolean isJsonObject() {
        return value instanceof JsonObjectValue;
    }

    public boolean _isUnknown() {
        return value instanceof _UnknownValue;
    }

    public Optional<TextResponseFormatV2> getText() {
        if (isText()) {
            return Optional.of(((TextValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<JsonResponseFormatV2> getJsonObject() {
        if (isJsonObject()) {
            return Optional.of(((JsonObjectValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<Object> _getUnknown() {
        if (_isUnknown()) {
            return Optional.of(((_UnknownValue) value).value);
        }
        return Optional.empty();
    }

    @JsonValue
    private Value getValue() {
        return this.value;
    }

    public interface Visitor<T> {
        T visitText(TextResponseFormatV2 text);

        T visitJsonObject(JsonResponseFormatV2 jsonObject);

        T _visitUnknown(Object unknownType);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = _UnknownValue.class)
    @JsonSubTypes({@JsonSubTypes.Type(TextValue.class), @JsonSubTypes.Type(JsonObjectValue.class)})
    @JsonIgnoreProperties(ignoreUnknown = true)
    private interface Value {
        <T> T visit(Visitor<T> visitor);
    }

    @JsonTypeName("text")
    private static final class TextValue implements Value {
        @JsonUnwrapped
        private TextResponseFormatV2 value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private TextValue() {}

        private TextValue(TextResponseFormatV2 value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitText(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof TextValue && equalTo((TextValue) other);
        }

        private boolean equalTo(TextValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "ResponseFormatV2{" + "value: " + value + "}";
        }
    }

    @JsonTypeName("json_object")
    private static final class JsonObjectValue implements Value {
        @JsonUnwrapped
        private JsonResponseFormatV2 value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private JsonObjectValue() {}

        private JsonObjectValue(JsonResponseFormatV2 value) {
            this.value = value;
        }

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitJsonObject(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof JsonObjectValue && equalTo((JsonObjectValue) other);
        }

        private boolean equalTo(JsonObjectValue other) {
            return value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @Override
        public String toString() {
            return "ResponseFormatV2{" + "value: " + value + "}";
        }
    }

    private static final class _UnknownValue implements Value {
        private String type;

        @JsonValue
        private Object value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private _UnknownValue(@JsonProperty("value") Object value) {}

        @Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor._visitUnknown(value);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof _UnknownValue && equalTo((_UnknownValue) other);
        }

        private boolean equalTo(_UnknownValue other) {
            return type.equals(other.type) && value.equals(other.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.type, this.value);
        }

        @Override
        public String toString() {
            return "ResponseFormatV2{" + "type: " + type + ", value: " + value + "}";
        }
    }
}
