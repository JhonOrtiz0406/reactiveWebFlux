package co.com.bancolombia.exceptions;

import lombok.*;

import java.io.Serializable;

@Getter
public class CustomerBusinessException extends RuntimeException {
    private final BussinesErrorMessage bussinesErrorMessage;
    private final ResponseBackEnd responseBackEnd;

    public CustomerBusinessException(BussinesErrorMessage bussinesErrorMessage, ResponseBackEnd responseBackEnd) {
        super(bussinesErrorMessage.getErrorMessage());
        this.bussinesErrorMessage = bussinesErrorMessage;
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
