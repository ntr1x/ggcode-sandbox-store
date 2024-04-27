package com.example.service.payments.converter.system;

import lombok.RequiredArgsConstructor;

import com.example.service.payments.entity.PublicPaymentStatusEntity;
import com.example.service.payments.model.system.SystemPublicPaymentStatusModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface SystemPublicPaymentStatusEntityConverter {
    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicPaymentStatusEntity, SystemPublicPaymentStatusModel> {
        private final ApplicationContext applicationContext;

        public SystemPublicPaymentStatusModel convert(PublicPaymentStatusEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return SystemPublicPaymentStatusModel.builder()
                    .id(source.getId())
                    .name(source.getName())
                    .description(source.getDescription())
                    .build();
        }
    }
}
