package com.example.service.payments.converter.system;

import lombok.RequiredArgsConstructor;

import com.example.service.payments.entity.PublicOrderStatusEntity;
import com.example.service.payments.model.system.SystemPublicOrderStatusModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface SystemPublicOrderStatusEntityConverter {
    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicOrderStatusEntity, SystemPublicOrderStatusModel> {
        private final ApplicationContext applicationContext;

        public SystemPublicOrderStatusModel convert(PublicOrderStatusEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return SystemPublicOrderStatusModel.builder()
                    .id(source.getId())
                    .name(source.getName())
                    .description(source.getDescription())
                    .build();
        }
    }
}
