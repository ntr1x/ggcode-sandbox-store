package com.example.service.customers.model.profile;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ntr1x.common.api.views.Views;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProfilePublicCustomerVerifyEmailModel {
    
    @JsonView(Views.Default.class)
    private java.util.UUID id;
    
    @JsonView(Views.Default.class)
    private java.lang.String email;
    
    @JsonView({ Views.Kafka.class, Views.Update.class })
    private java.lang.String secret;
    
    @JsonView({ Views.Kafka.class })
    private java.lang.Boolean isConfirmed;
    
    @JsonView(Views.Default.class)
    private com.example.service.customers.model.PublicCustomerModel customer;
}
