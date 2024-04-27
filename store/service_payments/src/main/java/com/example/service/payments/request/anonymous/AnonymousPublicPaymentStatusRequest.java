package com.example.service.payments.request.anonymous;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;

import java.util.Optional;

public interface AnonymousPublicPaymentStatusRequest {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicPaymentStatusRequestId")
    class Id {
        @Hidden @Builder.Default
        private String __name = "anonymous_public_payment_status:id";
        
        private java.util.UUID id;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicPaymentStatusRequestContext")
    class Context {
        @Hidden @Builder.Default
        private String __name = "anonymous_public_payment_status:context";
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicPaymentStatusRequestSelect")
    class Select {
        @Hidden @Builder.Default
        private String __name = "anonymous_public_payment_status:request:select";
        
        private Optional<java.util.UUID> id;
        
        private Optional<java.lang.String> name;
        
        private Optional<java.lang.String> description;
    }
}
