package com.example.service.payments.converter.profile;

import lombok.RequiredArgsConstructor;

import com.example.service.payments.entity.PublicOrderEntity;
import com.example.service.payments.model.profile.ProfilePublicOrderModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface ProfilePublicOrderEntityConverter {
    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicOrderEntity, ProfilePublicOrderModel> {
        private final ApplicationContext applicationContext;

        public ProfilePublicOrderModel convert(PublicOrderEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return ProfilePublicOrderModel.builder()
                    .id(source.getId())
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
