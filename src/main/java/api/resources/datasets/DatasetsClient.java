/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.resources.datasets;

import com.cohere.api.core.*;
import com.cohere.api.errors.*;
import com.cohere.api.resources.datasets.requests.DatasetsCreateRequest;
import com.cohere.api.resources.datasets.requests.DatasetsListRequest;
import com.cohere.api.resources.datasets.types.DatasetsCreateResponse;
import com.cohere.api.resources.datasets.types.DatasetsGetResponse;
import com.cohere.api.resources.datasets.types.DatasetsGetUsageResponse;
import com.cohere.api.resources.datasets.types.DatasetsListResponse;
import com.cohere.api.types.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;
import java.util.Optional;

public class DatasetsClient {
    protected final ClientOptions clientOptions;

    public DatasetsClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * List datasets that have been created.
     */
    public DatasetsListResponse list() {
        return list(DatasetsListRequest.builder().build());
    }

    /**
     * List datasets that have been created.
     */
    public DatasetsListResponse list(DatasetsListRequest request) {
        return list(request, null);
    }

    /**
     * List datasets that have been created.
     */
    public DatasetsListResponse list(DatasetsListRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/datasets");
        if (request.getDatasetType().isPresent()) {
            httpUrl.addQueryParameter("datasetType", request.getDatasetType().get());
        }
        if (request.getBefore().isPresent()) {
            httpUrl.addQueryParameter("before", request.getBefore().get().toString());
        }
        if (request.getAfter().isPresent()) {
            httpUrl.addQueryParameter("after", request.getAfter().get().toString());
        }
        if (request.getLimit().isPresent()) {
            httpUrl.addQueryParameter("limit", request.getLimit().get().toString());
        }
        if (request.getOffset().isPresent()) {
            httpUrl.addQueryParameter("offset", request.getOffset().get().toString());
        }
        if (request.getValidationStatus().isPresent()) {
            httpUrl.addQueryParameter(
                    "validationStatus", request.getValidationStatus().get().toString());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), DatasetsListResponse.class);
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
     * Create a dataset by uploading a file. See <a href="https://docs.cohere.com/docs/datasets#dataset-creation">'Dataset Creation'</a> for more information.
     */
    public DatasetsCreateResponse create(File data, Optional<File> evalData, DatasetsCreateRequest request) {
        return create(data, evalData, request, null);
    }

    /**
     * Create a dataset by uploading a file. See <a href="https://docs.cohere.com/docs/datasets#dataset-creation">'Dataset Creation'</a> for more information.
     */
    public DatasetsCreateResponse create(
            File data, Optional<File> evalData, DatasetsCreateRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/datasets");
        httpUrl.addQueryParameter("name", request.getName());
        httpUrl.addQueryParameter("type", request.getType().toString());
        if (request.getKeepOriginalFile().isPresent()) {
            httpUrl.addQueryParameter(
                    "keep_original_file", request.getKeepOriginalFile().get().toString());
        }
        if (request.getSkipMalformedInput().isPresent()) {
            httpUrl.addQueryParameter(
                    "skip_malformed_input",
                    request.getSkipMalformedInput().get().toString());
        }
        if (request.getKeepFields().isPresent()) {
            httpUrl.addQueryParameter("keep_fields", request.getKeepFields().get());
        }
        if (request.getOptionalFields().isPresent()) {
            httpUrl.addQueryParameter(
                    "optional_fields", request.getOptionalFields().get());
        }
        if (request.getTextSeparator().isPresent()) {
            httpUrl.addQueryParameter(
                    "text_separator", request.getTextSeparator().get());
        }
        if (request.getCsvDelimiter().isPresent()) {
            httpUrl.addQueryParameter("csv_delimiter", request.getCsvDelimiter().get());
        }
        if (request.getDryRun().isPresent()) {
            httpUrl.addQueryParameter("dry_run", request.getDryRun().get().toString());
        }
        MultipartBody.Builder body = new MultipartBody.Builder().setType(MultipartBody.FORM);
        try {
            String dataMimeType = Files.probeContentType(data.toPath());
            MediaType dataMimeTypeMediaType = dataMimeType != null ? MediaType.parse(dataMimeType) : null;
            body.addFormDataPart("data", data.getName(), RequestBody.create(dataMimeTypeMediaType, data));
            if (evalData.isPresent()) {
                String evalDataMimeType = Files.probeContentType(evalData.get().toPath());
                MediaType evalDataMimeTypeMediaType =
                        evalDataMimeType != null ? MediaType.parse(evalDataMimeType) : null;
                body.addFormDataPart(
                        "eval_data",
                        evalData.get().getName(),
                        RequestBody.create(evalDataMimeTypeMediaType, evalData.get()));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("POST", body.build())
                .headers(Headers.of(clientOptions.headers(requestOptions)));
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), DatasetsCreateResponse.class);
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
     * View the dataset storage usage for your Organization. Each Organization can have up to 10GB of storage across all their users.
     */
    public DatasetsGetUsageResponse getUsage() {
        return getUsage(null);
    }

    /**
     * View the dataset storage usage for your Organization. Each Organization can have up to 10GB of storage across all their users.
     */
    public DatasetsGetUsageResponse getUsage(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/datasets/usage")
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), DatasetsGetUsageResponse.class);
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
     * Retrieve a dataset by ID. See <a href="https://docs.cohere.com/docs/datasets">'Datasets'</a> for more information.
     */
    public DatasetsGetResponse get(String id) {
        return get(id, null);
    }

    /**
     * Retrieve a dataset by ID. See <a href="https://docs.cohere.com/docs/datasets">'Datasets'</a> for more information.
     */
    public DatasetsGetResponse get(String id, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/datasets")
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), DatasetsGetResponse.class);
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
     * Delete a dataset by ID. Datasets are automatically deleted after 30 days, but they can also be deleted manually.
     */
    public Map<String, Object> delete(String id) {
        return delete(id, null);
    }

    /**
     * Delete a dataset by ID. Datasets are automatically deleted after 30 days, but they can also be deleted manually.
     */
    public Map<String, Object> delete(String id, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("v1/datasets")
                .addPathSegment(id)
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("DELETE", null)
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
                return ObjectMappers.JSON_MAPPER.readValue(
                        responseBody.string(), new TypeReference<Map<String, Object>>() {});
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
