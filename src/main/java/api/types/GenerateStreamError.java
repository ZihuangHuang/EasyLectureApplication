/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.types;

import com.cohere.api.core.ObjectMappers;
import com.cohere.api.types.FinishReason;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GenerateStreamError.Builder.class)
public final class GenerateStreamError implements IGenerateStreamEvent {
    private final Optional<Integer> index;

    private final boolean isFinished;

    private final FinishReason finishReason;

    private final String err;

    private final Map<String, Object> additionalProperties;

    private GenerateStreamError(
            Optional<Integer> index,
            boolean isFinished,
            FinishReason finishReason,
            String err,
            Map<String, Object> additionalProperties) {
        this.index = index;
        this.isFinished = isFinished;
        this.finishReason = finishReason;
        this.err = err;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Refers to the nth generation. Only present when <code>num_generations</code> is greater than zero.
     */
    @JsonProperty("index")
    public Optional<Integer> getIndex() {
        return index;
    }

    @JsonProperty("is_finished")
    public boolean getIsFinished() {
        return isFinished;
    }

    @JsonProperty("finish_reason")
    public FinishReason getFinishReason() {
        return finishReason;
    }

    /**
     * @return Error message
     */
    @JsonProperty("err")
    public String getErr() {
        return err;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GenerateStreamError && equalTo((GenerateStreamError) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GenerateStreamError other) {
        return index.equals(other.index)
                && isFinished == other.isFinished
                && finishReason.equals(other.finishReason)
                && err.equals(other.err);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.index, this.isFinished, this.finishReason, this.err);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IsFinishedStage builder() {
        return new Builder();
    }

    public interface IsFinishedStage {
        FinishReasonStage isFinished(boolean isFinished);

        Builder from(GenerateStreamError other);
    }

    public interface FinishReasonStage {
        ErrStage finishReason(FinishReason finishReason);
    }

    public interface ErrStage {
        _FinalStage err(String err);
    }

    public interface _FinalStage {
        GenerateStreamError build();

        _FinalStage index(Optional<Integer> index);

        _FinalStage index(Integer index);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IsFinishedStage, FinishReasonStage, ErrStage, _FinalStage {
        private boolean isFinished;

        private FinishReason finishReason;

        private String err;

        private Optional<Integer> index = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(GenerateStreamError other) {
            index(other.getIndex());
            isFinished(other.getIsFinished());
            finishReason(other.getFinishReason());
            err(other.getErr());
            return this;
        }

        @Override
        @JsonSetter("is_finished")
        public FinishReasonStage isFinished(boolean isFinished) {
            this.isFinished = isFinished;
            return this;
        }

        @Override
        @JsonSetter("finish_reason")
        public ErrStage finishReason(FinishReason finishReason) {
            this.finishReason = finishReason;
            return this;
        }

        /**
         * <p>Error message</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("err")
        public _FinalStage err(String err) {
            this.err = err;
            return this;
        }

        /**
         * <p>Refers to the nth generation. Only present when <code>num_generations</code> is greater than zero.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage index(Integer index) {
            this.index = Optional.of(index);
            return this;
        }

        @Override
        @JsonSetter(value = "index", nulls = Nulls.SKIP)
        public _FinalStage index(Optional<Integer> index) {
            this.index = index;
            return this;
        }

        @Override
        public GenerateStreamError build() {
            return new GenerateStreamError(index, isFinished, finishReason, err, additionalProperties);
        }
    }
}
