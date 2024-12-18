/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.types;

import com.cohere.api.core.ObjectMappers;
import com.cohere.api.types.Connector;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CreateConnectorResponse.Builder.class)
public final class CreateConnectorResponse {
    private final Connector connector;

    private final Map<String, Object> additionalProperties;

    private CreateConnectorResponse(Connector connector, Map<String, Object> additionalProperties) {
        this.connector = connector;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("connector")
    public Connector getConnector() {
        return connector;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateConnectorResponse && equalTo((CreateConnectorResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CreateConnectorResponse other) {
        return connector.equals(other.connector);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.connector);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ConnectorStage builder() {
        return new Builder();
    }

    public interface ConnectorStage {
        _FinalStage connector(Connector connector);

        Builder from(CreateConnectorResponse other);
    }

    public interface _FinalStage {
        CreateConnectorResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ConnectorStage, _FinalStage {
        private Connector connector;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(CreateConnectorResponse other) {
            connector(other.getConnector());
            return this;
        }

        @Override
        @JsonSetter("connector")
        public _FinalStage connector(Connector connector) {
            this.connector = connector;
            return this;
        }

        @Override
        public CreateConnectorResponse build() {
            return new CreateConnectorResponse(connector, additionalProperties);
        }
    }
}
