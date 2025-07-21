package co.com.bancolombia.usecase;

import co.com.bancolombia.gateway.ConsentimientoGateway;
import co.com.bancolombia.model.consentimiento.ConsentimientoDto;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ConsentimientoUseCase {

    private final ConsentimientoGateway gateway;

    public Flux<Set<ConsentimientoDto>> obtenerConsentimientos() {
        Instant start = Instant.now();
        return gateway.findAll()
                .map(cons -> ConsentimientoDto.builder()
                        .id(cons.getId())
                        .nombre(cons.getNombre())
                        .correo(cons.getCorreo())
                        .fechaRegistro(cons.getFechaRegistro())
                        .consentimiento(cons.getConsentimiento())
                        .build())
                .collect(Collectors.toSet())
                .flux()
                .doOnNext(set -> {
                    long ms = Duration.between(start, Instant.now()).toMillis();
                    System.out.println("Tiempo consulta consentimientos: " + ms + "ms");
                });
    }
}
