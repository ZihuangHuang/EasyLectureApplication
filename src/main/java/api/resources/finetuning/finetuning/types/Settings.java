/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.resources.finetuning.finetuning.types;

import com.cohere.api.core.ObjectMappers;
import com.cohere.api.resources.finetuning.finetuning.types.BaseModel;
import com.cohere.api.resources.finetuning.finetuning.types.Hyperparameters;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Settings.Builder.class)
public final class Settings {
    private final BaseModel baseModel;

    private final String datasetId;

    private final Optional<Hyperparameters> hyperparameters;

    private final Optional<Boolean> multiLabel;

    private final Optional<WandbConfig> wandb;

    private final Map<String, Object> additionalProperties;

    private Settings(
            BaseModel baseModel,
            String datasetId,
            Optional<Hyperparameters> hyperparameters,
            Optional<Boolean> multiLabel,
            Optional<WandbConfig> wandb,
            Map<String, Object> additionalProperties) {
        this.baseModel = baseModel;
        this.datasetId = datasetId;
        this.hyperparameters = hyperparameters;
        this.multiLabel = multiLabel;
        this.wandb = wandb;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return The base model to fine-tune.
     */
    @JsonProperty("base_model")
    public BaseModel getBaseModel() {
        return baseModel;
    }

    /**
     * @return The data used for training and evaluating the fine-tuned model.
     */
    @JsonProperty("dataset_id")
    public String getDatasetId() {
        return datasetId;
    }

    /**
     * @return Fine-tuning hyper-parameters.
     */
    @JsonProperty("hyperparameters")
    public Optional<Hyperparameters> getHyperparameters() {
        return hyperparameters;
    }

    /**
     * @return read-only. Whether the model is single-label or multi-label (only for classification).
     */
    @JsonProperty("multi_label")
    public Optional<Boolean> getMultiLabel() {
        return multiLabel;
    }

    /**
     * @return The Weights &amp; Biases configuration (Chat fine-tuning only).
     */
    @JsonProperty("wandb")
    public Optional<WandbConfig> getWandb() {
        return wandb;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Settings && equalTo((Settings) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Settings other) {
        return baseModel.equals(other.baseModel)
                && datasetId.equals(other.datasetId)
                && hyperparameters.equals(other.hyperparameters)
                && multiLabel.equals(other.multiLabel)
                && wandb.equals(other.wandb);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.baseModel, this.datasetId, this.hyperparameters, this.multiLabel, this.wandb);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static BaseModelStage builder() {
        return new Builder();
    }

    public interface BaseModelStage {
        DatasetIdStage baseModel(BaseModel baseModel);

        Builder from(Settings other);
    }

    public interface DatasetIdStage {
        _FinalStage datasetId(String datasetId);
    }

    public interface _FinalStage {
        Settings build();

        _FinalStage hyperparameters(Optional<Hyperparameters> hyperparameters);

        _FinalStage hyperparameters(Hyperparameters hyperparameters);

        _FinalStage multiLabel(Optional<Boolean> multiLabel);

        _FinalStage multiLabel(Boolean multiLabel);

        _FinalStage wandb(Optional<WandbConfig> wandb);

        _FinalStage wandb(WandbConfig wandb);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements BaseModelStage, DatasetIdStage, _FinalStage {
        private BaseModel baseModel;

        private String datasetId;

        private Optional<WandbConfig> wandb = Optional.empty();

        private Optional<Boolean> multiLabel = Optional.empty();

        private Optional<Hyperparameters> hyperparameters = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(Settings other) {
            baseModel(other.getBaseModel());
            datasetId(other.getDatasetId());
            hyperparameters(other.getHyperparameters());
            multiLabel(other.getMultiLabel());
            wandb(other.getWandb());
            return this;
        }

        /**
         * <p>The base model to fine-tune.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("base_model")
        public DatasetIdStage baseModel(BaseModel baseModel) {
            this.baseModel = baseModel;
            return this;
        }

        /**
         * <p>The data used for training and evaluating the fine-tuned model.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("dataset_id")
        public _FinalStage datasetId(String datasetId) {
            this.datasetId = datasetId;
            return this;
        }

        /**
         * <p>The Weights &amp; Biases configuration (Chat fine-tuning only).</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage wandb(WandbConfig wandb) {
            this.wandb = Optional.of(wandb);
            return this;
        }

        @Override
        @JsonSetter(value = "wandb", nulls = Nulls.SKIP)
        public _FinalStage wandb(Optional<WandbConfig> wandb) {
            this.wandb = wandb;
            return this;
        }

        /**
         * <p>read-only. Whether the model is single-label or multi-label (only for classification).</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage multiLabel(Boolean multiLabel) {
            this.multiLabel = Optional.of(multiLabel);
            return this;
        }

        @Override
        @JsonSetter(value = "multi_label", nulls = Nulls.SKIP)
        public _FinalStage multiLabel(Optional<Boolean> multiLabel) {
            this.multiLabel = multiLabel;
            return this;
        }

        /**
         * <p>Fine-tuning hyper-parameters.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage hyperparameters(Hyperparameters hyperparameters) {
            this.hyperparameters = Optional.of(hyperparameters);
            return this;
        }

        @Override
        @JsonSetter(value = "hyperparameters", nulls = Nulls.SKIP)
        public _FinalStage hyperparameters(Optional<Hyperparameters> hyperparameters) {
            this.hyperparameters = hyperparameters;
            return this;
        }

        @Override
        public Settings build() {
            return new Settings(baseModel, datasetId, hyperparameters, multiLabel, wandb, additionalProperties);
        }
    }
}