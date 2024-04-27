package com.example.service.payments.response.anonymous;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.service.payments.model.anonymous.AnonymousPublicPaymentStatusModel;
import org.ntr1x.common.api.views.Views;

public interface AnonymousPublicPaymentStatusResponse {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicPaymentStatusResponseCreate")
    class Create {
        @JsonView(Views.Default.class)
        private AnonymousPublicPaymentStatusModel created;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicPaymentStatusResponseUpdate")
    class Update {
        @JsonView(Views.Default.class)
        private AnonymousPublicPaymentStatusModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicPaymentStatusResponseUpsert")
    class Upsert {
        @JsonView(Views.Default.class)
        private AnonymousPublicPaymentStatusModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicPaymentStatusResponseUpdate")
    class Remove {
        @JsonView(Views.Default.class)
        private AnonymousPublicPaymentStatusModel removed;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicPaymentStatusResponseReplace")
    class Replace {
        @JsonView(Views.Default.class)
        private AnonymousPublicPaymentStatusModel removed;

        @JsonView(Views.Default.class)
        private AnonymousPublicPaymentStatusModel created;
    }
}
