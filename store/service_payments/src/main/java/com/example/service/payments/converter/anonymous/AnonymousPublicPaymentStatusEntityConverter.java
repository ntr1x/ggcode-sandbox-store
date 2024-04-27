package com.example.service.payments.converter.anonymous;

import lombok.RequiredArgsConstructor;

import com.example.service.payments.entity.PublicPaymentStatusEntity;
import com.example.service.payments.model.anonymous.AnonymousPublicPaymentStatusModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface AnonymousPublicPaymentStatusEntityConverter {
    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicPaymentStatusEntity, AnonymousPublicPaymentStatusModel> {
        private final ApplicationContext applicationContext;

        public AnonymousPublicPaymentStatusModel convert(PublicPaymentStatusEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return AnonymousPublicPaymentStatusModel.builder()
                    .id(source.getId())
                    .name(source.getName())
                    .description(source.getDescription())
                    .build();
        }
    }
}
