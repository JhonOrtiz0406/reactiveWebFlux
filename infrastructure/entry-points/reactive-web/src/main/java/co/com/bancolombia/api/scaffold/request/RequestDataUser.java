package co.com.bancolombia.api.scaffold.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class RequestDataUser {

    @Valid
    @JsonProperty("message")
    @NotNull(message = "No se encuentra el atributo mensaje")
    private String message;
}
