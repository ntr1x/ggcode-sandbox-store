package com.example.service.payments.response.system;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.service.payments.model.system.SystemPublicPaymentModel;
import org.ntr1x.common.api.views.Views;

public interface SystemPublicPaymentResponse {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicPaymentResponseCreate")
    class Create {
        @JsonView(Views.Default.class)
        private SystemPublicPaymentModel created;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicPaymentResponseUpdate")
    class Update {
        @JsonView(Views.Default.class)
        private SystemPublicPaymentModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicPaymentResponseUpsert")
    class Upsert {
        @JsonView(Views.Default.class)
        private SystemPublicPaymentModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicPaymentResponseUpdate")
    class Remove {
        @JsonView(Views.Default.class)
        private SystemPublicPaymentModel removed;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicPaymentResponseReplace")
    class Replace {
        @JsonView(Views.Default.class)
        private SystemPublicPaymentModel removed;

        @JsonView(Views.Default.class)
        private SystemPublicPaymentModel created;
    }
}
