package co.com.bancolombia.api.scaffold.response;

import co.com.bancolombia.api.exceptions.BusinessException;
import co.com.bancolombia.model.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ResponseEntityBuilder {

    public Mono<ReactiveWebFluxResponse> buildResponse(Meta meta, UserResponse data) {
        var responseReactive = new ReactiveWebFluxResponse();
        var dataReactive = new Data();
        responseReactive.setMeta(meta);
        dataReactive.setResponse(data.getMessage());
        responseReactive.setData(dataReactive);
        return Mono.just(responseReactive);
    }

    public Mono<ResponseError> buildErrorResumen(Meta meta, BusinessException businessException) {
        var errorResumen = ResponseError.builder()
                .meta(meta)
                .code(businessException.statusCode())
                .message(businessException.description())
                .errors(List.of(ErrorDetail.builder()
                        .errorCode(businessException.exceptionCode())
                        .errorMessage(businessException.description())
                        .build())
                ).build();
        System.out.println("errorResumen: " + errorResumen);
        System.out.println("errorResumen First: " + errorResumen.getErrors().getFirst().getErrorMessage());
        return Mono.just(errorResumen);
    }

    public Meta buildMeta(String metaDate, String operationId) {
        return Meta.builder()
                .metaDate(metaDate)
                .operationId(operationId)
                .build();
    }

    public Data buildData(Data data) {
        return Data.builder()
                .response(data.getResponse())
                .build();
    }
}
