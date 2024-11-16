/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.resources.finetuning.finetuning.types;

import com.cohere.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = FinetunedModel.Builder.class)
public final class FinetunedModel {
    private final Optional<String> id;

    private final String name;

    private final Optional<String> creatorId;

    private final Optional<String> organizationId;

    private final Settings settings;

    private final Optional<Status> status;

    private final Optional<OffsetDateTime> createdAt;

    private final Optional<OffsetDateTime> updatedAt;

    private final Optional<OffsetDateTime> completedAt;

    private final Optional<OffsetDateTime> lastUsed;

    private final Map<String, Object> additionalProperties;

    private FinetunedModel(
            Optional<String> id,
            String name,
            Optional<String> creatorId,
            Optional<String> organizationId,
            Settings settings,
            Optional<Status> status,
            Optional<OffsetDateTime> createdAt,
            Optional<OffsetDateTime> updatedAt,
            Optional<OffsetDateTime> completedAt,
            Optional<OffsetDateTime> lastUsed,
            Map<String, Object> additionalProperties) {
        this.id = id;
        this.name = name;
        this.creatorId = creatorId;
        this.organizationId = organizationId;
        this.settings = settings;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.completedAt = completedAt;
        this.lastUsed = lastUsed;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return read-only. FinetunedModel ID.
     */
    @JsonProperty("id")
    public Optional<String> getId() {
        return id;
    }

    /**
     * @return FinetunedModel name (e.g. <code>foobar</code>).
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @return read-only. User ID of the creator.
     */
    @JsonProperty("creator_id")
    public Optional<String> getCreatorId() {
        return creatorId;
    }

    /**
     * @return read-only. Organization ID.
     */
    @JsonProperty("organization_id")
    public Optional<String> getOrganizationId() {
        return organizationId;
    }

    /**
     * @return FinetunedModel settings such as dataset, hyperparameters...
     */
    @JsonProperty("settings")
    public Settings getSettings() {
        return settings;
    }

    /**
     * @return read-only. Current stage in the life-cycle of the fine-tuned model.
     */
    @JsonProperty("status")
    public Optional<Status> getStatus() {
        return status;
    }

    /**
     * @return read-only. Creation timestamp.
     */
    @JsonProperty("created_at")
    public Optional<OffsetDateTime> getCreatedAt() {
        return createdAt;
    }

    /**
     * @return read-only. Latest update timestamp.
     */
    @JsonProperty("updated_at")
    public Optional<OffsetDateTime> getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @return read-only. Timestamp for the completed fine-tuning.
     */
    @JsonProperty("completed_at")
    public Optional<OffsetDateTime> getCompletedAt() {
        return completedAt;
    }

    /**
     * @return read-only. Timestamp for the latest request to this fine-tuned model.
     */
    @JsonProperty("last_used")
    public Optional<OffsetDateTime> getLastUsed() {
        return lastUsed;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof FinetunedModel && equalTo((FinetunedModel) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(FinetunedModel other) {
        return id.equals(other.id)
                && name.equals(other.name)
                && creatorId.equals(other.creatorId)
                && organizationId.equals(other.organizationId)
                && settings.equals(other.settings)
                && status.equals(other.status)
                && createdAt.equals(other.createdAt)
                && updatedAt.equals(other.updatedAt)
                && completedAt.equals(other.completedAt)
                && lastUsed.equals(other.lastUsed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.id,
                this.name,
                this.creatorId,
                this.organizationId,
                this.settings,
                this.status,
                this.createdAt,
                this.updatedAt,
                this.completedAt,
                this.lastUsed);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        SettingsStage name(String name);

        Builder from(FinetunedModel other);
    }

    public interface SettingsStage {
        _FinalStage settings(Settings settings);
    }

    public interface _FinalStage {
        FinetunedModel build();

        _FinalStage id(Optional<String> id);

        _FinalStage id(String id);

        _FinalStage creatorId(Optional<String> creatorId);

        _FinalStage creatorId(String creatorId);

        _FinalStage organizationId(Optional<String> organizationId);

        _FinalStage organizationId(String organizationId);

        _FinalStage status(Optional<Status> status);

        _FinalStage status(Status status);

        _FinalStage createdAt(Optional<OffsetDateTime> createdAt);

        _FinalStage createdAt(OffsetDateTime createdAt);

        _FinalStage updatedAt(Optional<OffsetDateTime> updatedAt);

        _FinalStage updatedAt(OffsetDateTime updatedAt);

        _FinalStage completedAt(Optional<OffsetDateTime> completedAt);

        _FinalStage completedAt(OffsetDateTime completedAt);

        _FinalStage lastUsed(Optional<OffsetDateTime> lastUsed);

        _FinalStage lastUsed(OffsetDateTime lastUsed);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, SettingsStage, _FinalStage {
        private String name;

        private Settings settings;

        private Optional<OffsetDateTime> lastUsed = Optional.empty();

        private Optional<OffsetDateTime> completedAt = Optional.empty();

        private Optional<OffsetDateTime> updatedAt = Optional.empty();

        private Optional<OffsetDateTime> createdAt = Optional.empty();

        private Optional<Status> status = Optional.empty();

        private Optional<String> organizationId = Optional.empty();

        private Optional<String> creatorId = Optional.empty();

        private Optional<String> id = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @Override
        public Builder from(FinetunedModel other) {
            id(other.getId());
            name(other.getName());
            creatorId(other.getCreatorId());
            organizationId(other.getOrganizationId());
            settings(other.getSettings());
            status(other.getStatus());
            createdAt(other.getCreatedAt());
            updatedAt(other.getUpdatedAt());
            completedAt(other.getCompletedAt());
            lastUsed(other.getLastUsed());
            return this;
        }

        /**
         * <p>FinetunedModel name (e.g. <code>foobar</code>).</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name")
        public SettingsStage name(String name) {
            this.name = name;
            return this;
        }

        /**
         * <p>FinetunedModel settings such as dataset, hyperparameters...</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("settings")
        public _FinalStage settings(Settings settings) {
            this.settings = settings;
            return this;
        }

        /**
         * <p>read-only. Timestamp for the latest request to this fine-tuned model.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage lastUsed(OffsetDateTime lastUsed) {
            this.lastUsed = Optional.of(lastUsed);
            return this;
        }

        @Override
        @JsonSetter(value = "last_used", nulls = Nulls.SKIP)
        public _FinalStage lastUsed(Optional<OffsetDateTime> lastUsed) {
            this.lastUsed = lastUsed;
            return this;
        }

        /**
         * <p>read-only. Timestamp for the completed fine-tuning.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage completedAt(OffsetDateTime completedAt) {
            this.completedAt = Optional.of(completedAt);
            return this;
        }

        @Override
        @JsonSetter(value = "completed_at", nulls = Nulls.SKIP)
        public _FinalStage completedAt(Optional<OffsetDateTime> completedAt) {
            this.completedAt = completedAt;
            return this;
        }

        /**
         * <p>read-only. Latest update timestamp.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage updatedAt(OffsetDateTime updatedAt) {
            this.updatedAt = Optional.of(updatedAt);
            return this;
        }

        @Override
        @JsonSetter(value = "updated_at", nulls = Nulls.SKIP)
        public _FinalStage updatedAt(Optional<OffsetDateTime> updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        /**
         * <p>read-only. Creation timestamp.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage createdAt(OffsetDateTime createdAt) {
            this.createdAt = Optional.of(createdAt);
            return this;
        }

        @Override
        @JsonSetter(value = "created_at", nulls = Nulls.SKIP)
        public _FinalStage createdAt(Optional<OffsetDateTime> createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        /**
         * <p>read-only. Current stage in the life-cycle of the fine-tuned model.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage status(Status status) {
            this.status = Optional.of(status);
            return this;
        }

        @Override
        @JsonSetter(value = "status", nulls = Nulls.SKIP)
        public _FinalStage status(Optional<Status> status) {
            this.status = status;
            return this;
        }

        /**
         * <p>read-only. Organization ID.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage organizationId(String organizationId) {
            this.organizationId = Optional.of(organizationId);
            return this;
        }

        @Override
        @JsonSetter(value = "organization_id", nulls = Nulls.SKIP)
        public _FinalStage organizationId(Optional<String> organizationId) {
            this.organizationId = organizationId;
            return this;
        }

        /**
         * <p>read-only. User ID of the creator.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage creatorId(String creatorId) {
            this.creatorId = Optional.of(creatorId);
            return this;
        }

        @Override
        @JsonSetter(value = "creator_id", nulls = Nulls.SKIP)
        public _FinalStage creatorId(Optional<String> creatorId) {
            this.creatorId = creatorId;
            return this;
        }

        /**
         * <p>read-only. FinetunedModel ID.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage id(String id) {
            this.id = Optional.of(id);
            return this;
        }

        @Override
        @JsonSetter(value = "id", nulls = Nulls.SKIP)
        public _FinalStage id(Optional<String> id) {
            this.id = id;
            return this;
        }

        @Override
        public FinetunedModel build() {
            return new FinetunedModel(
                    id,
                    name,
                    creatorId,
                    organizationId,
                    settings,
                    status,
                    createdAt,
                    updatedAt,
                    completedAt,
                    lastUsed,
                    additionalProperties);
        }
    }
}