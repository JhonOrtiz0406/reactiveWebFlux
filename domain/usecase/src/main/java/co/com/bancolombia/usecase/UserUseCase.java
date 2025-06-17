package co.com.bancolombia.usecase;

import co.com.bancolombia.model.response.UserResponse;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class UserUseCase {

    private Mono<UserResponse> userUseCase (String messageEntrando) {
        return Mono.just(UserResponse.builder()
                        .message(messageEntrando)
                .build());
    };

}
