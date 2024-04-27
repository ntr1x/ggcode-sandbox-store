package com.example.service.payments.response.system;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.service.payments.model.system.SystemPublicOrderTypeModel;
import org.ntr1x.common.api.views.Views;

public interface SystemPublicOrderTypeResponse {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicOrderTypeResponseCreate")
    class Create {
        @JsonView(Views.Default.class)
        private SystemPublicOrderTypeModel created;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicOrderTypeResponseUpdate")
    class Update {
        @JsonView(Views.Default.class)
        private SystemPublicOrderTypeModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicOrderTypeResponseUpsert")
    class Upsert {
        @JsonView(Views.Default.class)
        private SystemPublicOrderTypeModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicOrderTypeResponseUpdate")
    class Remove {
        @JsonView(Views.Default.class)
        private SystemPublicOrderTypeModel removed;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicOrderTypeResponseReplace")
    class Replace {
        @JsonView(Views.Default.class)
        private SystemPublicOrderTypeModel removed;

        @JsonView(Views.Default.class)
        private SystemPublicOrderTypeModel created;
    }
}
