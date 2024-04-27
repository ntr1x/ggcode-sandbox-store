package com.example.service.events.converter.system;

import lombok.RequiredArgsConstructor;

import com.example.service.events.entity.PublicEventEntity;
import com.example.service.events.model.system.SystemPublicEventModel;

import org.ntr1x.common.api.component.AppConverter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

public interface SystemPublicEventEntityConverter {
    @Component
    @RequiredArgsConstructor
    class ToModel implements AppConverter<PublicEventEntity, SystemPublicEventModel> {
        private final ApplicationContext applicationContext;

        public SystemPublicEventModel convert(PublicEventEntity source) {
            ConversionService conversionService = applicationContext.getBean(ConversionService.class);

            return SystemPublicEventModel.builder()
                    .id(source.getId())
                    .topic(source.getTopic())
                    .contentType(source.getContentType())
                    .ceType(source.getCeType())
                    .ceSource(source.getCeSource())
                    .ceSpecification(source.getCeSpecification())
                    .ceId(source.getCeId())
                    .payload(source.getPayload())
                    .build();
        }
    }
}
