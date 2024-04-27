package com.example.service.catalog.converter.system;

import lombok.RequiredArgsConstructor;

import com.example.service.catalog.entity.PublicCategoryEntity;
import com.example.service.catalog.model.system.SystemPublicCategoryModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface SystemPublicCategoryEntityConverter {
    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicCategoryEntity, SystemPublicCategoryModel> {
        private final ApplicationContext applicationContext;

        public SystemPublicCategoryModel convert(PublicCategoryEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return SystemPublicCategoryModel.builder()
                    .id(source.getId())
                    .name(source.getName())
                    .description(source.getDescription())
                    .build();
        }
    }
}
