package com.example.service.payments.converter;

import lombok.RequiredArgsConstructor;

import com.example.service.payments.entity.PublicOrderTypeEntity;
import com.example.service.payments.model.PublicOrderTypeModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface PublicOrderTypeEntityConverter {

    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicOrderTypeEntity, PublicOrderTypeModel> {
        private final ApplicationContext applicationContext;

        public PublicOrderTypeModel convert(PublicOrderTypeEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return PublicOrderTypeModel.builder()
                    .id(source.getId())
                    .name(source.getName())
                    .description(source.getDescription())
                    .build();
        }
    }
}
