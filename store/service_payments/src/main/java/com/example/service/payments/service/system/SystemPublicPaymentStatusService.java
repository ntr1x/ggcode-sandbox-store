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

import com.example.service.payments.entity.PublicPaymentStatusEntity;
import com.example.service.payments.repository.PublicPaymentStatusRepository;
import com.example.service.payments.model.system.SystemPublicPaymentStatusModel;
import com.example.service.payments.request.system.SystemPublicPaymentStatusRequest;
import com.example.service.payments.response.system.SystemPublicPaymentStatusResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SystemPublicPaymentStatusService {

    private final PublicPaymentStatusRepository publicPaymentStatusRepository;
    private final EntityManager entityManager;
    private final ConversionService conversionService;
    private final EvaluatorService evaluatorService;
    private final GeneratorService generatorService;
    
    @Transactional
    public SystemPublicPaymentStatusResponse.Create create(
        SystemPublicPaymentStatusRequest.Context context,
        SystemPublicPaymentStatusRequest.Create request
    ) {
        PublicPaymentStatusEntity.PublicPaymentStatusEntityBuilder builder = PublicPaymentStatusEntity.builder();
        
        builder.id(generatorService.randomUUID());
        
        Optional.ofNullable(request.getName())
                .ifPresent((value) -> builder.name(value.orElse(null)));
        Optional.ofNullable(request.getDescription())
                .ifPresent((value) -> builder.description(value.orElse(null)));

        PublicPaymentStatusEntity entity = publicPaymentStatusRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        SystemPublicPaymentStatusModel created = conversionService.convert(entity, SystemPublicPaymentStatusModel.class);

        return SystemPublicPaymentStatusResponse.Create
            .builder()
            .created(created)
            .build();
    }
    
    @Transactional
    public SystemPublicPaymentStatusResponse.Remove remove(
        SystemPublicPaymentStatusRequest.Context context,
        SystemPublicPaymentStatusRequest.Id key
    ) {
        PublicPaymentStatusEntity entity = publicPaymentStatusRepository
                .findById(key.getId())
                .orElseThrow();

        SystemPublicPaymentStatusModel removed = conversionService.convert(entity, SystemPublicPaymentStatusModel.class);

        publicPaymentStatusRepository.delete(entity);

        return SystemPublicPaymentStatusResponse.Remove
            .builder()
            .removed(removed)
            .build();
    }
    
    @Transactional
    public SystemPublicPaymentStatusResponse.Update update(
        SystemPublicPaymentStatusRequest.Context context,
        SystemPublicPaymentStatusRequest.Update request
    ) {
        PublicPaymentStatusEntity example = PublicPaymentStatusEntity
                .builder()
                .id(request.getId())
                .build();

        PublicPaymentStatusEntity entity = publicPaymentStatusRepository
                .findOne(Example.of(example))
                .orElseThrow();

        PublicPaymentStatusEntity.PublicPaymentStatusEntityBuilder builder = entity.toBuilder();
        
        Optional.ofNullable(request.getName())
                .ifPresent((value) -> builder.name(value.orElse(null)));
        Optional.ofNullable(request.getDescription())
                .ifPresent((value) -> builder.description(value.orElse(null)));

        entity = publicPaymentStatusRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        SystemPublicPaymentStatusModel updated = conversionService.convert(entity, SystemPublicPaymentStatusModel.class);

        return SystemPublicPaymentStatusResponse.Update
            .builder()
            .updated(updated)
            .build();
    }
    
    @Transactional
    public SystemPublicPaymentStatusResponse.Replace replace(
        SystemPublicPaymentStatusRequest.Context context,
        SystemPublicPaymentStatusRequest.Id key,
        SystemPublicPaymentStatusRequest.Replace request
    ) {
        PublicPaymentStatusEntity example = PublicPaymentStatusEntity
                .builder()
                .id(key.getId())
                .build();

        PublicPaymentStatusEntity entity = publicPaymentStatusRepository
                .findOne(Example.of(example))
                .orElseThrow();

        SystemPublicPaymentStatusModel removed = conversionService.convert(entity, SystemPublicPaymentStatusModel.class);

        PublicPaymentStatusEntity.PublicPaymentStatusEntityBuilder builder = entity.toBuilder();
        
        Optional.ofNullable(request.getId())
                .ifPresent((value) -> builder.id(value.orElse(null)));
        Optional.ofNullable(request.getName())
                .ifPresent((value) -> builder.name(value.orElse(null)));
        Optional.ofNullable(request.getDescription())
                .ifPresent((value) -> builder.description(value.orElse(null)));

        entity = publicPaymentStatusRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        SystemPublicPaymentStatusModel created = conversionService.convert(entity, SystemPublicPaymentStatusModel.class);

        return SystemPublicPaymentStatusResponse.Replace
            .builder()
            .removed(removed)
            .created(created)
            .build();
    }
    
    @Transactional
    public Page<SystemPublicPaymentStatusModel> select(
        SystemPublicPaymentStatusRequest.Context context,
        SystemPublicPaymentStatusRequest.Select request,
        Pageable pageable
    ) {
        ExampleMatcher matcher = ExampleMatcher.matchingAll();

        PublicPaymentStatusEntity template = new PublicPaymentStatusEntity();
        
        
        Optional.ofNullable(request.getId())
                .ifPresent(optional -> {
                    matcher.withMatcher("id", m -> m.exact());
                    template.setId(optional.orElse(null));
                });
        
        
        Optional.ofNullable(request.getName())
                .ifPresent(optional -> {
                    matcher.withMatcher("name", m -> m.exact());
                    template.setName(optional.orElse(null));
                });
        
        Optional.ofNullable(request.getDescription())
                .ifPresent(optional -> {
                    matcher.withMatcher("description", m -> m.exact());
                    template.setDescription(optional.orElse(null));
                });

        Example<PublicPaymentStatusEntity> example = Example.of(template, matcher);

        return publicPaymentStatusRepository
                .findAll(example, pageable)
                .map(item -> conversionService.convert(item, SystemPublicPaymentStatusModel.class));
    }
    
    @Transactional
    public SystemPublicPaymentStatusModel get(
        SystemPublicPaymentStatusRequest.Context context,
        SystemPublicPaymentStatusRequest.Id key
    ) {
        PublicPaymentStatusEntity entity = publicPaymentStatusRepository
                .findById(key.getId())
                .orElseThrow();
        SystemPublicPaymentStatusModel result = conversionService.convert(entity, SystemPublicPaymentStatusModel.class);
        return result;
    }
}
