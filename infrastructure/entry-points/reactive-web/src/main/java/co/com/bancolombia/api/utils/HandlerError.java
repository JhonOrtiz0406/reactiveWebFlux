package co.com.bancolombia.api.utils;

import co.com.bancolombia.exceptions.CustomerBusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.net.http.HttpResponse;

import static co.com.bancolombia.exceptions.BusinessErrorMessage.ERROR_DEFAULT;

public class HandlerError {

    public CustomerBusinessException customerBusinessRequest(WebClientRequestException exception, HttpStatus[] httpStatus) {

        var responseBackend = CustomerBusinessException.ResponseBackEnd.builder()
                .errorMessage(exception.getMessage())
                .errorCode(String.valueOf(httpStatus.length))
//                .title( )
                .build();
        throw new CustomerBusinessException(ERROR_DEFAULT,responseBackend);
    }
}
