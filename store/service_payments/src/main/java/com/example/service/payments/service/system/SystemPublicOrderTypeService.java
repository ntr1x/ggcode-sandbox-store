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

import com.example.service.payments.entity.PublicOrderTypeEntity;
import com.example.service.payments.repository.PublicOrderTypeRepository;
import com.example.service.payments.model.system.SystemPublicOrderTypeModel;
import com.example.service.payments.request.system.SystemPublicOrderTypeRequest;
import com.example.service.payments.response.system.SystemPublicOrderTypeResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SystemPublicOrderTypeService {

    private final PublicOrderTypeRepository publicOrderTypeRepository;
    private final EntityManager entityManager;
    private final ConversionService conversionService;
    private final EvaluatorService evaluatorService;
    private final GeneratorService generatorService;
    
    @Transactional
    public SystemPublicOrderTypeResponse.Create create(
        SystemPublicOrderTypeRequest.Context context,
        SystemPublicOrderTypeRequest.Create request
    ) {
        PublicOrderTypeEntity.PublicOrderTypeEntityBuilder builder = PublicOrderTypeEntity.builder();
        
        builder.id(generatorService.randomUUID());
        
        Optional.ofNullable(request.getName())
                .ifPresent((value) -> builder.name(value.orElse(null)));
        Optional.ofNullable(request.getDescription())
                .ifPresent((value) -> builder.description(value.orElse(null)));

        PublicOrderTypeEntity entity = publicOrderTypeRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        SystemPublicOrderTypeModel created = conversionService.convert(entity, SystemPublicOrderTypeModel.class);

        return SystemPublicOrderTypeResponse.Create
            .builder()
            .created(created)
            .build();
    }
    
    @Transactional
    public SystemPublicOrderTypeResponse.Remove remove(
        SystemPublicOrderTypeRequest.Context context,
        SystemPublicOrderTypeRequest.Id key
    ) {
        PublicOrderTypeEntity entity = publicOrderTypeRepository
                .findById(key.getId())
                .orElseThrow();

        SystemPublicOrderTypeModel removed = conversionService.convert(entity, SystemPublicOrderTypeModel.class);

        publicOrderTypeRepository.delete(entity);

        return SystemPublicOrderTypeResponse.Remove
            .builder()
            .removed(removed)
            .build();
    }
    
    @Transactional
    public SystemPublicOrderTypeResponse.Update update(
        SystemPublicOrderTypeRequest.Context context,
        SystemPublicOrderTypeRequest.Update request
    ) {
        PublicOrderTypeEntity example = PublicOrderTypeEntity
                .builder()
                .id(request.getId())
                .build();

        PublicOrderTypeEntity entity = publicOrderTypeRepository
                .findOne(Example.of(example))
                .orElseThrow();

        PublicOrderTypeEntity.PublicOrderTypeEntityBuilder builder = entity.toBuilder();
        
        Optional.ofNullable(request.getName())
                .ifPresent((value) -> builder.name(value.orElse(null)));
        Optional.ofNullable(request.getDescription())
                .ifPresent((value) -> builder.description(value.orElse(null)));

        entity = publicOrderTypeRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        SystemPublicOrderTypeModel updated = conversionService.convert(entity, SystemPublicOrderTypeModel.class);

        return SystemPublicOrderTypeResponse.Update
            .builder()
            .updated(updated)
            .build();
    }
    
    @Transactional
    public SystemPublicOrderTypeResponse.Replace replace(
        SystemPublicOrderTypeRequest.Context context,
        SystemPublicOrderTypeRequest.Id key,
        SystemPublicOrderTypeRequest.Replace request
    ) {
        PublicOrderTypeEntity example = PublicOrderTypeEntity
                .builder()
                .id(key.getId())
                .build();

        PublicOrderTypeEntity entity = publicOrderTypeRepository
                .findOne(Example.of(example))
                .orElseThrow();

        SystemPublicOrderTypeModel removed = conversionService.convert(entity, SystemPublicOrderTypeModel.class);

        PublicOrderTypeEntity.PublicOrderTypeEntityBuilder builder = entity.toBuilder();
        
        Optional.ofNullable(request.getId())
                .ifPresent((value) -> builder.id(value.orElse(null)));
        Optional.ofNullable(request.getName())
                .ifPresent((value) -> builder.name(value.orElse(null)));
        Optional.ofNullable(request.getDescription())
                .ifPresent((value) -> builder.description(value.orElse(null)));

        entity = publicOrderTypeRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        SystemPublicOrderTypeModel created = conversionService.convert(entity, SystemPublicOrderTypeModel.class);

        return SystemPublicOrderTypeResponse.Replace
            .builder()
            .removed(removed)
            .created(created)
            .build();
    }
    
    @Transactional
    public Page<SystemPublicOrderTypeModel> select(
        SystemPublicOrderTypeRequest.Context context,
        SystemPublicOrderTypeRequest.Select request,
        Pageable pageable
    ) {
        ExampleMatcher matcher = ExampleMatcher.matchingAll();

        PublicOrderTypeEntity template = new PublicOrderTypeEntity();
        
        
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

        Example<PublicOrderTypeEntity> example = Example.of(template, matcher);

        return publicOrderTypeRepository
                .findAll(example, pageable)
                .map(item -> conversionService.convert(item, SystemPublicOrderTypeModel.class));
    }
    
    @Transactional
    public SystemPublicOrderTypeModel get(
        SystemPublicOrderTypeRequest.Context context,
        SystemPublicOrderTypeRequest.Id key
    ) {
        PublicOrderTypeEntity entity = publicOrderTypeRepository
                .findById(key.getId())
                .orElseThrow();
        SystemPublicOrderTypeModel result = conversionService.convert(entity, SystemPublicOrderTypeModel.class);
        return result;
    }
}
