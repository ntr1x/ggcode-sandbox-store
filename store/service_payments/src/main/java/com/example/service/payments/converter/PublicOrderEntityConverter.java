package com.example.service.payments.converter;

import lombok.RequiredArgsConstructor;

import com.example.service.payments.entity.PublicOrderEntity;
import com.example.service.payments.model.PublicOrderModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface PublicOrderEntityConverter {

    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicOrderEntity, PublicOrderModel> {
        private final ApplicationContext applicationContext;

        public PublicOrderModel convert(PublicOrderEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return PublicOrderModel.builder()
                    .id(source.getId())
                    .customerId(source.getCustomerId())
                    .orderTypeId(source.getOrderTypeId())
                    .orderStatusId(source.getOrderStatusId())
                    .createdAt(source.getCreatedAt())
                    .updatedAt(source.getUpdatedAt())
                    .customer(conversionService.convert(
                            source.getCustomer(),
                            com.example.service.payments.model.PublicCustomerModel.class))
                    .orderType(conversionService.convert(
                            source.getOrderType(),
                            com.example.service.payments.model.PublicOrderTypeModel.class))
                    .orderStatus(conversionService.convert(
                            source.getOrderStatus(),
                            com.example.service.payments.model.PublicOrderStatusModel.class))
                    .build();
        }
    }
}
