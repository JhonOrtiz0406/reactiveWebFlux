import co.com.bancolombia.api.scaffold.request.RequestDataUser;
import co.com.bancolombia.api.scaffold.request.UserRequest;
import co.com.bancolombia.api.utils.ValidateRequest;
import co.com.bancolombia.exceptions.CustomerBusinessException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import reactor.test.StepVerifier;

public class ValidateRequestTest {

    private ValidateRequest validateRequest;

    @BeforeEach
    void setUp() {
        validateRequest = new ValidateRequest();
        LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
        validatorFactoryBean.afterPropertiesSet();
        ReflectionTestUtils.setField(validateRequest, "validator", validatorFactoryBean, Validator.class);
    }

    @Test
    void validateRequestValid() {
        UserRequest request = UserRequest.builder()
                .data(RequestDataUser.builder().message("hello").build())
                .build();

        StepVerifier.create(validateRequest.validateRequest(request))
                .expectNext(request)
                .verifyComplete();
    }

    @Test
    void validateRequestInvalid() {
        UserRequest request = UserRequest.builder().build();

        StepVerifier.create(validateRequest.validateRequest(request))
                .expectError(CustomerBusinessException.class)
                .verify();
    }
}
