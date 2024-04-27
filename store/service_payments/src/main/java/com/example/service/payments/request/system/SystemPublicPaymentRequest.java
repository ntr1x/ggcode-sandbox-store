package com.example.service.payments.request.system;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;

import java.util.Optional;

public interface SystemPublicPaymentRequest {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicPaymentRequestId")
    class Id {
        @Hidden @Builder.Default
        private String __name = "system_public_payment:id";
        
        private java.util.UUID id;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicPaymentRequestContext")
    class Context {
        @Hidden @Builder.Default
        private String __name = "system_public_payment:context";
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicPaymentRequestCreate")
    class Create {
        @Hidden @Builder.Default
        private String __name = "system_public_payment:request:create";
        
        private Optional<java.util.UUID> customerId;
        
        private Optional<java.util.UUID> orderId;
        
        private Optional<java.util.UUID> paymentStatusId;
        
        private Optional<java.util.UUID> paymentTypeId;
        
        private Optional<java.math.BigDecimal> value;
        
        private Optional<java.time.LocalDateTime> createdAt;
        
        private Optional<java.time.LocalDateTime> updatedAt;
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicPaymentRequestPut")
    class Replace {
        @Hidden @Builder.Default
        private String __name = "system_public_payment:request:replace";
        
        private Optional<java.util.UUID> id;
        
        private Optional<java.util.UUID> customerId;
        
        private Optional<java.util.UUID> orderId;
        
        private Optional<java.util.UUID> paymentStatusId;
        
        private Optional<java.util.UUID> paymentTypeId;
        
        private Optional<java.math.BigDecimal> value;
        
        private Optional<java.time.LocalDateTime> createdAt;
        
        private Optional<java.time.LocalDateTime> updatedAt;
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicPaymentRequestSelect")
    class Select {
        @Hidden @Builder.Default
        private String __name = "system_public_payment:request:select";
        
        private Optional<java.util.UUID> id;
        
        private Optional<java.util.UUID> customerId;
        
        private Optional<java.util.UUID> orderId;
        
        private Optional<java.util.UUID> paymentStatusId;
        
        private Optional<java.util.UUID> paymentTypeId;
        
        private Optional<java.math.BigDecimal> value;
        
        private Optional<java.time.LocalDateTime> createdAt;
        
        private Optional<java.time.LocalDateTime> updatedAt;
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicPaymentRequestUpdate")
    class Update {
        @Hidden @Builder.Default
        private String __name = "system_public_payment:request:update";
        
        private java.util.UUID id;
        
        private Optional<java.util.UUID> customerId;
        
        private Optional<java.util.UUID> orderId;
        
        private Optional<java.util.UUID> paymentStatusId;
        
        private Optional<java.util.UUID> paymentTypeId;
        
        private Optional<java.math.BigDecimal> value;
        
        private Optional<java.time.LocalDateTime> createdAt;
        
        private Optional<java.time.LocalDateTime> updatedAt;
    }
}
