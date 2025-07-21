package co.com.bancolombia.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum BusinessErrorMessage {

    ERROR_BAD_REQUEST("400", "Error en la peticion", "BP400", "Sucedio un error inesperado en la peticion"),
    ERROR_MAPPING_VALIDATE_REQUEST("428", "Precondition Required", "BP428", "Sucedio un error inesperado en la peticion - 499"),
    ERROR_DEFAULT("404","Error de parametros", "BP404", "Sucedio un error inesperado"),

    ;

    private final String status;
    private final String title;
    private final String errorCode;
    private final String errorMessage;

    private static final Map<String, BusinessErrorMessage> mapEnum = new HashMap<>();
    static {
        for (BusinessErrorMessage status : BusinessErrorMessage.values()) {
            mapEnum.put(status.status, status);
        }
    }

    public static BusinessErrorMessage getEnumStatusCode(String status) {
        return mapEnum.get(status);
    }

    private static final Map<String, BusinessErrorMessage> mapByErrorCode = new HashMap<>();
    static {
        for (BusinessErrorMessage error : values()) {
            mapByErrorCode.put(error.errorCode, error);
        }
    }

    public static BusinessErrorMessage getEnumErrorCode(String code) {
        return mapByErrorCode.get(code);
    }

}
