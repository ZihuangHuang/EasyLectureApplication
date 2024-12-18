/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public final class RequestOptions {
    private final String token;

    private final String clientName;

    private final Optional<Integer> timeout;

    private final TimeUnit timeoutTimeUnit;

    private RequestOptions(String token, String clientName, Optional<Integer> timeout, TimeUnit timeoutTimeUnit) {
        this.token = token;
        this.clientName = clientName;
        this.timeout = timeout;
        this.timeoutTimeUnit = timeoutTimeUnit;
    }

    public Optional<Integer> getTimeout() {
        return timeout;
    }

    public TimeUnit getTimeoutTimeUnit() {
        return timeoutTimeUnit;
    }

    public Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        if (this.token != null) {
            headers.put("Authorization", "Bearer " + this.token);
        }
        if (this.clientName != null) {
            headers.put("X-Client-Name", this.clientName);
        }
        return headers;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String token = null;

        private String clientName = null;

        private Optional<Integer> timeout = Optional.empty();

        private TimeUnit timeoutTimeUnit = TimeUnit.SECONDS;

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder clientName(String clientName) {
            this.clientName = clientName;
            return this;
        }

        public Builder timeout(Integer timeout) {
            this.timeout = Optional.of(timeout);
            return this;
        }

        public Builder timeout(Integer timeout, TimeUnit timeoutTimeUnit) {
            this.timeout = Optional.of(timeout);
            this.timeoutTimeUnit = timeoutTimeUnit;
            return this;
        }

        public RequestOptions build() {
            return new RequestOptions(token, clientName, timeout, timeoutTimeUnit);
        }
    }
}
