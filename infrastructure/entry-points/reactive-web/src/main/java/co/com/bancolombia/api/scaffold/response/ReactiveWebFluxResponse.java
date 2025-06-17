package co.com.bancolombia.api.scaffold.response;

import lombok.*;

@lombok.Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReactiveWebFluxResponse {
    private Meta meta;
    private Data data;
}
