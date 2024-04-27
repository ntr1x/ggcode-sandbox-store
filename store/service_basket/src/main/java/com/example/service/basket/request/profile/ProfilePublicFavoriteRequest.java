package com.example.service.basket.request.profile;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;

import java.util.Optional;

public interface ProfilePublicFavoriteRequest {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicFavoriteRequestId")
    class Id {
        @Hidden @Builder.Default
        private String __name = "profile_public_favorite:id";
        
        private java.util.UUID id;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicFavoriteRequestContext")
    class Context {
        @Hidden @Builder.Default
        private String __name = "profile_public_favorite:context";
        
        private java.util.UUID customerId;
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicFavoriteRequestCreate")
    class Create {
        @Hidden @Builder.Default
        private String __name = "profile_public_favorite:request:create";
        
        private Optional<java.util.UUID> productId;
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicFavoriteRequestPut")
    class Replace {
        @Hidden @Builder.Default
        private String __name = "profile_public_favorite:request:replace";
        
        private Optional<java.util.UUID> id;
        
        private Optional<java.util.UUID> productId;
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicFavoriteRequestSelect")
    class Select {
        @Hidden @Builder.Default
        private String __name = "profile_public_favorite:request:select";
        
        private Optional<java.util.UUID> id;
        
        private Optional<java.util.UUID> productId;
    }
    
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicFavoriteRequestUpdate")
    class Update {
        @Hidden @Builder.Default
        private String __name = "profile_public_favorite:request:update";
        
        private java.util.UUID id;
        
        private Optional<java.util.UUID> productId;
    }
}
