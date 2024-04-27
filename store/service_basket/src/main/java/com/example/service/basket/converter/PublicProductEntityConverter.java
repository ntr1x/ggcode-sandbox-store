package com.example.service.basket.converter;

import lombok.RequiredArgsConstructor;

import com.example.service.basket.entity.PublicProductEntity;
import com.example.service.basket.model.PublicProductModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface PublicProductEntityConverter {

    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicProductEntity, PublicProductModel> {
        private final ApplicationContext applicationContext;

        public PublicProductModel convert(PublicProductEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return PublicProductModel.builder()
                    .id(source.getId())
                    .name(source.getName())
                    .price(source.getPrice())
                    .build();
        }
    }
}
