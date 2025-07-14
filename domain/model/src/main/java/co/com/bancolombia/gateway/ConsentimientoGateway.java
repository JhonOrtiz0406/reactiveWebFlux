package co.com.bancolombia.gateway;

import co.com.bancolombia.model.consentimiento.Consentimiento;
import reactor.core.publisher.Flux;

public interface ConsentimientoGateway {
    Flux<Consentimiento> findAll();
}
