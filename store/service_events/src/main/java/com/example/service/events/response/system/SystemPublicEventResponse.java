package com.example.service.events.response.system;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.service.events.model.system.SystemPublicEventModel;
import org.ntr1x.common.api.views.Views;

public interface SystemPublicEventResponse {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicEventResponseCreate")
    class Create {
        @JsonView(Views.Default.class)
        private SystemPublicEventModel created;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicEventResponseUpdate")
    class Update {
        @JsonView(Views.Default.class)
        private SystemPublicEventModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicEventResponseUpsert")
    class Upsert {
        @JsonView(Views.Default.class)
        private SystemPublicEventModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicEventResponseUpdate")
    class Remove {
        @JsonView(Views.Default.class)
        private SystemPublicEventModel removed;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicEventResponseReplace")
    class Replace {
        @JsonView(Views.Default.class)
        private SystemPublicEventModel removed;

        @JsonView(Views.Default.class)
        private SystemPublicEventModel created;
    }
}
