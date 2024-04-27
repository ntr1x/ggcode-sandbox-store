package com.example.service.payments.converter.anonymous;

import lombok.RequiredArgsConstructor;

import com.example.service.payments.entity.PublicPaymentTypeEntity;
import com.example.service.payments.model.anonymous.AnonymousPublicPaymentTypeModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface AnonymousPublicPaymentTypeEntityConverter {
    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicPaymentTypeEntity, AnonymousPublicPaymentTypeModel> {
        private final ApplicationContext applicationContext;

        public AnonymousPublicPaymentTypeModel convert(PublicPaymentTypeEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return AnonymousPublicPaymentTypeModel.builder()
                    .id(source.getId())
                    .name(source.getName())
                    .description(source.getDescription())
                    .build();
        }
    }
}
