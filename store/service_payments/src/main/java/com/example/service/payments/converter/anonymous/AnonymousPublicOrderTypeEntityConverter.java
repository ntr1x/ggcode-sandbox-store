package com.example.service.payments.converter.anonymous;

import lombok.RequiredArgsConstructor;

import com.example.service.payments.entity.PublicOrderTypeEntity;
import com.example.service.payments.model.anonymous.AnonymousPublicOrderTypeModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface AnonymousPublicOrderTypeEntityConverter {
    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicOrderTypeEntity, AnonymousPublicOrderTypeModel> {
        private final ApplicationContext applicationContext;

        public AnonymousPublicOrderTypeModel convert(PublicOrderTypeEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return AnonymousPublicOrderTypeModel.builder()
                    .id(source.getId())
                    .name(source.getName())
                    .description(source.getDescription())
                    .build();
        }
    }
}
