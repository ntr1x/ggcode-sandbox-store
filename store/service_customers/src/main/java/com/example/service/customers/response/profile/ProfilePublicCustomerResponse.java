package com.example.service.customers.response.profile;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.service.customers.model.profile.ProfilePublicCustomerModel;
import org.ntr1x.common.api.views.Views;

public interface ProfilePublicCustomerResponse {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerResponseCreate")
    class Create {
        @JsonView(Views.Default.class)
        private ProfilePublicCustomerModel created;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerResponseUpdate")
    class Update {
        @JsonView(Views.Default.class)
        private ProfilePublicCustomerModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerResponseUpsert")
    class Upsert {
        @JsonView(Views.Default.class)
        private ProfilePublicCustomerModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerResponseUpdate")
    class Remove {
        @JsonView(Views.Default.class)
        private ProfilePublicCustomerModel removed;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerResponseReplace")
    class Replace {
        @JsonView(Views.Default.class)
        private ProfilePublicCustomerModel removed;

        @JsonView(Views.Default.class)
        private ProfilePublicCustomerModel created;
    }
}
