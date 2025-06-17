package co.com.bancolombia.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public enum BusinessErrorMessage {

    ERROR_BAD_REQUEST("400", "Error en la peticion", "BP400", "Sucedio un error inesperado en la peticion"),
    ERROR_MAPPING_VALIDATE_REQUEST("499", "Error en la peticion", "BP499", "Sucedio un error inesperado en la peticion - 499")


    ;

    private final String status;
    private final String title;
    private final String errorCode;
    private final String errorMessage;

    private static final Map<String, BusinessErrorMessage> mapEnum = new HashMap<>();
    static {
        for (BusinessErrorMessage status : BusinessErrorMessage.values()) {
            mapEnum.put(status.status, status);
            System.out.println("Echo - ErrorCode: " + status.status + " - Title - " + status.title);
        }
    }

    public static BusinessErrorMessage getEnumStatusCode(String status) {
        return mapEnum.get(status);
    }

}
