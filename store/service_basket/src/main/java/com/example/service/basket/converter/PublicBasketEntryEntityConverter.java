package com.example.service.basket.converter;

import lombok.RequiredArgsConstructor;

import com.example.service.basket.entity.PublicBasketEntryEntity;
import com.example.service.basket.model.PublicBasketEntryModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface PublicBasketEntryEntityConverter {

    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicBasketEntryEntity, PublicBasketEntryModel> {
        private final ApplicationContext applicationContext;

        public PublicBasketEntryModel convert(PublicBasketEntryEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return PublicBasketEntryModel.builder()
                    .id(source.getId())
                    .customerId(source.getCustomerId())
                    .productId(source.getProductId())
                    .quantity(source.getQuantity())
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
