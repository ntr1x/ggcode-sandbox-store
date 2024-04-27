package com.example.service.customers.model;

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
public class PublicCustomerVerifyEmailModel {
    
    @JsonView(Views.Default.class)
    private java.util.UUID id;
    
    @JsonView(Views.Default.class)
    private java.util.UUID customerId;
    
    @JsonView(Views.Default.class)
    private java.lang.String email;
    
    @JsonView(Views.Default.class)
    private java.lang.String secret;
    
    @JsonView(Views.Default.class)
    private java.lang.Boolean isConfirmed;
    
    @JsonView(Views.Default.class)
    private com.example.service.customers.model.PublicCustomerModel customer;
}
