package com.example.service.payments.converter;

import lombok.RequiredArgsConstructor;

import com.example.service.payments.entity.PublicOrderEntryEntity;
import com.example.service.payments.model.PublicOrderEntryModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface PublicOrderEntryEntityConverter {

    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicOrderEntryEntity, PublicOrderEntryModel> {
        private final ApplicationContext applicationContext;

        public PublicOrderEntryModel convert(PublicOrderEntryEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return PublicOrderEntryModel.builder()
                    .id(source.getId())
                    .productId(source.getProductId())
                    .orderId(source.getOrderId())
                    .quantity(source.getQuantity())
                    .order(conversionService.convert(
                            source.getOrder(),
                            com.example.service.payments.model.PublicOrderModel.class))
                    .product(conversionService.convert(
                            source.getProduct(),
                            com.example.service.payments.model.PublicProductModel.class))
                    .build();
        }
    }
}
