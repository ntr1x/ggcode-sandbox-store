package com.example.service.basket.converter.profile;

import lombok.RequiredArgsConstructor;

import com.example.service.basket.entity.PublicBasketEntryEntity;
import com.example.service.basket.model.profile.ProfilePublicBasketEntryModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface ProfilePublicBasketEntryEntityConverter {
    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicBasketEntryEntity, ProfilePublicBasketEntryModel> {
        private final ApplicationContext applicationContext;

        public ProfilePublicBasketEntryModel convert(PublicBasketEntryEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return ProfilePublicBasketEntryModel.builder()
                    .id(source.getId())
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
