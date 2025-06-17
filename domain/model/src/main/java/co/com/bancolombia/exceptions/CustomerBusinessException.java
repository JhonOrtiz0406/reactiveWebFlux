package co.com.bancolombia.exceptions;

import lombok.*;

import co.com.bancolombia.exceptions.BusinessErrorMessage;

import java.io.Serializable;

@Getter
public class CustomerBusinessException extends RuntimeException {
    private final BusinessErrorMessage businessErrorMessage;
    private final ResponseBackEnd responseBackEnd;

    public CustomerBusinessException(BusinessErrorMessage businessErrorMessage, ResponseBackEnd responseBackEnd) {
        super(businessErrorMessage.getErrorMessage());
        this.businessErrorMessage = businessErrorMessage;
        this.responseBackEnd = responseBackEnd;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder(toBuilder = true)
    public static class ResponseBackEnd implements Serializable {
        private String errorCode;
        private String errorMessage;
        private String title;
    }
}
