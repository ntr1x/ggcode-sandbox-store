package com.example.service.basket.response.profile;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.service.basket.model.profile.ProfilePublicBasketEntryModel;
import org.ntr1x.common.api.views.Views;

public interface ProfilePublicBasketEntryResponse {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicBasketEntryResponseCreate")
    class Create {
        @JsonView(Views.Default.class)
        private ProfilePublicBasketEntryModel created;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicBasketEntryResponseUpdate")
    class Update {
        @JsonView(Views.Default.class)
        private ProfilePublicBasketEntryModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicBasketEntryResponseUpsert")
    class Upsert {
        @JsonView(Views.Default.class)
        private ProfilePublicBasketEntryModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicBasketEntryResponseUpdate")
    class Remove {
        @JsonView(Views.Default.class)
        private ProfilePublicBasketEntryModel removed;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicBasketEntryResponseReplace")
    class Replace {
        @JsonView(Views.Default.class)
        private ProfilePublicBasketEntryModel removed;

        @JsonView(Views.Default.class)
        private ProfilePublicBasketEntryModel created;
    }
}
