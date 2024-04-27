package com.example.service.payments.converter.system;

import lombok.RequiredArgsConstructor;

import com.example.service.payments.entity.PublicOrderTypeEntity;
import com.example.service.payments.model.system.SystemPublicOrderTypeModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface SystemPublicOrderTypeEntityConverter {
    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicOrderTypeEntity, SystemPublicOrderTypeModel> {
        private final ApplicationContext applicationContext;

        public SystemPublicOrderTypeModel convert(PublicOrderTypeEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return SystemPublicOrderTypeModel.builder()
                    .id(source.getId())
                    .name(source.getName())
                    .description(source.getDescription())
                    .build();
        }
    }
}
