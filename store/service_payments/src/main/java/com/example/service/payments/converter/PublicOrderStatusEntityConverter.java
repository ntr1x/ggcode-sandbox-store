package com.example.service.payments.converter;

import lombok.RequiredArgsConstructor;

import com.example.service.payments.entity.PublicOrderStatusEntity;
import com.example.service.payments.model.PublicOrderStatusModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface PublicOrderStatusEntityConverter {

    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicOrderStatusEntity, PublicOrderStatusModel> {
        private final ApplicationContext applicationContext;

        public PublicOrderStatusModel convert(PublicOrderStatusEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return PublicOrderStatusModel.builder()
                    .id(source.getId())
                    .name(source.getName())
                    .description(source.getDescription())
                    .build();
        }
    }
}
