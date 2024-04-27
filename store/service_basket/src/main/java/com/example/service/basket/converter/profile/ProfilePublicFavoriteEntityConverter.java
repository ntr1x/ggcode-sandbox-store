package com.example.service.basket.converter.profile;

import lombok.RequiredArgsConstructor;

import com.example.service.basket.entity.PublicFavoriteEntity;
import com.example.service.basket.model.profile.ProfilePublicFavoriteModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface ProfilePublicFavoriteEntityConverter {
    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicFavoriteEntity, ProfilePublicFavoriteModel> {
        private final ApplicationContext applicationContext;

        public ProfilePublicFavoriteModel convert(PublicFavoriteEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return ProfilePublicFavoriteModel.builder()
                    .id(source.getId())
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
