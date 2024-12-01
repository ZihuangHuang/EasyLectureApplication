/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.types;

import com.cohere.api.core.ObjectMappers;
import com.cohere.api.types.FinetuneDatasetMetrics;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Metrics.Builder.class)
public final class Metrics {
    private final Optional<FinetuneDatasetMetrics> finetuneDatasetMetrics;

    private final Optional<MetricsEmbedData> embedData;

    private final Map<String, Object> additionalProperties;

    private Metrics(
            Optional<FinetuneDatasetMetrics> finetuneDatasetMetrics,
            Optional<MetricsEmbedData> embedData,
            Map<String, Object> additionalProperties) {
        this.finetuneDatasetMetrics = finetuneDatasetMetrics;
        this.embedData = embedData;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("finetune_dataset_metrics")
    public Optional<FinetuneDatasetMetrics> getFinetuneDatasetMetrics() {
        return finetuneDatasetMetrics;
    }

    @JsonProperty("embed_data")
    public Optional<MetricsEmbedData> getEmbedData() {
        return embedData;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Metrics && equalTo((Metrics) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Metrics other) {
        return finetuneDatasetMetrics.equals(other.finetuneDatasetMetrics) && embedData.equals(other.embedData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.finetuneDatasetMetrics, this.embedData);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<FinetuneDatasetMetrics> finetuneDatasetMetrics = Optional.empty();

        private Optional<MetricsEmbedData> embedData = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(Metrics other) {
            finetuneDatasetMetrics(other.getFinetuneDatasetMetrics());
            embedData(other.getEmbedData());
            return this;
        }

        @JsonSetter(value = "finetune_dataset_metrics", nulls = Nulls.SKIP)
        public Builder finetuneDatasetMetrics(Optional<FinetuneDatasetMetrics> finetuneDatasetMetrics) {
            this.finetuneDatasetMetrics = finetuneDatasetMetrics;
            return this;
        }

        public Builder finetuneDatasetMetrics(FinetuneDatasetMetrics finetuneDatasetMetrics) {
            this.finetuneDatasetMetrics = Optional.of(finetuneDatasetMetrics);
            return this;
        }

        @JsonSetter(value = "embed_data", nulls = Nulls.SKIP)
        public Builder embedData(Optional<MetricsEmbedData> embedData) {
            this.embedData = embedData;
            return this;
        }

        public Builder embedData(MetricsEmbedData embedData) {
            this.embedData = Optional.of(embedData);
            return this;
        }

        public Metrics build() {
            return new Metrics(finetuneDatasetMetrics, embedData, additionalProperties);
        }
    }
}