/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.types;

import com.cohere.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.*;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ClassifyResponseClassificationsItem.Builder.class)
public final class ClassifyResponseClassificationsItem {
    private final String id;

    private final Optional<String> input;

    private final Optional<String> prediction;

    private final List<String> predictions;

    private final Optional<Double> confidence;

    private final List<Double> confidences;

    private final Map<String, ClassifyResponseClassificationsItemLabelsValue> labels;

    private final ClassifyResponseClassificationsItemClassificationType classificationType;

    private final Map<String, Object> additionalProperties;

    private ClassifyResponseClassificationsItem(
            String id,
            Optional<String> input,
            Optional<String> prediction,
            List<String> predictions,
            Optional<Double> confidence,
            List<Double> confidences,
            Map<String, ClassifyResponseClassificationsItemLabelsValue> labels,
            ClassifyResponseClassificationsItemClassificationType classificationType,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.input = input;
        this.prediction = prediction;
        this.predictions = predictions;
        this.confidence = confidence;
        this.confidences = confidences;
        this.labels = labels;
        this.classificationType = classificationType;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return The input text that was classified
     */
    @JsonProperty("input")
    public Optional<String> getInput() {
        return input;
    }

    /**
     * @return The predicted label for the associated query (only filled for single-label models)
     */
    @JsonProperty("prediction")
    public Optional<String> getPrediction() {
        return prediction;
    }

    /**
     * @return An array containing the predicted labels for the associated query (only filled for single-label classification)
     */
    @JsonProperty("predictions")
    public List<String> getPredictions() {
        return predictions;
    }

    /**
     * @return The confidence score for the top predicted class (only filled for single-label classification)
     */
    @JsonProperty("confidence")
    public Optional<Double> getConfidence() {
        return confidence;
    }

    /**
     * @return An array containing the confidence scores of all the predictions in the same order
     */
    @JsonProperty("confidences")
    public List<Double> getConfidences() {
        return confidences;
    }

    /**
     * @return A map containing each label and its confidence score according to the classifier. All the confidence scores add up to 1 for single-label classification. For multi-label classification the label confidences are independent of each other, so they don't have to sum up to 1.
     */
    @JsonProperty("labels")
    public Map<String, ClassifyResponseClassificationsItemLabelsValue> getLabels() {
        return labels;
    }

    /**
     * @return The type of classification performed
     */
    @JsonProperty("classification_type")
    public ClassifyResponseClassificationsItemClassificationType getClassificationType() {
        return classificationType;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ClassifyResponseClassificationsItem
                && equalTo((ClassifyResponseClassificationsItem) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ClassifyResponseClassificationsItem other) {
        return id.equals(other.id)
                && input.equals(other.input)
                && prediction.equals(other.prediction)
                && predictions.equals(other.predictions)
                && confidence.equals(other.confidence)
                && confidences.equals(other.confidences)
                && labels.equals(other.labels)
                && classificationType.equals(other.classificationType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.input,
                this.prediction,
                this.predictions,
                this.confidence,
                this.confidences,
                this.labels,
                this.classificationType);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        ClassificationTypeStage id(String id);

        Builder from(ClassifyResponseClassificationsItem other);
    }

    public interface ClassificationTypeStage {
        _FinalStage classificationType(ClassifyResponseClassificationsItemClassificationType classificationType);
    }

    public interface _FinalStage {
        ClassifyResponseClassificationsItem build();

        _FinalStage input(Optional<String> input);

        _FinalStage input(String input);

        _FinalStage prediction(Optional<String> prediction);

        _FinalStage prediction(String prediction);

        _FinalStage predictions(List<String> predictions);

        _FinalStage addPredictions(String predictions);

        _FinalStage addAllPredictions(List<String> predictions);

        _FinalStage confidence(Optional<Double> confidence);

        _FinalStage confidence(Double confidence);

        _FinalStage confidences(List<Double> confidences);

        _FinalStage addConfidences(Double confidences);

        _FinalStage addAllConfidences(List<Double> confidences);

        _FinalStage labels(Map<String, ClassifyResponseClassificationsItemLabelsValue> labels);

        _FinalStage putAllLabels(Map<String, ClassifyResponseClassificationsItemLabelsValue> labels);

        _FinalStage labels(String key, ClassifyResponseClassificationsItemLabelsValue value);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, ClassificationTypeStage, _FinalStage {
        private String id;

        private ClassifyResponseClassificationsItemClassificationType classificationType;

        private Map<String, ClassifyResponseClassificationsItemLabelsValue> labels = new LinkedHashMap<>();

        private List<Double> confidences = new ArrayList<>();

        private Optional<Double> confidence = Optional.empty();

        private List<String> predictions = new ArrayList<>();

        private Optional<String> prediction = Optional.empty();

        private Optional<String> input = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(ClassifyResponseClassificationsItem other) {
            id(other.getId());
            input(other.getInput());
            prediction(other.getPrediction());
            predictions(other.getPredictions());
            confidence(other.getConfidence());
            confidences(other.getConfidences());
            labels(other.getLabels());
            classificationType(other.getClassificationType());
            return this;
        }

        @Override
        @JsonSetter("id")
        public ClassificationTypeStage id(String id) {
            this.id = id;
            return this;
        }

        /**
         * <p>The type of classification performed</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("classification_type")
        public _FinalStage classificationType(
                ClassifyResponseClassificationsItemClassificationType classificationType) {
            this.classificationType = classificationType;
            return this;
        }

        /**
         * <p>A map containing each label and its confidence score according to the classifier. All the confidence scores add up to 1 for single-label classification. For multi-label classification the label confidences are independent of each other, so they don't have to sum up to 1.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage labels(String key, ClassifyResponseClassificationsItemLabelsValue value) {
            this.labels.put(key, value);
            return this;
        }

        /**
         * <p>A map containing each label and its confidence score according to the classifier. All the confidence scores add up to 1 for single-label classification. For multi-label classification the label confidences are independent of each other, so they don't have to sum up to 1.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage putAllLabels(Map<String, ClassifyResponseClassificationsItemLabelsValue> labels) {
            this.labels.putAll(labels);
            return this;
        }

        @Override
        @JsonSetter(value = "labels", nulls = Nulls.SKIP)
        public _FinalStage labels(Map<String, ClassifyResponseClassificationsItemLabelsValue> labels) {
            this.labels.clear();
            this.labels.putAll(labels);
            return this;
        }

        /**
         * <p>An array containing the confidence scores of all the predictions in the same order</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllConfidences(List<Double> confidences) {
            this.confidences.addAll(confidences);
            return this;
        }

        /**
         * <p>An array containing the confidence scores of all the predictions in the same order</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addConfidences(Double confidences) {
            this.confidences.add(confidences);
            return this;
        }

        @Override
        @JsonSetter(value = "confidences", nulls = Nulls.SKIP)
        public _FinalStage confidences(List<Double> confidences) {
            this.confidences.clear();
            this.confidences.addAll(confidences);
            return this;
        }

        /**
         * <p>The confidence score for the top predicted class (only filled for single-label classification)</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage confidence(Double confidence) {
            this.confidence = Optional.of(confidence);
            return this;
        }

        @Override
        @JsonSetter(value = "confidence", nulls = Nulls.SKIP)
        public _FinalStage confidence(Optional<Double> confidence) {
            this.confidence = confidence;
            return this;
        }

        /**
         * <p>An array containing the predicted labels for the associated query (only filled for single-label classification)</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllPredictions(List<String> predictions) {
            this.predictions.addAll(predictions);
            return this;
        }

        /**
         * <p>An array containing the predicted labels for the associated query (only filled for single-label classification)</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addPredictions(String predictions) {
            this.predictions.add(predictions);
            return this;
        }

        @Override
        @JsonSetter(value = "predictions", nulls = Nulls.SKIP)
        public _FinalStage predictions(List<String> predictions) {
            this.predictions.clear();
            this.predictions.addAll(predictions);
            return this;
        }

        /**
         * <p>The predicted label for the associated query (only filled for single-label models)</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage prediction(String prediction) {
            this.prediction = Optional.of(prediction);
            return this;
        }

        @Override
        @JsonSetter(value = "prediction", nulls = Nulls.SKIP)
        public _FinalStage prediction(Optional<String> prediction) {
            this.prediction = prediction;
            return this;
        }

        /**
         * <p>The input text that was classified</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage input(String input) {
            this.input = Optional.of(input);
            return this;
        }

        @Override
        @JsonSetter(value = "input", nulls = Nulls.SKIP)
        public _FinalStage input(Optional<String> input) {
            this.input = input;
            return this;
        }

        @Override
        public ClassifyResponseClassificationsItem build() {
            return new ClassifyResponseClassificationsItem(
                    id,
                    input,
                    prediction,
                    predictions,
                    confidence,
                    confidences,
                    labels,
                    classificationType,
                    additionalProperties);
        }
    }
}
