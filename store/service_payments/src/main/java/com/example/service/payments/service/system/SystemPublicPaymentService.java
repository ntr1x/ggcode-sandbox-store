package com.example.service.payments.service.system;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import org.ntr1x.common.api.annotation.Event;
import org.ntr1x.common.api.service.EvaluatorService;
import org.ntr1x.common.api.service.GeneratorService;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.example.service.payments.entity.PublicPaymentEntity;
import com.example.service.payments.repository.PublicPaymentRepository;
import com.example.service.payments.model.system.SystemPublicPaymentModel;
import com.example.service.payments.request.system.SystemPublicPaymentRequest;
import com.example.service.payments.response.system.SystemPublicPaymentResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SystemPublicPaymentService {

    private final PublicPaymentRepository publicPaymentRepository;
    private final EntityManager entityManager;
    private final ConversionService conversionService;
    private final EvaluatorService evaluatorService;
    private final GeneratorService generatorService;
    
    @Transactional
    public SystemPublicPaymentResponse.Create create(
        SystemPublicPaymentRequest.Context context,
        SystemPublicPaymentRequest.Create request
    ) {
        PublicPaymentEntity.PublicPaymentEntityBuilder builder = PublicPaymentEntity.builder();
        
        builder.id(generatorService.randomUUID());
        
        Optional.ofNullable(request.getCustomerId())
                .ifPresent((value) -> builder.customerId(value.orElse(null)));
        Optional.ofNullable(request.getOrderId())
                .ifPresent((value) -> builder.orderId(value.orElse(null)));
        Optional.ofNullable(request.getPaymentStatusId())
                .ifPresent((value) -> builder.paymentStatusId(value.orElse(null)));
        Optional.ofNullable(request.getPaymentTypeId())
                .ifPresent((value) -> builder.paymentTypeId(value.orElse(null)));
        Optional.ofNullable(request.getValue())
                .ifPresent((value) -> builder.value(value.orElse(null)));
        Optional.ofNullable(request.getCreatedAt())
                .ifPresent((value) -> builder.createdAt(value.orElse(null)));
        Optional.ofNullable(request.getUpdatedAt())
                .ifPresent((value) -> builder.updatedAt(value.orElse(null)));

        PublicPaymentEntity entity = publicPaymentRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        SystemPublicPaymentModel created = conversionService.convert(entity, SystemPublicPaymentModel.class);

        return SystemPublicPaymentResponse.Create
            .builder()
            .created(created)
            .build();
    }
    
    @Transactional
    public SystemPublicPaymentResponse.Remove remove(
        SystemPublicPaymentRequest.Context context,
        SystemPublicPaymentRequest.Id key
    ) {
        PublicPaymentEntity entity = publicPaymentRepository
                .findById(key.getId())
                .orElseThrow();

        SystemPublicPaymentModel removed = conversionService.convert(entity, SystemPublicPaymentModel.class);

        publicPaymentRepository.delete(entity);

        return SystemPublicPaymentResponse.Remove
            .builder()
            .removed(removed)
            .build();
    }
    
    @Transactional
    public SystemPublicPaymentResponse.Update update(
        SystemPublicPaymentRequest.Context context,
        SystemPublicPaymentRequest.Update request
    ) {
        PublicPaymentEntity example = PublicPaymentEntity
                .builder()
                .id(request.getId())
                .build();

        PublicPaymentEntity entity = publicPaymentRepository
                .findOne(Example.of(example))
                .orElseThrow();

        PublicPaymentEntity.PublicPaymentEntityBuilder builder = entity.toBuilder();
        
        Optional.ofNullable(request.getCustomerId())
                .ifPresent((value) -> builder.customerId(value.orElse(null)));
        Optional.ofNullable(request.getOrderId())
                .ifPresent((value) -> builder.orderId(value.orElse(null)));
        Optional.ofNullable(request.getPaymentStatusId())
                .ifPresent((value) -> builder.paymentStatusId(value.orElse(null)));
        Optional.ofNullable(request.getPaymentTypeId())
                .ifPresent((value) -> builder.paymentTypeId(value.orElse(null)));
        Optional.ofNullable(request.getValue())
                .ifPresent((value) -> builder.value(value.orElse(null)));
        Optional.ofNullable(request.getCreatedAt())
                .ifPresent((value) -> builder.createdAt(value.orElse(null)));
        Optional.ofNullable(request.getUpdatedAt())
                .ifPresent((value) -> builder.updatedAt(value.orElse(null)));

        entity = publicPaymentRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        SystemPublicPaymentModel updated = conversionService.convert(entity, SystemPublicPaymentModel.class);

        return SystemPublicPaymentResponse.Update
            .builder()
            .updated(updated)
            .build();
    }
    
    @Transactional
    public SystemPublicPaymentResponse.Replace replace(
        SystemPublicPaymentRequest.Context context,
        SystemPublicPaymentRequest.Id key,
        SystemPublicPaymentRequest.Replace request
    ) {
        PublicPaymentEntity example = PublicPaymentEntity
                .builder()
                .id(key.getId())
                .build();

        PublicPaymentEntity entity = publicPaymentRepository
                .findOne(Example.of(example))
                .orElseThrow();

        SystemPublicPaymentModel removed = conversionService.convert(entity, SystemPublicPaymentModel.class);

        PublicPaymentEntity.PublicPaymentEntityBuilder builder = entity.toBuilder();
        
        Optional.ofNullable(request.getId())
                .ifPresent((value) -> builder.id(value.orElse(null)));
        Optional.ofNullable(request.getCustomerId())
                .ifPresent((value) -> builder.customerId(value.orElse(null)));
        Optional.ofNullable(request.getOrderId())
                .ifPresent((value) -> builder.orderId(value.orElse(null)));
        Optional.ofNullable(request.getPaymentStatusId())
                .ifPresent((value) -> builder.paymentStatusId(value.orElse(null)));
        Optional.ofNullable(request.getPaymentTypeId())
                .ifPresent((value) -> builder.paymentTypeId(value.orElse(null)));
        Optional.ofNullable(request.getValue())
                .ifPresent((value) -> builder.value(value.orElse(null)));
        Optional.ofNullable(request.getCreatedAt())
                .ifPresent((value) -> builder.createdAt(value.orElse(null)));
        Optional.ofNullable(request.getUpdatedAt())
                .ifPresent((value) -> builder.updatedAt(value.orElse(null)));

        entity = publicPaymentRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        SystemPublicPaymentModel created = conversionService.convert(entity, SystemPublicPaymentModel.class);

        return SystemPublicPaymentResponse.Replace
            .builder()
            .removed(removed)
            .created(created)
            .build();
    }
    
    @Transactional
    public Page<SystemPublicPaymentModel> select(
        SystemPublicPaymentRequest.Context context,
        SystemPublicPaymentRequest.Select request,
        Pageable pageable
    ) {
        ExampleMatcher matcher = ExampleMatcher.matchingAll();

        PublicPaymentEntity template = new PublicPaymentEntity();
        
        
        Optional.ofNullable(request.getId())
                .ifPresent(optional -> {
                    matcher.withMatcher("id", m -> m.exact());
                    template.setId(optional.orElse(null));
                });
        
        
        Optional.ofNullable(request.getCustomerId())
                .ifPresent(optional -> {
                    matcher.withMatcher("customerId", m -> m.exact());
                    template.setCustomerId(optional.orElse(null));
                });
        
        Optional.ofNullable(request.getOrderId())
                .ifPresent(optional -> {
                    matcher.withMatcher("orderId", m -> m.exact());
                    template.setOrderId(optional.orElse(null));
                });
        
        Optional.ofNullable(request.getPaymentStatusId())
                .ifPresent(optional -> {
                    matcher.withMatcher("paymentStatusId", m -> m.exact());
                    template.setPaymentStatusId(optional.orElse(null));
                });
        
        Optional.ofNullable(request.getPaymentTypeId())
                .ifPresent(optional -> {
                    matcher.withMatcher("paymentTypeId", m -> m.exact());
                    template.setPaymentTypeId(optional.orElse(null));
                });
        
        Optional.ofNullable(request.getValue())
                .ifPresent(optional -> {
                    matcher.withMatcher("value", m -> m.exact());
                    template.setValue(optional.orElse(null));
                });
        
        Optional.ofNullable(request.getCreatedAt())
                .ifPresent(optional -> {
                    matcher.withMatcher("createdAt", m -> m.exact());
                    template.setCreatedAt(optional.orElse(null));
                });
        
        Optional.ofNullable(request.getUpdatedAt())
                .ifPresent(optional -> {
                    matcher.withMatcher("updatedAt", m -> m.exact());
                    template.setUpdatedAt(optional.orElse(null));
                });

        Example<PublicPaymentEntity> example = Example.of(template, matcher);

        return publicPaymentRepository
                .findAll(example, pageable)
                .map(item -> conversionService.convert(item, SystemPublicPaymentModel.class));
    }
    
    @Transactional
    public SystemPublicPaymentModel get(
        SystemPublicPaymentRequest.Context context,
        SystemPublicPaymentRequest.Id key
    ) {
        PublicPaymentEntity entity = publicPaymentRepository
                .findById(key.getId())
                .orElseThrow();
        SystemPublicPaymentModel result = conversionService.convert(entity, SystemPublicPaymentModel.class);
        return result;
    }
}
