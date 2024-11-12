/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.resources.datasets.types;

import com.cohere.api.core.ObjectMappers;
import com.cohere.api.types.Dataset;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = DatasetsGetResponse.Builder.class)
public final class DatasetsGetResponse {
    private final Dataset dataset;

    private final Map<String, Object> additionalProperties;

    private DatasetsGetResponse(Dataset dataset, Map<String, Object> additionalProperties) {
        this.dataset = dataset;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("dataset")
    public Dataset getDataset() {
        return dataset;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DatasetsGetResponse && equalTo((DatasetsGetResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(DatasetsGetResponse other) {
        return dataset.equals(other.dataset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.dataset);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static DatasetStage builder() {
        return new Builder();
    }

    public interface DatasetStage {
        _FinalStage dataset(Dataset dataset);

        Builder from(DatasetsGetResponse other);
    }

    public interface _FinalStage {
        DatasetsGetResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements DatasetStage, _FinalStage {
        private Dataset dataset;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(DatasetsGetResponse other) {
            dataset(other.getDataset());
            return this;
        }

        @Override
        @JsonSetter("dataset")
        public _FinalStage dataset(Dataset dataset) {
            this.dataset = dataset;
            return this;
        }

        @Override
        public DatasetsGetResponse build() {
            return new DatasetsGetResponse(dataset, additionalProperties);
        }
    }
}
