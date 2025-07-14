package co.com.bancolombia.api.handler;

import co.com.bancolombia.usecase.ConsentimientoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Component
public class ConsentimientoHandler {

    private final ConsentimientoUseCase useCase;

    public Mono<ServerResponse> handle(ServerRequest serverRequest) {
        return useCase.obtenerConsentimientos()
                .flatMap(set -> ServerResponse.ok().bodyValue(set))
                .next();
    }
}
