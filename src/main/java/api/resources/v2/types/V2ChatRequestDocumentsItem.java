/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.resources.v2.types;

import com.cohere.api.core.ObjectMappers;
import com.cohere.api.types.Document;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Objects;

@JsonDeserialize(using = V2ChatRequestDocumentsItem.Deserializer.class)
public final class V2ChatRequestDocumentsItem {
    private final Object value;

    private final int type;

    private V2ChatRequestDocumentsItem(Object value, int type) {
        this.value = value;
        this.type = type;
    }

    @JsonValue
    public Object get() {
        return this.value;
    }

    public <T> T visit(Visitor<T> visitor) {
        if (this.type == 0) {
            return visitor.visit((String) this.value);
        } else if (this.type == 1) {
            return visitor.visit((Document) this.value);
        }
        throw new IllegalStateException("Failed to visit value. This should never happen.");
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof V2ChatRequestDocumentsItem && equalTo((V2ChatRequestDocumentsItem) other);
    }

    private boolean equalTo(V2ChatRequestDocumentsItem other) {
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

    @Override
    public String toString() {
        return this.value.toString();
    }

    public static V2ChatRequestDocumentsItem of(String value) {
        return new V2ChatRequestDocumentsItem(value, 0);
    }

    public static V2ChatRequestDocumentsItem of(Document value) {
        return new V2ChatRequestDocumentsItem(value, 1);
    }

    public interface Visitor<T> {
        T visit(String value);

        T visit(Document value);
    }

    static final class Deserializer extends StdDeserializer<V2ChatRequestDocumentsItem> {
        Deserializer() {
            super(V2ChatRequestDocumentsItem.class);
        }

        @Override
        public V2ChatRequestDocumentsItem deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            Object value = p.readValueAs(Object.class);
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, String.class));
            } catch (IllegalArgumentException e) {
            }
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, Document.class));
            } catch (IllegalArgumentException e) {
            }
            throw new JsonParseException(p, "Failed to deserialize");
        }
    }
}
