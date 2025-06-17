package co.com.bancolombia.api.exceptions;

import lombok.Builder;

@Builder
public record BusinessException (String exceptionCode,
                                String description,
                                int statusCode,
                                String title) {
}
