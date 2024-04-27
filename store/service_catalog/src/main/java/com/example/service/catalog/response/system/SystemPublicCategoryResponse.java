package com.example.service.catalog.response.system;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.service.catalog.model.system.SystemPublicCategoryModel;
import org.ntr1x.common.api.views.Views;

public interface SystemPublicCategoryResponse {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicCategoryResponseCreate")
    class Create {
        @JsonView(Views.Default.class)
        private SystemPublicCategoryModel created;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicCategoryResponseUpdate")
    class Update {
        @JsonView(Views.Default.class)
        private SystemPublicCategoryModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicCategoryResponseUpsert")
    class Upsert {
        @JsonView(Views.Default.class)
        private SystemPublicCategoryModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicCategoryResponseUpdate")
    class Remove {
        @JsonView(Views.Default.class)
        private SystemPublicCategoryModel removed;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicCategoryResponseReplace")
    class Replace {
        @JsonView(Views.Default.class)
        private SystemPublicCategoryModel removed;

        @JsonView(Views.Default.class)
        private SystemPublicCategoryModel created;
    }
}
