package co.com.bancolombia.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReactiveWebFluxRespDto {
    private String response;
}
