package com.example.service.payments.response.anonymous;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.service.payments.model.anonymous.AnonymousPublicPaymentTypeModel;
import org.ntr1x.common.api.views.Views;

public interface AnonymousPublicPaymentTypeResponse {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicPaymentTypeResponseCreate")
    class Create {
        @JsonView(Views.Default.class)
        private AnonymousPublicPaymentTypeModel created;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicPaymentTypeResponseUpdate")
    class Update {
        @JsonView(Views.Default.class)
        private AnonymousPublicPaymentTypeModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicPaymentTypeResponseUpsert")
    class Upsert {
        @JsonView(Views.Default.class)
        private AnonymousPublicPaymentTypeModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicPaymentTypeResponseUpdate")
    class Remove {
        @JsonView(Views.Default.class)
        private AnonymousPublicPaymentTypeModel removed;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicPaymentTypeResponseReplace")
    class Replace {
        @JsonView(Views.Default.class)
        private AnonymousPublicPaymentTypeModel removed;

        @JsonView(Views.Default.class)
        private AnonymousPublicPaymentTypeModel created;
    }
}
