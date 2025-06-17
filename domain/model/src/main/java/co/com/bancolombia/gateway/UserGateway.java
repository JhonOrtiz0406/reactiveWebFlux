package co.com.bancolombia.gateway;

import co.com.bancolombia.model.response.UserResponse;
import reactor.core.publisher.Mono;

public interface UserGateway {
    Mono<UserResponse> userGateway(String message);
}
