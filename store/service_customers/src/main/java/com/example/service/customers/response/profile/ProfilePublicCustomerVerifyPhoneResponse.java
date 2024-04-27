package com.example.service.customers.response.profile;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.service.customers.model.profile.ProfilePublicCustomerVerifyPhoneModel;
import org.ntr1x.common.api.views.Views;

public interface ProfilePublicCustomerVerifyPhoneResponse {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerVerifyPhoneResponseCreate")
    class Create {
        @JsonView(Views.Default.class)
        private ProfilePublicCustomerVerifyPhoneModel created;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerVerifyPhoneResponseUpdate")
    class Update {
        @JsonView(Views.Default.class)
        private ProfilePublicCustomerVerifyPhoneModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerVerifyPhoneResponseUpsert")
    class Upsert {
        @JsonView(Views.Default.class)
        private ProfilePublicCustomerVerifyPhoneModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerVerifyPhoneResponseUpdate")
    class Remove {
        @JsonView(Views.Default.class)
        private ProfilePublicCustomerVerifyPhoneModel removed;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerVerifyPhoneResponseReplace")
    class Replace {
        @JsonView(Views.Default.class)
        private ProfilePublicCustomerVerifyPhoneModel removed;

        @JsonView(Views.Default.class)
        private ProfilePublicCustomerVerifyPhoneModel created;
    }
}
