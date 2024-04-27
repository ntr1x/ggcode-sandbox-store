package com.example.service.customers.request.profile;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;

import java.util.Optional;

public interface ProfilePublicCustomerVerifyPhoneRequest {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerVerifyPhoneRequestId")
    class Id {
        @Hidden @Builder.Default
        private String __name = "profile_public_customer_verify_phone:id";
        
        private java.util.UUID id;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerVerifyPhoneRequestContext")
    class Context {
        @Hidden @Builder.Default
        private String __name = "profile_public_customer_verify_phone:context";
        
        private java.util.UUID customerId;
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerVerifyPhoneRequestCreate")
    class Create {
        @Hidden @Builder.Default
        private String __name = "profile_public_customer_verify_phone:request:create";
        
        private Optional<java.lang.String> phone;
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerVerifyPhoneRequestSelect")
    class Select {
        @Hidden @Builder.Default
        private String __name = "profile_public_customer_verify_phone:request:select";
        
        private Optional<java.util.UUID> id;
        
        private Optional<java.lang.String> phone;
        
        private Optional<java.lang.Boolean> isConfirmed;
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerVerifyPhoneRequestUpdate")
    class Update {
        @Hidden @Builder.Default
        private String __name = "profile_public_customer_verify_phone:request:update";
        
        private java.util.UUID id;
        
        private Optional<java.lang.String> phone;
        
        private Optional<java.lang.Integer> secret;
        
        private Optional<java.lang.Boolean> isConfirmed;
    }
}
