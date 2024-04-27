package com.example.service.payments.model;

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
public class PublicOrderEntryModel {
    
    @JsonView(Views.Default.class)
    private java.util.UUID id;
    
    @JsonView(Views.Default.class)
    private java.util.UUID productId;
    
    @JsonView(Views.Default.class)
    private java.util.UUID orderId;
    
    @JsonView(Views.Default.class)
    private java.lang.Integer quantity;
    
    @JsonView(Views.Default.class)
    private com.example.service.payments.model.PublicOrderModel order;
    
    @JsonView(Views.Default.class)
    private com.example.service.payments.model.PublicProductModel product;
}
