package com.example.service.catalog.converter;

import lombok.RequiredArgsConstructor;

import com.example.service.catalog.entity.PublicProductEntity;
import com.example.service.catalog.model.PublicProductModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface PublicProductEntityConverter {

    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicProductEntity, PublicProductModel> {
        private final ApplicationContext applicationContext;

        public PublicProductModel convert(PublicProductEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return PublicProductModel.builder()
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
