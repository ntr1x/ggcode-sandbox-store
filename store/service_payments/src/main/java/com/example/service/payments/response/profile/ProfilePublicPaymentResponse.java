package com.example.service.payments.response.profile;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.service.payments.model.profile.ProfilePublicPaymentModel;
import org.ntr1x.common.api.views.Views;

public interface ProfilePublicPaymentResponse {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicPaymentResponseCreate")
    class Create {
        @JsonView(Views.Default.class)
        private ProfilePublicPaymentModel created;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicPaymentResponseUpdate")
    class Update {
        @JsonView(Views.Default.class)
        private ProfilePublicPaymentModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicPaymentResponseUpsert")
    class Upsert {
        @JsonView(Views.Default.class)
        private ProfilePublicPaymentModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicPaymentResponseUpdate")
    class Remove {
        @JsonView(Views.Default.class)
        private ProfilePublicPaymentModel removed;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicPaymentResponseReplace")
    class Replace {
        @JsonView(Views.Default.class)
        private ProfilePublicPaymentModel removed;

        @JsonView(Views.Default.class)
        private ProfilePublicPaymentModel created;
    }
}
