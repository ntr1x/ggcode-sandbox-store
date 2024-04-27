package com.example.service.catalog.request.anonymous;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;

import java.util.Optional;

public interface AnonymousPublicProductRequest {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicProductRequestId")
    class Id {
        @Hidden @Builder.Default
        private String __name = "anonymous_public_product:id";
        
        private java.util.UUID id;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicProductRequestContext")
    class Context {
        @Hidden @Builder.Default
        private String __name = "anonymous_public_product:context";
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicProductRequestSelect")
    class Select {
        @Hidden @Builder.Default
        private String __name = "anonymous_public_product:request:select";
        
        private Optional<java.util.UUID> id;
        
        private Optional<java.lang.String> name;
        
        private Optional<java.lang.String> description;
        
        private Optional<java.math.BigDecimal> price;
        
        private Optional<java.util.UUID> categoryId;
    }
}
