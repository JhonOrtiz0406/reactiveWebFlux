package co.com.bancolombia.api.scaffold.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class ResponseError {
    private Meta meta;
    private int code;
    private String message;
    private List<ErrorDetail> errors;
}
