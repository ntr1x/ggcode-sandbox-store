package com.example.service.payments.converter;

import lombok.RequiredArgsConstructor;

import com.example.service.payments.entity.PublicPaymentStatusEntity;
import com.example.service.payments.model.PublicPaymentStatusModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface PublicPaymentStatusEntityConverter {

    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicPaymentStatusEntity, PublicPaymentStatusModel> {
        private final ApplicationContext applicationContext;

        public PublicPaymentStatusModel convert(PublicPaymentStatusEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return PublicPaymentStatusModel.builder()
                    .id(source.getId())
                    .name(source.getName())
                    .description(source.getDescription())
                    .build();
        }
    }
}
