package co.com.bancolombia.usecase;


import co.com.bancolombia.exceptions.BussinesErrorMessage;
import co.com.bancolombia.exceptions.CustomerBusinessException;
import co.com.bancolombia.gateway.UserGateway;
import co.com.bancolombia.model.response.UserResponse;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import static co.com.bancolombia.exceptions.BussinesErrorMessage.ERROR_BAD_REQUEST;

@RequiredArgsConstructor
public class ReactiveWebFluxUseCase {

    public Mono<UserResponse> userGateway(String response) {
        return Mono.just(UserResponse.builder()
                        .message(response)
                        .build())
                .onErrorResume(throwable -> {
                    throw new CustomerBusinessException(ERROR_BAD_REQUEST, CustomerBusinessException.ResponseBackEnd.builder()
                            .errorMessage(throwable.getMessage())
                            .title("Error dentro del Use Case")
                            .errorCode(throwable.getCause().getMessage())
                            .errorMessage(throwable.getMessage())
                            .build());
                });
    }

}
