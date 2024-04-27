package com.example.service.payments.response.anonymous;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.service.payments.model.anonymous.AnonymousPublicOrderStatusModel;
import org.ntr1x.common.api.views.Views;

public interface AnonymousPublicOrderStatusResponse {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicOrderStatusResponseCreate")
    class Create {
        @JsonView(Views.Default.class)
        private AnonymousPublicOrderStatusModel created;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicOrderStatusResponseUpdate")
    class Update {
        @JsonView(Views.Default.class)
        private AnonymousPublicOrderStatusModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicOrderStatusResponseUpsert")
    class Upsert {
        @JsonView(Views.Default.class)
        private AnonymousPublicOrderStatusModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicOrderStatusResponseUpdate")
    class Remove {
        @JsonView(Views.Default.class)
        private AnonymousPublicOrderStatusModel removed;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicOrderStatusResponseReplace")
    class Replace {
        @JsonView(Views.Default.class)
        private AnonymousPublicOrderStatusModel removed;

        @JsonView(Views.Default.class)
        private AnonymousPublicOrderStatusModel created;
    }
}
