package com.example.service.customers.response.profile;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.service.customers.model.profile.ProfilePublicCustomerVerifyEmailModel;
import org.ntr1x.common.api.views.Views;

public interface ProfilePublicCustomerVerifyEmailResponse {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerVerifyEmailResponseCreate")
    class Create {
        @JsonView(Views.Default.class)
        private ProfilePublicCustomerVerifyEmailModel created;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerVerifyEmailResponseUpdate")
    class Update {
        @JsonView(Views.Default.class)
        private ProfilePublicCustomerVerifyEmailModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerVerifyEmailResponseUpsert")
    class Upsert {
        @JsonView(Views.Default.class)
        private ProfilePublicCustomerVerifyEmailModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerVerifyEmailResponseUpdate")
    class Remove {
        @JsonView(Views.Default.class)
        private ProfilePublicCustomerVerifyEmailModel removed;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "ProfilePublicCustomerVerifyEmailResponseReplace")
    class Replace {
        @JsonView(Views.Default.class)
        private ProfilePublicCustomerVerifyEmailModel removed;

        @JsonView(Views.Default.class)
        private ProfilePublicCustomerVerifyEmailModel created;
    }
}
