package academy.devdojo.webflux.exception.handler;

import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.ErrorAttributes;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

import static org.springframework.boot.web.error.ErrorAttributeOptions.defaults;
import static org.springframework.util.ObjectUtils.isEmpty;

/**
 * created by:
 *
 * @author rafael for DevDusCorre on 29/12/2021
 */
@Component
@Order(-2)
public class GlobalExceptionHandler extends AbstractErrorWebExceptionHandler {

    public GlobalExceptionHandler(final ErrorAttributes errorAttributes,
                                  final WebProperties.Resources resourceProperties,
                                  final ApplicationContext applicationContext,
                                  final ServerCodecConfigurer codecConfigurer) {
        super(errorAttributes, resourceProperties, applicationContext);
        this.setMessageWriters(codecConfigurer.getWriters());
    }

    @Override
    protected RouterFunction<ServerResponse> getRoutingFunction(final ErrorAttributes errorAttributes) {
        return RouterFunctions.route(RequestPredicates.all(), this::formatErrorResponse);
    }

    private Mono<ServerResponse> formatErrorResponse(final ServerRequest request) {
        var query = request.uri().getQuery();
        var errorAttributeOptions = isTraceEnabled(query) ?
                ErrorAttributeOptions.of(ErrorAttributeOptions.Include.STACK_TRACE) : defaults();

        var errorAttributesMap = getErrorAttributes(request, errorAttributeOptions);
        var status = (int) Optional.ofNullable(errorAttributesMap.get("status")).orElse(500);
        return ServerResponse
                .status(status)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(errorAttributesMap));
    }

    private boolean isTraceEnabled(String query) {
        return !isEmpty(query) && query.contains("trace=true");
    }
}

