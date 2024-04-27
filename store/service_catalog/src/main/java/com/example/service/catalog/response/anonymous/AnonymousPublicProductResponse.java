package com.example.service.catalog.response.anonymous;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.service.catalog.model.anonymous.AnonymousPublicProductModel;
import org.ntr1x.common.api.views.Views;

public interface AnonymousPublicProductResponse {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicProductResponseCreate")
    class Create {
        @JsonView(Views.Default.class)
        private AnonymousPublicProductModel created;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicProductResponseUpdate")
    class Update {
        @JsonView(Views.Default.class)
        private AnonymousPublicProductModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicProductResponseUpsert")
    class Upsert {
        @JsonView(Views.Default.class)
        private AnonymousPublicProductModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicProductResponseUpdate")
    class Remove {
        @JsonView(Views.Default.class)
        private AnonymousPublicProductModel removed;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicProductResponseReplace")
    class Replace {
        @JsonView(Views.Default.class)
        private AnonymousPublicProductModel removed;

        @JsonView(Views.Default.class)
        private AnonymousPublicProductModel created;
    }
}
