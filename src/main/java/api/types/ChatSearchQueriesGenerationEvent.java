/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.types;

import com.cohere.api.core.ObjectMappers;
import com.cohere.api.types.ChatSearchQuery;
import com.cohere.api.types.IChatStreamEvent;
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

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ChatSearchQueriesGenerationEvent.Builder.class)
public final class ChatSearchQueriesGenerationEvent implements IChatStreamEvent {
    private final List<ChatSearchQuery> searchQueries;

    private final Map<String, Object> additionalProperties;

    private ChatSearchQueriesGenerationEvent(
            List<ChatSearchQuery> searchQueries, Map<String, Object> additionalProperties) {
        this.searchQueries = searchQueries;
        this.additionalProperties = additionalProperties;
    }

    /**
     * @return Generated search queries, meant to be used as part of the RAG flow.
     */
    @JsonProperty("search_queries")
    public List<ChatSearchQuery> getSearchQueries() {
        return searchQueries;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ChatSearchQueriesGenerationEvent && equalTo((ChatSearchQueriesGenerationEvent) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ChatSearchQueriesGenerationEvent other) {
        return searchQueries.equals(other.searchQueries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.searchQueries);
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
        private List<ChatSearchQuery> searchQueries = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ChatSearchQueriesGenerationEvent other) {
            searchQueries(other.getSearchQueries());
            return this;
        }

        @JsonSetter(value = "search_queries", nulls = Nulls.SKIP)
        public Builder searchQueries(List<ChatSearchQuery> searchQueries) {
            this.searchQueries.clear();
            this.searchQueries.addAll(searchQueries);
            return this;
        }

        public Builder addSearchQueries(ChatSearchQuery searchQueries) {
            this.searchQueries.add(searchQueries);
            return this;
        }

        public Builder addAllSearchQueries(List<ChatSearchQuery> searchQueries) {
            this.searchQueries.addAll(searchQueries);
            return this;
        }

        public ChatSearchQueriesGenerationEvent build() {
            return new ChatSearchQueriesGenerationEvent(searchQueries, additionalProperties);
        }
    }
}