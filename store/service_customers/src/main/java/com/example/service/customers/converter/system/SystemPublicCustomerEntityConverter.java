package com.example.service.customers.converter.system;

import lombok.RequiredArgsConstructor;

import com.example.service.customers.entity.PublicCustomerEntity;
import com.example.service.customers.model.system.SystemPublicCustomerModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface SystemPublicCustomerEntityConverter {
    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicCustomerEntity, SystemPublicCustomerModel> {
        private final ApplicationContext applicationContext;

        public SystemPublicCustomerModel convert(PublicCustomerEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return SystemPublicCustomerModel.builder()
                    .id(source.getId())
                    .email(source.getEmail())
                    .phone(source.getPhone())
                    .name(source.getName())
                    .build();
        }
    }
}
