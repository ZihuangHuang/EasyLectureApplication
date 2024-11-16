/**
 * This file was auto-generated by Fern from our API Definition.
 */
package api.errors;

import com.cohere.api.core.CohereApiApiError;
import com.cohere.api.types.GatewayTimeoutErrorBody;

public final class CohereApiGatewayTimeoutError extends CohereApiApiError {
    /**
     * The body of the response that triggered the exception.
     */
    private final GatewayTimeoutErrorBody body;

    public CohereApiGatewayTimeoutError(GatewayTimeoutErrorBody body) {
        super("GatewayTimeoutError", 504, body);
        this.body = body;
    }

    /**
     * @return the body
     */
    @Override
    public GatewayTimeoutErrorBody body() {
        return this.body;
    }
}