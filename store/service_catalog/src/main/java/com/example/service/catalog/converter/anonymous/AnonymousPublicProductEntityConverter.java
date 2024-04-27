package com.example.service.catalog.converter.anonymous;

import lombok.RequiredArgsConstructor;

import com.example.service.catalog.entity.PublicProductEntity;
import com.example.service.catalog.model.anonymous.AnonymousPublicProductModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface AnonymousPublicProductEntityConverter {
    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicProductEntity, AnonymousPublicProductModel> {
        private final ApplicationContext applicationContext;

        public AnonymousPublicProductModel convert(PublicProductEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return AnonymousPublicProductModel.builder()
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
