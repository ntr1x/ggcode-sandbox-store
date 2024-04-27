package com.example.service.payments.converter.anonymous;

import lombok.RequiredArgsConstructor;

import com.example.service.payments.entity.PublicOrderStatusEntity;
import com.example.service.payments.model.anonymous.AnonymousPublicOrderStatusModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface AnonymousPublicOrderStatusEntityConverter {
    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicOrderStatusEntity, AnonymousPublicOrderStatusModel> {
        private final ApplicationContext applicationContext;

        public AnonymousPublicOrderStatusModel convert(PublicOrderStatusEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return AnonymousPublicOrderStatusModel.builder()
                    .id(source.getId())
                    .name(source.getName())
                    .description(source.getDescription())
                    .build();
        }
    }
}
