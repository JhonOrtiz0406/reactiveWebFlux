package co.com.bancolombia.api.router;

import co.com.bancolombia.api.handler.ConsentimientoHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@RequiredArgsConstructor
public class ConsentimientoRouter {

    private final ConsentimientoHandler handler;

    @Bean
    public RouterFunction<ServerResponse> consentimientoRoute() {
        return RouterFunctions.route()
                .GET("/consentimientos", handler::handle)
                .build();
    }
}
