package com.example.service.customers.request.profile;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;

import java.util.Optional;

public interface ProfilePublicCustomerVerifyEmailRequest {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerVerifyEmailRequestId")
    class Id {
        @Hidden @Builder.Default
        private String __name = "profile_public_customer_verify_email:id";
        
        private java.util.UUID id;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerVerifyEmailRequestContext")
    class Context {
        @Hidden @Builder.Default
        private String __name = "profile_public_customer_verify_email:context";
        
        private java.util.UUID customerId;
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerVerifyEmailRequestCreate")
    class Create {
        @Hidden @Builder.Default
        private String __name = "profile_public_customer_verify_email:request:create";
        
        private Optional<java.lang.String> email;
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerVerifyEmailRequestSelect")
    class Select {
        @Hidden @Builder.Default
        private String __name = "profile_public_customer_verify_email:request:select";
        
        private Optional<java.util.UUID> id;
        
        private Optional<java.lang.String> email;
        
        private Optional<java.lang.Boolean> isConfirmed;
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerVerifyEmailRequestUpdate")
    class Update {
        @Hidden @Builder.Default
        private String __name = "profile_public_customer_verify_email:request:update";
        
        private java.util.UUID id;
        
        private Optional<java.lang.String> email;
        
        private Optional<java.lang.String> secret;
        
        private Optional<java.lang.Boolean> isConfirmed;
    }
}
