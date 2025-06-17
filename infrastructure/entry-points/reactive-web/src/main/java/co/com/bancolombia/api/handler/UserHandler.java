package co.com.bancolombia.api.handler;

import co.com.bancolombia.api.exceptions.BusinessException;
import co.com.bancolombia.api.scaffold.request.UserRequest;
import co.com.bancolombia.api.scaffold.response.Meta;
import co.com.bancolombia.api.scaffold.response.ReactiveWebFluxResponse;
import co.com.bancolombia.api.scaffold.response.ResponseEntityBuilder;
import co.com.bancolombia.api.utils.ValidateRequest;
import co.com.bancolombia.exceptions.CustomerBusinessException;
import co.com.bancolombia.usecase.ReactiveWebFluxUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@RequiredArgsConstructor
@Component
public class UserHandler {

    private final ReactiveWebFluxUseCase reactiveWebFluxUseCase;
    private final ValidateRequest validateRequest;
    private final ResponseEntityBuilder responseEntityBuilder;

    public Mono<ServerResponse> handle(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(UserRequest.class)
                .flatMap(validateRequest::validateRequest)
                .flatMap(req -> reactiveWebFluxUseCase.userGateway(req.getData().getMessage()))
                .flatMap(userResponse -> {
                    Meta meta = responseEntityBuilder.buildMeta(LocalDate.now().toString(), "user-operation");
                    return responseEntityBuilder.buildResponse(meta, userResponse);
                })
                .flatMap(resp -> ServerResponse.ok().bodyValue(resp))
                .onErrorResume(CustomerBusinessException.class, ex -> {
                    Meta meta = responseEntityBuilder.buildMeta(LocalDate.now().toString(), "user-operation");
                    BusinessException businessException = BusinessException.builder()
                            .exceptionCode(ex.getBusinessErrorMessage().getErrorCode())
                            .description(ex.getBusinessErrorMessage().getErrorMessage())
                            .statusCode(Integer.parseInt(ex.getBusinessErrorMessage().getStatus()))
                            .title(ex.getBusinessErrorMessage().getTitle())
                            .build();
                    return responseEntityBuilder.buildErrorResumen(meta, businessException)
                            .flatMap(error -> ServerResponse.status(businessException.statusCode()).bodyValue(error));
                });
    }
}
