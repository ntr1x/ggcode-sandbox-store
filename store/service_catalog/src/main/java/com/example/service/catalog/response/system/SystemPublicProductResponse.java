package com.example.service.catalog.response.system;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.service.catalog.model.system.SystemPublicProductModel;
import org.ntr1x.common.api.views.Views;

public interface SystemPublicProductResponse {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicProductResponseCreate")
    class Create {
        @JsonView(Views.Default.class)
        private SystemPublicProductModel created;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicProductResponseUpdate")
    class Update {
        @JsonView(Views.Default.class)
        private SystemPublicProductModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicProductResponseUpsert")
    class Upsert {
        @JsonView(Views.Default.class)
        private SystemPublicProductModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicProductResponseUpdate")
    class Remove {
        @JsonView(Views.Default.class)
        private SystemPublicProductModel removed;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicProductResponseReplace")
    class Replace {
        @JsonView(Views.Default.class)
        private SystemPublicProductModel removed;

        @JsonView(Views.Default.class)
        private SystemPublicProductModel created;
    }
}
