package com.example.service.customers.response.system;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.example.service.customers.model.system.SystemPublicCustomerModel;
import org.ntr1x.common.api.views.Views;

public interface SystemPublicCustomerResponse {
    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicCustomerResponseCreate")
    class Create {
        @JsonView(Views.Default.class)
        private SystemPublicCustomerModel created;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicCustomerResponseUpdate")
    class Update {
        @JsonView(Views.Default.class)
        private SystemPublicCustomerModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicCustomerResponseUpsert")
    class Upsert {
        @JsonView(Views.Default.class)
        private SystemPublicCustomerModel updated;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicCustomerResponseUpdate")
    class Remove {
        @JsonView(Views.Default.class)
        private SystemPublicCustomerModel removed;
    }

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @Schema(name = "SystemPublicCustomerResponseReplace")
    class Replace {
        @JsonView(Views.Default.class)
        private SystemPublicCustomerModel removed;

        @JsonView(Views.Default.class)
        private SystemPublicCustomerModel created;
    }
}
