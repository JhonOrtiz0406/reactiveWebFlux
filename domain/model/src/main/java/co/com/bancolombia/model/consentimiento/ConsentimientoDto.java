package co.com.bancolombia.model.consentimiento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ConsentimientoDto {
    private Integer id;
    private String nombre;
    private String correo;
    private LocalDateTime fechaRegistro;
    private Map<String, Object> consentimiento;
}
