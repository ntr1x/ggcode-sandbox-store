package com.example.service.payments.converter.system;

import lombok.RequiredArgsConstructor;

import com.example.service.payments.entity.PublicPaymentTypeEntity;
import com.example.service.payments.model.system.SystemPublicPaymentTypeModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface SystemPublicPaymentTypeEntityConverter {
    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicPaymentTypeEntity, SystemPublicPaymentTypeModel> {
        private final ApplicationContext applicationContext;

        public SystemPublicPaymentTypeModel convert(PublicPaymentTypeEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return SystemPublicPaymentTypeModel.builder()
                    .id(source.getId())
                    .name(source.getName())
                    .description(source.getDescription())
                    .build();
        }
    }
}
