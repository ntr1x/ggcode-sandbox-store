package com.example.service.customers.request.system;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;

import java.util.Optional;

public interface SystemPublicCustomerRequest {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicCustomerRequestId")
    class Id {
        @Hidden @Builder.Default
        private String __name = "system_public_customer:id";
        
        private java.util.UUID id;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicCustomerRequestContext")
    class Context {
        @Hidden @Builder.Default
        private String __name = "system_public_customer:context";
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicCustomerRequestCreate")
    class Create {
        @Hidden @Builder.Default
        private String __name = "system_public_customer:request:create";
        
        private Optional<java.lang.String> email;
        
        private Optional<java.lang.String> phone;
        
        private Optional<java.lang.String> name;
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicCustomerRequestPut")
    class Replace {
        @Hidden @Builder.Default
        private String __name = "system_public_customer:request:replace";
        
        private Optional<java.util.UUID> id;
        
        private Optional<java.lang.String> email;
        
        private Optional<java.lang.String> phone;
        
        private Optional<java.lang.String> name;
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicCustomerRequestSelect")
    class Select {
        @Hidden @Builder.Default
        private String __name = "system_public_customer:request:select";
        
        private Optional<java.util.UUID> id;
        
        private Optional<java.lang.String> email;
        
        private Optional<java.lang.String> phone;
        
        private Optional<java.lang.String> name;
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicCustomerRequestUpdate")
    class Update {
        @Hidden @Builder.Default
        private String __name = "system_public_customer:request:update";
        
        private java.util.UUID id;
        
        private Optional<java.lang.String> email;
        
        private Optional<java.lang.String> phone;
        
        private Optional<java.lang.String> name;
    }
}
