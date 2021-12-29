package academy.devdojo.webflux.exception.attributes;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

/**
 * created by:
 *
 * @author rafael for DevDusCorre on 29/12/2021
 */
@Component
public class CustomAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(final ServerRequest request, final ErrorAttributeOptions options) {
        var errorAttributesMap = super.getErrorAttributes(request, options);
        var throwable = getError(request);
        if (!(throwable instanceof ResponseStatusException ex)) {
            return errorAttributesMap;
        }
        errorAttributesMap.put("message", ex.getMessage());
        errorAttributesMap.put("developerMessage", "A ResponseStatusException Happened");
        return errorAttributesMap;

    }
}
