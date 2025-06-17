package co.com.bancolombia.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapper {

    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
