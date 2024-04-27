package com.example.service.payments.response.system;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.service.payments.model.system.SystemPublicPaymentStatusModel;
import org.ntr1x.common.api.views.Views;

public interface SystemPublicPaymentStatusResponse {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicPaymentStatusResponseCreate")
    class Create {
        @JsonView(Views.Default.class)
        private SystemPublicPaymentStatusModel created;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicPaymentStatusResponseUpdate")
    class Update {
        @JsonView(Views.Default.class)
        private SystemPublicPaymentStatusModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicPaymentStatusResponseUpsert")
    class Upsert {
        @JsonView(Views.Default.class)
        private SystemPublicPaymentStatusModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicPaymentStatusResponseUpdate")
    class Remove {
        @JsonView(Views.Default.class)
        private SystemPublicPaymentStatusModel removed;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicPaymentStatusResponseReplace")
    class Replace {
        @JsonView(Views.Default.class)
        private SystemPublicPaymentStatusModel removed;

        @JsonView(Views.Default.class)
        private SystemPublicPaymentStatusModel created;
    }
}
