package com.example.service.customers.converter.profile;

import lombok.RequiredArgsConstructor;

import com.example.service.customers.entity.PublicCustomerVerifyEmailEntity;
import com.example.service.customers.model.profile.ProfilePublicCustomerVerifyEmailModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface ProfilePublicCustomerVerifyEmailEntityConverter {
    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicCustomerVerifyEmailEntity, ProfilePublicCustomerVerifyEmailModel> {
        private final ApplicationContext applicationContext;

        public ProfilePublicCustomerVerifyEmailModel convert(PublicCustomerVerifyEmailEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return ProfilePublicCustomerVerifyEmailModel.builder()
                    .id(source.getId())
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
