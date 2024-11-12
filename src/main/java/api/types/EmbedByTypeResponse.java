/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.types;

import com.cohere.api.core.ObjectMappers;
import com.cohere.api.types.ApiMeta;
import com.cohere.api.types.EmbedByTypeResponseEmbeddings;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = EmbedByTypeResponse.Builder.class)
public final class EmbedByTypeResponse {
    private final String id;

    private final EmbedByTypeResponseEmbeddings embeddings;

    private final List<String> texts;

    private final Optional<ApiMeta> meta;

    private final Map<String, Object> additionalProperties;

    private EmbedByTypeResponse(
            String id,
            EmbedByTypeResponseEmbeddings embeddings,
            List<String> texts,
            Optional<ApiMeta> meta,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.embeddings = embeddings;
        this.texts = texts;
        this.meta = meta;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * @return An object with different embedding types. The length of each embedding type array will be the same as the length of the original <code>texts</code> array.
     */
    @JsonProperty("embeddings")
    public EmbedByTypeResponseEmbeddings getEmbeddings() {
        return embeddings;
    }

    /**
     * @return The text entries for which embeddings were returned.
     */
    @JsonProperty("texts")
    public List<String> getTexts() {
        return texts;
    }

    @JsonProperty("meta")
    public Optional<ApiMeta> getMeta() {
        return meta;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof EmbedByTypeResponse && equalTo((EmbedByTypeResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(EmbedByTypeResponse other) {
        return id.equals(other.id)
                && embeddings.equals(other.embeddings)
                && texts.equals(other.texts)
                && meta.equals(other.meta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.embeddings, this.texts, this.meta);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdStage builder() {
        return new Builder();
    }

    public interface IdStage {
        EmbeddingsStage id(String id);

        Builder from(EmbedByTypeResponse other);
    }

    public interface EmbeddingsStage {
        _FinalStage embeddings(EmbedByTypeResponseEmbeddings embeddings);
    }

    public interface _FinalStage {
        EmbedByTypeResponse build();

        _FinalStage texts(List<String> texts);

        _FinalStage addTexts(String texts);

        _FinalStage addAllTexts(List<String> texts);

        _FinalStage meta(Optional<ApiMeta> meta);

        _FinalStage meta(ApiMeta meta);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdStage, EmbeddingsStage, _FinalStage {
        private String id;

        private EmbedByTypeResponseEmbeddings embeddings;

        private Optional<ApiMeta> meta = Optional.empty();

        private List<String> texts = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(EmbedByTypeResponse other) {
            id(other.getId());
            embeddings(other.getEmbeddings());
            texts(other.getTexts());
            meta(other.getMeta());
            return this;
        }

        @Override
        @JsonSetter("id")
        public EmbeddingsStage id(String id) {
            this.id = id;
            return this;
        }

        /**
         * <p>An object with different embedding types. The length of each embedding type array will be the same as the length of the original <code>texts</code> array.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("embeddings")
        public _FinalStage embeddings(EmbedByTypeResponseEmbeddings embeddings) {
            this.embeddings = embeddings;
            return this;
        }

        @Override
        public _FinalStage meta(ApiMeta meta) {
            this.meta = Optional.of(meta);
            return this;
        }

        @Override
        @JsonSetter(value = "meta", nulls = Nulls.SKIP)
        public _FinalStage meta(Optional<ApiMeta> meta) {
            this.meta = meta;
            return this;
        }

        /**
         * <p>The text entries for which embeddings were returned.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllTexts(List<String> texts) {
            this.texts.addAll(texts);
            return this;
        }

        /**
         * <p>The text entries for which embeddings were returned.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addTexts(String texts) {
            this.texts.add(texts);
            return this;
        }

        @Override
        @JsonSetter(value = "texts", nulls = Nulls.SKIP)
        public _FinalStage texts(List<String> texts) {
            this.texts.clear();
            this.texts.addAll(texts);
            return this;
        }

        @Override
        public EmbedByTypeResponse build() {
            return new EmbedByTypeResponse(id, embeddings, texts, meta, additionalProperties);
        }
    }
}
