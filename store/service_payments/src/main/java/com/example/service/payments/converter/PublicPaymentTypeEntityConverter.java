package com.example.service.payments.converter;

import lombok.RequiredArgsConstructor;

import com.example.service.payments.entity.PublicPaymentTypeEntity;
import com.example.service.payments.model.PublicPaymentTypeModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface PublicPaymentTypeEntityConverter {

    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicPaymentTypeEntity, PublicPaymentTypeModel> {
        private final ApplicationContext applicationContext;

        public PublicPaymentTypeModel convert(PublicPaymentTypeEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return PublicPaymentTypeModel.builder()
                    .id(source.getId())
                    .name(source.getName())
                    .description(source.getDescription())
                    .build();
        }
    }
}
