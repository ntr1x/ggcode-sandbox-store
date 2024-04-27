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

import com.example.service.payments.entity.PublicPaymentTypeEntity;
import com.example.service.payments.repository.PublicPaymentTypeRepository;
import com.example.service.payments.model.system.SystemPublicPaymentTypeModel;
import com.example.service.payments.request.system.SystemPublicPaymentTypeRequest;
import com.example.service.payments.response.system.SystemPublicPaymentTypeResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SystemPublicPaymentTypeService {

    private final PublicPaymentTypeRepository publicPaymentTypeRepository;
    private final EntityManager entityManager;
    private final ConversionService conversionService;
    private final EvaluatorService evaluatorService;
    private final GeneratorService generatorService;
    
    @Transactional
    public SystemPublicPaymentTypeResponse.Create create(
        SystemPublicPaymentTypeRequest.Context context,
        SystemPublicPaymentTypeRequest.Create request
    ) {
        PublicPaymentTypeEntity.PublicPaymentTypeEntityBuilder builder = PublicPaymentTypeEntity.builder();
        
        builder.id(generatorService.randomUUID());
        
        Optional.ofNullable(request.getName())
                .ifPresent((value) -> builder.name(value.orElse(null)));
        Optional.ofNullable(request.getDescription())
                .ifPresent((value) -> builder.description(value.orElse(null)));

        PublicPaymentTypeEntity entity = publicPaymentTypeRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        SystemPublicPaymentTypeModel created = conversionService.convert(entity, SystemPublicPaymentTypeModel.class);

        return SystemPublicPaymentTypeResponse.Create
            .builder()
            .created(created)
            .build();
    }
    
    @Transactional
    public SystemPublicPaymentTypeResponse.Remove remove(
        SystemPublicPaymentTypeRequest.Context context,
        SystemPublicPaymentTypeRequest.Id key
    ) {
        PublicPaymentTypeEntity entity = publicPaymentTypeRepository
                .findById(key.getId())
                .orElseThrow();

        SystemPublicPaymentTypeModel removed = conversionService.convert(entity, SystemPublicPaymentTypeModel.class);

        publicPaymentTypeRepository.delete(entity);

        return SystemPublicPaymentTypeResponse.Remove
            .builder()
            .removed(removed)
            .build();
    }
    
    @Transactional
    public SystemPublicPaymentTypeResponse.Update update(
        SystemPublicPaymentTypeRequest.Context context,
        SystemPublicPaymentTypeRequest.Update request
    ) {
        PublicPaymentTypeEntity example = PublicPaymentTypeEntity
                .builder()
                .id(request.getId())
                .build();

        PublicPaymentTypeEntity entity = publicPaymentTypeRepository
                .findOne(Example.of(example))
                .orElseThrow();

        PublicPaymentTypeEntity.PublicPaymentTypeEntityBuilder builder = entity.toBuilder();
        
        Optional.ofNullable(request.getName())
                .ifPresent((value) -> builder.name(value.orElse(null)));
        Optional.ofNullable(request.getDescription())
                .ifPresent((value) -> builder.description(value.orElse(null)));

        entity = publicPaymentTypeRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        SystemPublicPaymentTypeModel updated = conversionService.convert(entity, SystemPublicPaymentTypeModel.class);

        return SystemPublicPaymentTypeResponse.Update
            .builder()
            .updated(updated)
            .build();
    }
    
    @Transactional
    public SystemPublicPaymentTypeResponse.Replace replace(
        SystemPublicPaymentTypeRequest.Context context,
        SystemPublicPaymentTypeRequest.Id key,
        SystemPublicPaymentTypeRequest.Replace request
    ) {
        PublicPaymentTypeEntity example = PublicPaymentTypeEntity
                .builder()
                .id(key.getId())
                .build();

        PublicPaymentTypeEntity entity = publicPaymentTypeRepository
                .findOne(Example.of(example))
                .orElseThrow();

        SystemPublicPaymentTypeModel removed = conversionService.convert(entity, SystemPublicPaymentTypeModel.class);

        PublicPaymentTypeEntity.PublicPaymentTypeEntityBuilder builder = entity.toBuilder();
        
        Optional.ofNullable(request.getId())
                .ifPresent((value) -> builder.id(value.orElse(null)));
        Optional.ofNullable(request.getName())
                .ifPresent((value) -> builder.name(value.orElse(null)));
        Optional.ofNullable(request.getDescription())
                .ifPresent((value) -> builder.description(value.orElse(null)));

        entity = publicPaymentTypeRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        SystemPublicPaymentTypeModel created = conversionService.convert(entity, SystemPublicPaymentTypeModel.class);

        return SystemPublicPaymentTypeResponse.Replace
            .builder()
            .removed(removed)
            .created(created)
            .build();
    }
    
    @Transactional
    public Page<SystemPublicPaymentTypeModel> select(
        SystemPublicPaymentTypeRequest.Context context,
        SystemPublicPaymentTypeRequest.Select request,
        Pageable pageable
    ) {
        ExampleMatcher matcher = ExampleMatcher.matchingAll();

        PublicPaymentTypeEntity template = new PublicPaymentTypeEntity();
        
        
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

        Example<PublicPaymentTypeEntity> example = Example.of(template, matcher);

        return publicPaymentTypeRepository
                .findAll(example, pageable)
                .map(item -> conversionService.convert(item, SystemPublicPaymentTypeModel.class));
    }
    
    @Transactional
    public SystemPublicPaymentTypeModel get(
        SystemPublicPaymentTypeRequest.Context context,
        SystemPublicPaymentTypeRequest.Id key
    ) {
        PublicPaymentTypeEntity entity = publicPaymentTypeRepository
                .findById(key.getId())
                .orElseThrow();
        SystemPublicPaymentTypeModel result = conversionService.convert(entity, SystemPublicPaymentTypeModel.class);
        return result;
    }
}
