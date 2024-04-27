package com.example.service.payments.response.system;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.service.payments.model.system.SystemPublicPaymentTypeModel;
import org.ntr1x.common.api.views.Views;

public interface SystemPublicPaymentTypeResponse {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicPaymentTypeResponseCreate")
    class Create {
        @JsonView(Views.Default.class)
        private SystemPublicPaymentTypeModel created;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicPaymentTypeResponseUpdate")
    class Update {
        @JsonView(Views.Default.class)
        private SystemPublicPaymentTypeModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicPaymentTypeResponseUpsert")
    class Upsert {
        @JsonView(Views.Default.class)
        private SystemPublicPaymentTypeModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicPaymentTypeResponseUpdate")
    class Remove {
        @JsonView(Views.Default.class)
        private SystemPublicPaymentTypeModel removed;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicPaymentTypeResponseReplace")
    class Replace {
        @JsonView(Views.Default.class)
        private SystemPublicPaymentTypeModel removed;

        @JsonView(Views.Default.class)
        private SystemPublicPaymentTypeModel created;
    }
}
