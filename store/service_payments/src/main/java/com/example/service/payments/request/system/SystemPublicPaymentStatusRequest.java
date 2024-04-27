package com.example.service.payments.request.system;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;

import java.util.Optional;

public interface SystemPublicPaymentStatusRequest {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicPaymentStatusRequestId")
    class Id {
        @Hidden @Builder.Default
        private String __name = "system_public_payment_status:id";
        
        private java.util.UUID id;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicPaymentStatusRequestContext")
    class Context {
        @Hidden @Builder.Default
        private String __name = "system_public_payment_status:context";
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicPaymentStatusRequestCreate")
    class Create {
        @Hidden @Builder.Default
        private String __name = "system_public_payment_status:request:create";
        
        private Optional<java.lang.String> name;
        
        private Optional<java.lang.String> description;
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicPaymentStatusRequestPut")
    class Replace {
        @Hidden @Builder.Default
        private String __name = "system_public_payment_status:request:replace";
        
        private Optional<java.util.UUID> id;
        
        private Optional<java.lang.String> name;
        
        private Optional<java.lang.String> description;
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicPaymentStatusRequestSelect")
    class Select {
        @Hidden @Builder.Default
        private String __name = "system_public_payment_status:request:select";
        
        private Optional<java.util.UUID> id;
        
        private Optional<java.lang.String> name;
        
        private Optional<java.lang.String> description;
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicPaymentStatusRequestUpdate")
    class Update {
        @Hidden @Builder.Default
        private String __name = "system_public_payment_status:request:update";
        
        private java.util.UUID id;
        
        private Optional<java.lang.String> name;
        
        private Optional<java.lang.String> description;
    }
}
