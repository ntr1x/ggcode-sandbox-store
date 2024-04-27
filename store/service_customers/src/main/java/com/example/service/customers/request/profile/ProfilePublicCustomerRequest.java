package com.example.service.customers.request.profile;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;

import java.util.Optional;

public interface ProfilePublicCustomerRequest {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerRequestId")
    class Id {
        @Hidden @Builder.Default
        private String __name = "profile_public_customer:id";
        
        private java.util.UUID id;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerRequestContext")
    class Context {
        @Hidden @Builder.Default
        private String __name = "profile_public_customer:context";
        
        private java.util.UUID customerId;
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerRequestUpsert")
    class Upsert {
        @Hidden @Builder.Default
        private String __name = "profile_public_customer:request:upsert";
        
        private Optional<java.lang.String> name;
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerRequestFind")
    class Find {
        @Hidden @Builder.Default
        private String __name = "profile_public_customer:request:find";
    }
}
