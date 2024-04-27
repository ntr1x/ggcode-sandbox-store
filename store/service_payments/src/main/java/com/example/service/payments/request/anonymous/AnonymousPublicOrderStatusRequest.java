package com.example.service.payments.request.anonymous;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;

import java.util.Optional;

public interface AnonymousPublicOrderStatusRequest {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicOrderStatusRequestId")
    class Id {
        @Hidden @Builder.Default
        private String __name = "anonymous_public_order_status:id";
        
        private java.util.UUID id;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicOrderStatusRequestContext")
    class Context {
        @Hidden @Builder.Default
        private String __name = "anonymous_public_order_status:context";
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicOrderStatusRequestSelect")
    class Select {
        @Hidden @Builder.Default
        private String __name = "anonymous_public_order_status:request:select";
        
        private Optional<java.util.UUID> id;
        
        private Optional<java.lang.String> name;
        
        private Optional<java.lang.String> description;
    }
}
