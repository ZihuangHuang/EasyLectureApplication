/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.resources.v2;

import com.cohere.api.core.*;
import com.cohere.api.errors.*;
import com.cohere.api.resources.v2.requests.V2ChatRequest;
import com.cohere.api.resources.v2.requests.V2ChatStreamRequest;
import com.cohere.api.resources.v2.requests.V2EmbedRequest;
import com.cohere.api.resources.v2.requests.V2RerankRequest;
import com.cohere.api.resources.v2.types.V2RerankResponse;
import com.cohere.api.types.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import okhttp3.*;

import java.io.IOException;

public class V2Client {
    protected final ClientOptions clientOptions;

    public V2Client(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Generates a message from the model in response to a provided conversation. To learn how to use the Chat API with Streaming and RAG follow our Text Generation guides.
     */
    public Iterable<StreamedChatResponseV2> chatStream(V2ChatStreamRequest request) {
        return chatStream(request, null);
    }

    /**
     * Generates a message from the model in response to a provided conversation. To learn how to use the Chat API with Streaming and RAG follow our Text Generation guides.
     */
    public Iterable<StreamedChatResponseV2> chatStream(V2ChatStreamRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/chat")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new CohereApiError("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return new Stream<StreamedChatResponseV2>(
                        StreamedChatResponseV2.class, responseBody.charStream(), "\n");
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            try {
                switch (response.code()) {
                    case 400:
                        throw new CohereApiBadRequestError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 401:
                        throw new CohereApiUnauthorizedError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 403:
                        throw new CohereApiForbiddenError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 404:
                        throw new CohereApiNotFoundError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 422:
                        throw new CohereApiUnprocessableEntityError(ObjectMappers.JSON_MAPPER.readValue(
                                responseBodyString, UnprocessableEntityErrorBody.class));
                    case 429:
                        throw new CohereApiTooManyRequestsError(ObjectMappers.JSON_MAPPER.readValue(
                                responseBodyString, TooManyRequestsErrorBody.class));
                    case 499:
                        throw new CohereApiClientClosedRequestError(ObjectMappers.JSON_MAPPER.readValue(
                                responseBodyString, ClientClosedRequestErrorBody.class));
                    case 500:
                        throw new CohereApiInternalServerError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 501:
                        throw new CohereApiNotImplementedError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, NotImplementedErrorBody.class));
                    case 503:
                        throw new CohereApiServiceUnavailableError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 504:
                        throw new CohereApiGatewayTimeoutError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, GatewayTimeoutErrorBody.class));
                }
            } catch (JsonProcessingException ignored) {
                // unable to map error response, throwing generic error
            }
            throw new CohereApiApiError(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new CohereApiError("Network error executing HTTP request", e);
        }
    }

    /**
     * Generates a message from the model in response to a provided conversation. To learn how to use the Chat API with Streaming and RAG follow our Text Generation guides.
     */
    public ChatResponse chat(V2ChatRequest request) {
        return chat(request, null);
    }

    /**
     * Generates a message from the model in response to a provided conversation. To learn how to use the Chat API with Streaming and RAG follow our Text Generation guides.
     */
    public ChatResponse chat(V2ChatRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/chat")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new CohereApiError("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ChatResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            try {
                switch (response.code()) {
                    case 400:
                        throw new CohereApiBadRequestError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 401:
                        throw new CohereApiUnauthorizedError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 403:
                        throw new CohereApiForbiddenError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 404:
                        throw new CohereApiNotFoundError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 422:
                        throw new CohereApiUnprocessableEntityError(ObjectMappers.JSON_MAPPER.readValue(
                                responseBodyString, UnprocessableEntityErrorBody.class));
                    case 429:
                        throw new CohereApiTooManyRequestsError(ObjectMappers.JSON_MAPPER.readValue(
                                responseBodyString, TooManyRequestsErrorBody.class));
                    case 499:
                        throw new CohereApiClientClosedRequestError(ObjectMappers.JSON_MAPPER.readValue(
                                responseBodyString, ClientClosedRequestErrorBody.class));
                    case 500:
                        throw new CohereApiInternalServerError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 501:
                        throw new CohereApiNotImplementedError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, NotImplementedErrorBody.class));
                    case 503:
                        throw new CohereApiServiceUnavailableError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 504:
                        throw new CohereApiGatewayTimeoutError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, GatewayTimeoutErrorBody.class));
                }
            } catch (JsonProcessingException ignored) {
                // unable to map error response, throwing generic error
            }
            throw new CohereApiApiError(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new CohereApiError("Network error executing HTTP request", e);
        }
    }

    /**
     * This endpoint returns text embeddings. An embedding is a list of floating point numbers that captures semantic information about the text that it represents.
     * <p>Embeddings can be used to create text classifiers as well as empower semantic search. To learn more about embeddings, see the embedding page.</p>
     * <p>If you want to learn more how to use the embedding model, have a look at the <a href="/docs/semantic-search">Semantic Search Guide</a>.</p>
     */
    public EmbedByTypeResponse embed(V2EmbedRequest request) {
        return embed(request, null);
    }

    /**
     * This endpoint returns text embeddings. An embedding is a list of floating point numbers that captures semantic information about the text that it represents.
     * <p>Embeddings can be used to create text classifiers as well as empower semantic search. To learn more about embeddings, see the embedding page.</p>
     * <p>If you want to learn more how to use the embedding model, have a look at the <a href="/docs/semantic-search">Semantic Search Guide</a>.</p>
     */
    public EmbedByTypeResponse embed(V2EmbedRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/embed")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new CohereApiError("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), EmbedByTypeResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            try {
                switch (response.code()) {
                    case 400:
                        throw new CohereApiBadRequestError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 401:
                        throw new CohereApiUnauthorizedError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 403:
                        throw new CohereApiForbiddenError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 404:
                        throw new CohereApiNotFoundError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 422:
                        throw new CohereApiUnprocessableEntityError(ObjectMappers.JSON_MAPPER.readValue(
                                responseBodyString, UnprocessableEntityErrorBody.class));
                    case 429:
                        throw new CohereApiTooManyRequestsError(ObjectMappers.JSON_MAPPER.readValue(
                                responseBodyString, TooManyRequestsErrorBody.class));
                    case 499:
                        throw new CohereApiClientClosedRequestError(ObjectMappers.JSON_MAPPER.readValue(
                                responseBodyString, ClientClosedRequestErrorBody.class));
                    case 500:
                        throw new CohereApiInternalServerError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 501:
                        throw new CohereApiNotImplementedError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, NotImplementedErrorBody.class));
                    case 503:
                        throw new CohereApiServiceUnavailableError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 504:
                        throw new CohereApiGatewayTimeoutError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, GatewayTimeoutErrorBody.class));
                }
            } catch (JsonProcessingException ignored) {
                // unable to map error response, throwing generic error
            }
            throw new CohereApiApiError(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new CohereApiError("Network error executing HTTP request", e);
        }
    }

    /**
     * This endpoint takes in a query and a list of texts and produces an ordered array with each text assigned a relevance score.
     */
    public V2RerankResponse rerank(V2RerankRequest request) {
        return rerank(request, null);
    }

    /**
     * This endpoint takes in a query and a list of texts and produces an ordered array with each text assigned a relevance score.
     */
    public V2RerankResponse rerank(V2RerankRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v2/rerank")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new CohereApiError("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), V2RerankResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            try {
                switch (response.code()) {
                    case 400:
                        throw new CohereApiBadRequestError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 401:
                        throw new CohereApiUnauthorizedError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 403:
                        throw new CohereApiForbiddenError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 404:
                        throw new CohereApiNotFoundError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 422:
                        throw new CohereApiUnprocessableEntityError(ObjectMappers.JSON_MAPPER.readValue(
                                responseBodyString, UnprocessableEntityErrorBody.class));
                    case 429:
                        throw new CohereApiTooManyRequestsError(ObjectMappers.JSON_MAPPER.readValue(
                                responseBodyString, TooManyRequestsErrorBody.class));
                    case 499:
                        throw new CohereApiClientClosedRequestError(ObjectMappers.JSON_MAPPER.readValue(
                                responseBodyString, ClientClosedRequestErrorBody.class));
                    case 500:
                        throw new CohereApiInternalServerError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 501:
                        throw new CohereApiNotImplementedError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, NotImplementedErrorBody.class));
                    case 503:
                        throw new CohereApiServiceUnavailableError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
                    case 504:
                        throw new CohereApiGatewayTimeoutError(
                                ObjectMappers.JSON_MAPPER.readValue(responseBodyString, GatewayTimeoutErrorBody.class));
                }
            } catch (JsonProcessingException ignored) {
                // unable to map error response, throwing generic error
            }
            throw new CohereApiApiError(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new CohereApiError("Network error executing HTTP request", e);
        }
    }
}
