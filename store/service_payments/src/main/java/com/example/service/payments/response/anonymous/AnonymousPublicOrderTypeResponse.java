package com.example.service.payments.response.anonymous;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.service.payments.model.anonymous.AnonymousPublicOrderTypeModel;
import org.ntr1x.common.api.views.Views;

public interface AnonymousPublicOrderTypeResponse {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicOrderTypeResponseCreate")
    class Create {
        @JsonView(Views.Default.class)
        private AnonymousPublicOrderTypeModel created;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicOrderTypeResponseUpdate")
    class Update {
        @JsonView(Views.Default.class)
        private AnonymousPublicOrderTypeModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicOrderTypeResponseUpsert")
    class Upsert {
        @JsonView(Views.Default.class)
        private AnonymousPublicOrderTypeModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicOrderTypeResponseUpdate")
    class Remove {
        @JsonView(Views.Default.class)
        private AnonymousPublicOrderTypeModel removed;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "AnonymousPublicOrderTypeResponseReplace")
    class Replace {
        @JsonView(Views.Default.class)
        private AnonymousPublicOrderTypeModel removed;

        @JsonView(Views.Default.class)
        private AnonymousPublicOrderTypeModel created;
    }
}
