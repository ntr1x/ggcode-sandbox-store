package com.example.service.catalog.converter;

import lombok.RequiredArgsConstructor;

import com.example.service.catalog.entity.PublicCategoryEntity;
import com.example.service.catalog.model.PublicCategoryModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface PublicCategoryEntityConverter {

    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicCategoryEntity, PublicCategoryModel> {
        private final ApplicationContext applicationContext;

        public PublicCategoryModel convert(PublicCategoryEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return PublicCategoryModel.builder()
                    .id(source.getId())
                    .name(source.getName())
                    .description(source.getDescription())
                    .build();
        }
    }
}
