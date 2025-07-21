package co.com.bancolombia.postgres;

import co.com.bancolombia.gateway.ConsentimientoGateway;
import co.com.bancolombia.model.consentimiento.Consentimiento;
import lombok.RequiredArgsConstructor;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
@RequiredArgsConstructor
public class PostgresConsentimientoRepository implements ConsentimientoGateway {

    private final DatabaseClient databaseClient;

    @Override
    public Flux<Consentimiento> findAll() {
        String query = "SELECT id, nombre, correo, fecha_registro, consentimiento FROM consentimientos";
        return databaseClient.sql(query)
                .map(row -> Consentimiento.builder()
                        .id(row.get("id", Integer.class))
                        .nombre(row.get("nombre", String.class))
                        .correo(row.get("correo", String.class))
                        .fechaRegistro(row.get("fecha_registro", java.time.LocalDateTime.class))
                        .consentimiento(row.get("consentimiento", java.util.Map.class))
                        .build())
                .all();
    }
}
