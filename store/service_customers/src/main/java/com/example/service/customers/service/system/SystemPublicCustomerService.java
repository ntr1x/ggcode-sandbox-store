package com.example.service.customers.service.system;

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

import com.example.service.customers.entity.PublicCustomerEntity;
import com.example.service.customers.repository.PublicCustomerRepository;
import com.example.service.customers.model.system.SystemPublicCustomerModel;
import com.example.service.customers.request.system.SystemPublicCustomerRequest;
import com.example.service.customers.response.system.SystemPublicCustomerResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SystemPublicCustomerService {

    private final PublicCustomerRepository publicCustomerRepository;
    private final EntityManager entityManager;
    private final ConversionService conversionService;
    private final EvaluatorService evaluatorService;
    private final GeneratorService generatorService;
    
    @Transactional
    @Event(topic = "public_customer", type = "created", source = "service:service_customers", payloadEl = "#result.created")
    public SystemPublicCustomerResponse.Create create(
        SystemPublicCustomerRequest.Context context,
        SystemPublicCustomerRequest.Create request
    ) {
        PublicCustomerEntity.PublicCustomerEntityBuilder builder = PublicCustomerEntity.builder();
        
        builder.id(generatorService.randomUUID());
        
        Optional.ofNullable(request.getEmail())
                .ifPresent((value) -> builder.email(value.orElse(null)));
        Optional.ofNullable(request.getPhone())
                .ifPresent((value) -> builder.phone(value.orElse(null)));
        Optional.ofNullable(request.getName())
                .ifPresent((value) -> builder.name(value.orElse(null)));

        PublicCustomerEntity entity = publicCustomerRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        SystemPublicCustomerModel created = conversionService.convert(entity, SystemPublicCustomerModel.class);

        return SystemPublicCustomerResponse.Create
            .builder()
            .created(created)
            .build();
    }
    
    @Transactional
    @Event(topic = "public_customer", type = "removed", source = "service:service_customers", payloadEl = "#result.removed")
    public SystemPublicCustomerResponse.Remove remove(
        SystemPublicCustomerRequest.Context context,
        SystemPublicCustomerRequest.Id key
    ) {
        PublicCustomerEntity entity = publicCustomerRepository
                .findById(key.getId())
                .orElseThrow();

        SystemPublicCustomerModel removed = conversionService.convert(entity, SystemPublicCustomerModel.class);

        publicCustomerRepository.delete(entity);

        return SystemPublicCustomerResponse.Remove
            .builder()
            .removed(removed)
            .build();
    }
    
    @Transactional
    @Event(topic = "public_customer", type = "updated", source = "service:service_customers", payloadEl = "#result.updated")
    public SystemPublicCustomerResponse.Update update(
        SystemPublicCustomerRequest.Context context,
        SystemPublicCustomerRequest.Update request
    ) {
        PublicCustomerEntity example = PublicCustomerEntity
                .builder()
                .id(request.getId())
                .build();

        PublicCustomerEntity entity = publicCustomerRepository
                .findOne(Example.of(example))
                .orElseThrow();

        PublicCustomerEntity.PublicCustomerEntityBuilder builder = entity.toBuilder();
        
        Optional.ofNullable(request.getEmail())
                .ifPresent((value) -> builder.email(value.orElse(null)));
        Optional.ofNullable(request.getPhone())
                .ifPresent((value) -> builder.phone(value.orElse(null)));
        Optional.ofNullable(request.getName())
                .ifPresent((value) -> builder.name(value.orElse(null)));

        entity = publicCustomerRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        SystemPublicCustomerModel updated = conversionService.convert(entity, SystemPublicCustomerModel.class);

        return SystemPublicCustomerResponse.Update
            .builder()
            .updated(updated)
            .build();
    }
    
    @Transactional
    @Event(topic = "public_customer", type = "removed", source = "service:service_customers", payloadEl = "#result.removed")
    @Event(topic = "public_customer", type = "created", source = "service:service_customers", payloadEl = "#result.created")
    public SystemPublicCustomerResponse.Replace replace(
        SystemPublicCustomerRequest.Context context,
        SystemPublicCustomerRequest.Id key,
        SystemPublicCustomerRequest.Replace request
    ) {
        PublicCustomerEntity example = PublicCustomerEntity
                .builder()
                .id(key.getId())
                .build();

        PublicCustomerEntity entity = publicCustomerRepository
                .findOne(Example.of(example))
                .orElseThrow();

        SystemPublicCustomerModel removed = conversionService.convert(entity, SystemPublicCustomerModel.class);

        PublicCustomerEntity.PublicCustomerEntityBuilder builder = entity.toBuilder();
        
        Optional.ofNullable(request.getId())
                .ifPresent((value) -> builder.id(value.orElse(null)));
        Optional.ofNullable(request.getEmail())
                .ifPresent((value) -> builder.email(value.orElse(null)));
        Optional.ofNullable(request.getPhone())
                .ifPresent((value) -> builder.phone(value.orElse(null)));
        Optional.ofNullable(request.getName())
                .ifPresent((value) -> builder.name(value.orElse(null)));

        entity = publicCustomerRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        SystemPublicCustomerModel created = conversionService.convert(entity, SystemPublicCustomerModel.class);

        return SystemPublicCustomerResponse.Replace
            .builder()
            .removed(removed)
            .created(created)
            .build();
    }
    
    @Transactional
    public Page<SystemPublicCustomerModel> select(
        SystemPublicCustomerRequest.Context context,
        SystemPublicCustomerRequest.Select request,
        Pageable pageable
    ) {
        ExampleMatcher matcher = ExampleMatcher.matchingAll();

        PublicCustomerEntity template = new PublicCustomerEntity();
        
        
        Optional.ofNullable(request.getId())
                .ifPresent(optional -> {
                    matcher.withMatcher("id", m -> m.exact());
                    template.setId(optional.orElse(null));
                });
        
        
        Optional.ofNullable(request.getEmail())
                .ifPresent(optional -> {
                    matcher.withMatcher("email", m -> m.exact());
                    template.setEmail(optional.orElse(null));
                });
        
        Optional.ofNullable(request.getPhone())
                .ifPresent(optional -> {
                    matcher.withMatcher("phone", m -> m.exact());
                    template.setPhone(optional.orElse(null));
                });
        
        Optional.ofNullable(request.getName())
                .ifPresent(optional -> {
                    matcher.withMatcher("name", m -> m.exact());
                    template.setName(optional.orElse(null));
                });

        Example<PublicCustomerEntity> example = Example.of(template, matcher);

        return publicCustomerRepository
                .findAll(example, pageable)
                .map(item -> conversionService.convert(item, SystemPublicCustomerModel.class));
    }
    
    @Transactional
    public SystemPublicCustomerModel get(
        SystemPublicCustomerRequest.Context context,
        SystemPublicCustomerRequest.Id key
    ) {
        PublicCustomerEntity entity = publicCustomerRepository
                .findById(key.getId())
                .orElseThrow();
        SystemPublicCustomerModel result = conversionService.convert(entity, SystemPublicCustomerModel.class);
        return result;
    }
}
