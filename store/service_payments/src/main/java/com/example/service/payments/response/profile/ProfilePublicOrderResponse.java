package com.example.service.payments.response.profile;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.service.payments.model.profile.ProfilePublicOrderModel;
import org.ntr1x.common.api.views.Views;

public interface ProfilePublicOrderResponse {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicOrderResponseCreate")
    class Create {
        @JsonView(Views.Default.class)
        private ProfilePublicOrderModel created;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicOrderResponseUpdate")
    class Update {
        @JsonView(Views.Default.class)
        private ProfilePublicOrderModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicOrderResponseUpsert")
    class Upsert {
        @JsonView(Views.Default.class)
        private ProfilePublicOrderModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicOrderResponseUpdate")
    class Remove {
        @JsonView(Views.Default.class)
        private ProfilePublicOrderModel removed;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicOrderResponseReplace")
    class Replace {
        @JsonView(Views.Default.class)
        private ProfilePublicOrderModel removed;

        @JsonView(Views.Default.class)
        private ProfilePublicOrderModel created;
    }
}
