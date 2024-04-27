package com.example.service.payments.request.anonymous;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;

import java.util.Optional;

public interface AnonymousPublicPaymentTypeRequest {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicPaymentTypeRequestId")
    class Id {
        @Hidden @Builder.Default
        private String __name = "anonymous_public_payment_type:id";
        
        private java.util.UUID id;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicPaymentTypeRequestContext")
    class Context {
        @Hidden @Builder.Default
        private String __name = "anonymous_public_payment_type:context";
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicPaymentTypeRequestSelect")
    class Select {
        @Hidden @Builder.Default
        private String __name = "anonymous_public_payment_type:request:select";
        
        private Optional<java.util.UUID> id;
        
        private Optional<java.lang.String> name;
        
        private Optional<java.lang.String> description;
    }
}
