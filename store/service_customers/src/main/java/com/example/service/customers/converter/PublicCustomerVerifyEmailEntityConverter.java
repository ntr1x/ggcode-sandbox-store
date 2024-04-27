package com.example.service.customers.converter;

import lombok.RequiredArgsConstructor;

import com.example.service.customers.entity.PublicCustomerVerifyEmailEntity;
import com.example.service.customers.model.PublicCustomerVerifyEmailModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface PublicCustomerVerifyEmailEntityConverter {

    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicCustomerVerifyEmailEntity, PublicCustomerVerifyEmailModel> {
        private final ApplicationContext applicationContext;

        public PublicCustomerVerifyEmailModel convert(PublicCustomerVerifyEmailEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return PublicCustomerVerifyEmailModel.builder()
                    .id(source.getId())
                    .customerId(source.getCustomerId())
                    .email(source.getEmail())
                    .secret(source.getSecret())
                    .isConfirmed(source.getIsConfirmed())
                    .customer(conversionService.convert(
                            source.getCustomer(),
                            com.example.service.customers.model.PublicCustomerModel.class))
                    .build();
        }
    }
}
