package co.com.bancolombia.api.utils;

import java.util.UUID;

public class SequenceUuid {

    private final String uuid = UUID.randomUUID().toString();

    public String SequenceUuid() {
        return this.uuid;
    }
}
