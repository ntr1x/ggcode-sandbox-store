package com.example.service.catalog.response.anonymous;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.service.catalog.model.anonymous.AnonymousPublicCategoryModel;
import org.ntr1x.common.api.views.Views;

public interface AnonymousPublicCategoryResponse {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicCategoryResponseCreate")
    class Create {
        @JsonView(Views.Default.class)
        private AnonymousPublicCategoryModel created;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicCategoryResponseUpdate")
    class Update {
        @JsonView(Views.Default.class)
        private AnonymousPublicCategoryModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicCategoryResponseUpsert")
    class Upsert {
        @JsonView(Views.Default.class)
        private AnonymousPublicCategoryModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicCategoryResponseUpdate")
    class Remove {
        @JsonView(Views.Default.class)
        private AnonymousPublicCategoryModel removed;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicCategoryResponseReplace")
    class Replace {
        @JsonView(Views.Default.class)
        private AnonymousPublicCategoryModel removed;

        @JsonView(Views.Default.class)
        private AnonymousPublicCategoryModel created;
    }
}
