package com.example.service.catalog.request.system;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;

import java.util.Optional;

public interface SystemPublicProductRequest {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicProductRequestId")
    class Id {
        @Hidden @Builder.Default
        private String __name = "system_public_product:id";
        
        private java.util.UUID id;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicProductRequestContext")
    class Context {
        @Hidden @Builder.Default
        private String __name = "system_public_product:context";
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicProductRequestCreate")
    class Create {
        @Hidden @Builder.Default
        private String __name = "system_public_product:request:create";
        
        private Optional<java.lang.String> name;
        
        private Optional<java.lang.String> description;
        
        private Optional<java.math.BigDecimal> price;
        
        private Optional<java.util.UUID> categoryId;
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicProductRequestPut")
    class Replace {
        @Hidden @Builder.Default
        private String __name = "system_public_product:request:replace";
        
        private Optional<java.util.UUID> id;
        
        private Optional<java.lang.String> name;
        
        private Optional<java.lang.String> description;
        
        private Optional<java.math.BigDecimal> price;
        
        private Optional<java.util.UUID> categoryId;
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicProductRequestSelect")
    class Select {
        @Hidden @Builder.Default
        private String __name = "system_public_product:request:select";
        
        private Optional<java.util.UUID> id;
        
        private Optional<java.lang.String> name;
        
        private Optional<java.lang.String> description;
        
        private Optional<java.math.BigDecimal> price;
        
        private Optional<java.util.UUID> categoryId;
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicProductRequestUpdate")
    class Update {
        @Hidden @Builder.Default
        private String __name = "system_public_product:request:update";
        
        private java.util.UUID id;
        
        private Optional<java.lang.String> name;
        
        private Optional<java.lang.String> description;
        
        private Optional<java.math.BigDecimal> price;
        
        private Optional<java.util.UUID> categoryId;
    }
}
