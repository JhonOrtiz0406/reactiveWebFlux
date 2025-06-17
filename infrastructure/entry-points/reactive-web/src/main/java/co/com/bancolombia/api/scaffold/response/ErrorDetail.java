package co.com.bancolombia.api.scaffold.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ErrorDetail {
    private String errorCode;
    private String errorMessage;
}
