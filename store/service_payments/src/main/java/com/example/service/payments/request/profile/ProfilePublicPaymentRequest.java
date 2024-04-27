package com.example.service.payments.request.profile;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;

import java.util.Optional;

public interface ProfilePublicPaymentRequest {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicPaymentRequestId")
    class Id {
        @Hidden @Builder.Default
        private String __name = "profile_public_payment:id";
        
        private java.util.UUID id;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicPaymentRequestContext")
    class Context {
        @Hidden @Builder.Default
        private String __name = "profile_public_payment:context";
        
        private java.util.UUID customerId;
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicPaymentRequestSelect")
    class Select {
        @Hidden @Builder.Default
        private String __name = "profile_public_payment:request:select";
        
        private Optional<java.util.UUID> id;
        
        private Optional<java.util.UUID> orderId;
        
        private Optional<java.util.UUID> paymentStatusId;
        
        private Optional<java.util.UUID> paymentTypeId;
        
        private Optional<java.math.BigDecimal> value;
        
        private Optional<java.time.LocalDateTime> createdAt;
        
        private Optional<java.time.LocalDateTime> updatedAt;
    }
}
