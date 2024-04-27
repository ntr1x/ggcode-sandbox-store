package com.example.service.catalog.converter.system;

import lombok.RequiredArgsConstructor;

import com.example.service.catalog.entity.PublicProductEntity;
import com.example.service.catalog.model.system.SystemPublicProductModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface SystemPublicProductEntityConverter {
    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicProductEntity, SystemPublicProductModel> {
        private final ApplicationContext applicationContext;

        public SystemPublicProductModel convert(PublicProductEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return SystemPublicProductModel.builder()
                    .id(source.getId())
                    .name(source.getName())
                    .description(source.getDescription())
                    .price(source.getPrice())
                    .categoryId(source.getCategoryId())
                    .category(conversionService.convert(
                            source.getCategory(),
                            com.example.service.catalog.model.PublicCategoryModel.class))
                    .build();
        }
    }
}
