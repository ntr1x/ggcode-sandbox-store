package com.example.service.catalog.converter.anonymous;

import lombok.RequiredArgsConstructor;

import com.example.service.catalog.entity.PublicCategoryEntity;
import com.example.service.catalog.model.anonymous.AnonymousPublicCategoryModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface AnonymousPublicCategoryEntityConverter {
    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicCategoryEntity, AnonymousPublicCategoryModel> {
        private final ApplicationContext applicationContext;

        public AnonymousPublicCategoryModel convert(PublicCategoryEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return AnonymousPublicCategoryModel.builder()
                    .id(source.getId())
                    .name(source.getName())
                    .description(source.getDescription())
                    .build();
        }
    }
}
