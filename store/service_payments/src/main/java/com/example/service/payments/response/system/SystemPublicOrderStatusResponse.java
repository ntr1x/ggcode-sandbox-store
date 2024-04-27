package com.example.service.payments.response.system;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.service.payments.model.system.SystemPublicOrderStatusModel;
import org.ntr1x.common.api.views.Views;

public interface SystemPublicOrderStatusResponse {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicOrderStatusResponseCreate")
    class Create {
        @JsonView(Views.Default.class)
        private SystemPublicOrderStatusModel created;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicOrderStatusResponseUpdate")
    class Update {
        @JsonView(Views.Default.class)
        private SystemPublicOrderStatusModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicOrderStatusResponseUpsert")
    class Upsert {
        @JsonView(Views.Default.class)
        private SystemPublicOrderStatusModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicOrderStatusResponseUpdate")
    class Remove {
        @JsonView(Views.Default.class)
        private SystemPublicOrderStatusModel removed;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicOrderStatusResponseReplace")
    class Replace {
        @JsonView(Views.Default.class)
        private SystemPublicOrderStatusModel removed;

        @JsonView(Views.Default.class)
        private SystemPublicOrderStatusModel created;
    }
}
