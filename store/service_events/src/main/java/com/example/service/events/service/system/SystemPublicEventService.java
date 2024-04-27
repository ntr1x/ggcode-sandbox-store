package com.example.service.events.service.system;

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

import com.example.service.events.entity.PublicEventEntity;
import com.example.service.events.repository.PublicEventRepository;
import com.example.service.events.model.system.SystemPublicEventModel;
import com.example.service.events.request.system.SystemPublicEventRequest;
import com.example.service.events.response.system.SystemPublicEventResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SystemPublicEventService {

    private final PublicEventRepository publicEventRepository;
    private final EntityManager entityManager;
    private final ConversionService conversionService;
    private final EvaluatorService evaluatorService;
    private final GeneratorService generatorService;
    
    @Transactional
    public SystemPublicEventResponse.Create create(
        SystemPublicEventRequest.Context context,
        SystemPublicEventRequest.Create request
    ) {
        PublicEventEntity.PublicEventEntityBuilder builder = PublicEventEntity.builder();
        
        builder.id(generatorService.randomUUID());
        
        Optional.ofNullable(request.getTopic())
                .ifPresent((value) -> builder.topic(value.orElse(null)));
        Optional.ofNullable(request.getContentType())
                .ifPresent((value) -> builder.contentType(value.orElse(null)));
        Optional.ofNullable(request.getCeType())
                .ifPresent((value) -> builder.ceType(value.orElse(null)));
        Optional.ofNullable(request.getCeSource())
                .ifPresent((value) -> builder.ceSource(value.orElse(null)));
        Optional.ofNullable(request.getCeSpecification())
                .ifPresent((value) -> builder.ceSpecification(value.orElse(null)));
        Optional.ofNullable(request.getCeId())
                .ifPresent((value) -> builder.ceId(value.orElse(null)));
        Optional.ofNullable(request.getPayload())
                .ifPresent((value) -> builder.payload(value.orElse(null)));

        PublicEventEntity entity = publicEventRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        SystemPublicEventModel created = conversionService.convert(entity, SystemPublicEventModel.class);

        return SystemPublicEventResponse.Create
            .builder()
            .created(created)
            .build();
    }
    
    @Transactional
    public SystemPublicEventResponse.Remove remove(
        SystemPublicEventRequest.Context context,
        SystemPublicEventRequest.Id key
    ) {
        PublicEventEntity entity = publicEventRepository
                .findById(key.getId())
                .orElseThrow();

        SystemPublicEventModel removed = conversionService.convert(entity, SystemPublicEventModel.class);

        publicEventRepository.delete(entity);

        return SystemPublicEventResponse.Remove
            .builder()
            .removed(removed)
            .build();
    }
    
    @Transactional
    public SystemPublicEventResponse.Update update(
        SystemPublicEventRequest.Context context,
        SystemPublicEventRequest.Update request
    ) {
        PublicEventEntity example = PublicEventEntity
                .builder()
                .id(request.getId())
                .build();

        PublicEventEntity entity = publicEventRepository
                .findOne(Example.of(example))
                .orElseThrow();

        PublicEventEntity.PublicEventEntityBuilder builder = entity.toBuilder();
        
        Optional.ofNullable(request.getTopic())
                .ifPresent((value) -> builder.topic(value.orElse(null)));
        Optional.ofNullable(request.getContentType())
                .ifPresent((value) -> builder.contentType(value.orElse(null)));
        Optional.ofNullable(request.getCeType())
                .ifPresent((value) -> builder.ceType(value.orElse(null)));
        Optional.ofNullable(request.getCeSource())
                .ifPresent((value) -> builder.ceSource(value.orElse(null)));
        Optional.ofNullable(request.getCeSpecification())
                .ifPresent((value) -> builder.ceSpecification(value.orElse(null)));
        Optional.ofNullable(request.getCeId())
                .ifPresent((value) -> builder.ceId(value.orElse(null)));
        Optional.ofNullable(request.getPayload())
                .ifPresent((value) -> builder.payload(value.orElse(null)));

        entity = publicEventRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        SystemPublicEventModel updated = conversionService.convert(entity, SystemPublicEventModel.class);

        return SystemPublicEventResponse.Update
            .builder()
            .updated(updated)
            .build();
    }
    
    @Transactional
    public SystemPublicEventResponse.Replace replace(
        SystemPublicEventRequest.Context context,
        SystemPublicEventRequest.Id key,
        SystemPublicEventRequest.Replace request
    ) {
        PublicEventEntity example = PublicEventEntity
                .builder()
                .id(key.getId())
                .build();

        PublicEventEntity entity = publicEventRepository
                .findOne(Example.of(example))
                .orElseThrow();

        SystemPublicEventModel removed = conversionService.convert(entity, SystemPublicEventModel.class);

        PublicEventEntity.PublicEventEntityBuilder builder = entity.toBuilder();
        
        Optional.ofNullable(request.getId())
                .ifPresent((value) -> builder.id(value.orElse(null)));
        Optional.ofNullable(request.getTopic())
                .ifPresent((value) -> builder.topic(value.orElse(null)));
        Optional.ofNullable(request.getContentType())
                .ifPresent((value) -> builder.contentType(value.orElse(null)));
        Optional.ofNullable(request.getCeType())
                .ifPresent((value) -> builder.ceType(value.orElse(null)));
        Optional.ofNullable(request.getCeSource())
                .ifPresent((value) -> builder.ceSource(value.orElse(null)));
        Optional.ofNullable(request.getCeSpecification())
                .ifPresent((value) -> builder.ceSpecification(value.orElse(null)));
        Optional.ofNullable(request.getCeId())
                .ifPresent((value) -> builder.ceId(value.orElse(null)));
        Optional.ofNullable(request.getPayload())
                .ifPresent((value) -> builder.payload(value.orElse(null)));

        entity = publicEventRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        SystemPublicEventModel created = conversionService.convert(entity, SystemPublicEventModel.class);

        return SystemPublicEventResponse.Replace
            .builder()
            .removed(removed)
            .created(created)
            .build();
    }
    
    @Transactional
    public Page<SystemPublicEventModel> select(
        SystemPublicEventRequest.Context context,
        SystemPublicEventRequest.Select request,
        Pageable pageable
    ) {
        ExampleMatcher matcher = ExampleMatcher.matchingAll();

        PublicEventEntity template = new PublicEventEntity();
        
        
        Optional.ofNullable(request.getId())
                .ifPresent(optional -> {
                    matcher.withMatcher("id", m -> m.exact());
                    template.setId(optional.orElse(null));
                });
        
        
        Optional.ofNullable(request.getTopic())
                .ifPresent(optional -> {
                    matcher.withMatcher("topic", m -> m.exact());
                    template.setTopic(optional.orElse(null));
                });
        
        Optional.ofNullable(request.getContentType())
                .ifPresent(optional -> {
                    matcher.withMatcher("contentType", m -> m.exact());
                    template.setContentType(optional.orElse(null));
                });
        
        Optional.ofNullable(request.getCeType())
                .ifPresent(optional -> {
                    matcher.withMatcher("ceType", m -> m.exact());
                    template.setCeType(optional.orElse(null));
                });
        
        Optional.ofNullable(request.getCeSource())
                .ifPresent(optional -> {
                    matcher.withMatcher("ceSource", m -> m.exact());
                    template.setCeSource(optional.orElse(null));
                });
        
        Optional.ofNullable(request.getCeSpecification())
                .ifPresent(optional -> {
                    matcher.withMatcher("ceSpecification", m -> m.exact());
                    template.setCeSpecification(optional.orElse(null));
                });
        
        Optional.ofNullable(request.getCeId())
                .ifPresent(optional -> {
                    matcher.withMatcher("ceId", m -> m.exact());
                    template.setCeId(optional.orElse(null));
                });
        
        Optional.ofNullable(request.getPayload())
                .ifPresent(optional -> {
                    matcher.withMatcher("payload", m -> m.exact());
                    template.setPayload(optional.orElse(null));
                });

        Example<PublicEventEntity> example = Example.of(template, matcher);

        return publicEventRepository
                .findAll(example, pageable)
                .map(item -> conversionService.convert(item, SystemPublicEventModel.class));
    }
    
    @Transactional
    public SystemPublicEventModel get(
        SystemPublicEventRequest.Context context,
        SystemPublicEventRequest.Id key
    ) {
        PublicEventEntity entity = publicEventRepository
                .findById(key.getId())
                .orElseThrow();
        SystemPublicEventModel result = conversionService.convert(entity, SystemPublicEventModel.class);
        return result;
    }
}
