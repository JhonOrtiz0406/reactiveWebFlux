package co.com.bancolombia.api.utils;

import co.com.bancolombia.api.scaffold.request.UserRequest;
import co.com.bancolombia.exceptions.BussinesErrorMessage;
import co.com.bancolombia.exceptions.CustomerBusinessException;
import jakarta.validation.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.*;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ValidateRequest {

    @Autowired
    private Validator validator;

    public Mono<UserRequest> validateRequest(UserRequest userRequest) throws ValidationException {
        Errors errors = new BeanPropertyBindingResult(userRequest, "userRequest");
        ValidationUtils.invokeValidator(validator, userRequest, errors);
        if (errors.getErrorCount() == 0) {
            return Mono.just(userRequest);
        }
        FieldError fieldError = errors.getFieldError("userRequest");
        String code = (fieldError != null) ? fieldError.getCode() : "499";
        var enumError = BussinesErrorMessage.getEnumStatusCode(code);
        var backEnd = CustomerBusinessException.ResponseBackEnd.builder().build();
        return Mono.error(() -> new CustomerBusinessException(enumError, backEnd));
    }
}
