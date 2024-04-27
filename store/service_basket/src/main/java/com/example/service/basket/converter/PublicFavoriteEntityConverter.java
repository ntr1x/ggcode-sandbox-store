package com.example.service.basket.converter;

import lombok.RequiredArgsConstructor;

import com.example.service.basket.entity.PublicFavoriteEntity;
import com.example.service.basket.model.PublicFavoriteModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface PublicFavoriteEntityConverter {

    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicFavoriteEntity, PublicFavoriteModel> {
        private final ApplicationContext applicationContext;

        public PublicFavoriteModel convert(PublicFavoriteEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return PublicFavoriteModel.builder()
                    .id(source.getId())
                    .customerId(source.getCustomerId())
                    .productId(source.getProductId())
                    .customer(conversionService.convert(
                            source.getCustomer(),
                            com.example.service.basket.model.PublicCustomerModel.class))
                    .product(conversionService.convert(
                            source.getProduct(),
                            com.example.service.basket.model.PublicProductModel.class))
                    .build();
        }
    }
}
