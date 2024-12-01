/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.resources.embedjobs;

import com.cohere.api.core.*;
import com.cohere.api.errors.*;
import com.cohere.api.resources.embedjobs.requests.CreateEmbedJobRequest;
import com.cohere.api.types.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import okhttp3.*;

import java.io.IOException;

public class EmbedJobsClient {
    protected final ClientOptions clientOptions;

    public EmbedJobsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * The list embed job endpoint allows users to view all embed jobs history for that specific user.
     */
    public ListEmbedJobResponse list() {
        return list(null);
    }

    /**
     * The list embed job endpoint allows users to view all embed jobs history for that specific user.
     */
    public ListEmbedJobResponse list(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/embed-jobs")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ListEmbedJobResponse.class);
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
     * This API launches an async Embed job for a <a href="https://docs.cohere.com/docs/datasets">Dataset</a> of type <code>embed-input</code>. The result of a completed embed job is new Dataset of type <code>embed-output</code>, which contains the original text entries and the corresponding embeddings.
     */
    public CreateEmbedJobResponse create(CreateEmbedJobRequest request) {
        return create(request, null);
    }

    /**
     * This API launches an async Embed job for a <a href="https://docs.cohere.com/docs/datasets">Dataset</a> of type <code>embed-input</code>. The result of a completed embed job is new Dataset of type <code>embed-output</code>, which contains the original text entries and the corresponding embeddings.
     */
    public CreateEmbedJobResponse create(CreateEmbedJobRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/embed-jobs")
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), CreateEmbedJobResponse.class);
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
     * This API retrieves the details about an embed job started by the same user.
     */
    public EmbedJob get(String id) {
        return get(id, null);
    }

    /**
     * This API retrieves the details about an embed job started by the same user.
     */
    public EmbedJob get(String id, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/embed-jobs")
                .addPathSegment(id)
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), EmbedJob.class);
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
     * This API allows users to cancel an active embed job. Once invoked, the embedding process will be terminated, and users will be charged for the embeddings processed up to the cancellation point. It's important to note that partial results will not be available to users after cancellation.
     */
    public void cancel(String id) {
        cancel(id, null);
    }

    /**
     * This API allows users to cancel an active embed job. Once invoked, the embedding process will be terminated, and users will be charged for the embeddings processed up to the cancellation point. It's important to note that partial results will not be available to users after cancellation.
     */
    public void cancel(String id, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/embed-jobs")
                .addPathSegment(id)
                .addPathSegments("cancel")
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", RequestBody.create("", null))
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return;
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