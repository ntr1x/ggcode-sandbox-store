package com.example.service.catalog.model.system;

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
public class SystemPublicProductModel {
    
    @JsonView(Views.Default.class)
    private java.util.UUID id;
    
    @JsonView(Views.Default.class)
    private java.lang.String name;
    
    @JsonView(Views.Default.class)
    private java.lang.String description;
    
    @JsonView(Views.Default.class)
    private java.math.BigDecimal price;
    
    @JsonView(Views.Default.class)
    private java.util.UUID categoryId;
    
    @JsonView(Views.Default.class)
    private com.example.service.catalog.model.PublicCategoryModel category;
}
