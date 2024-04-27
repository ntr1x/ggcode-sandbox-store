package com.example.service.customers.service.profile;

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

import com.example.service.customers.entity.PublicCustomerVerifyPhoneEntity;
import com.example.service.customers.repository.PublicCustomerVerifyPhoneRepository;
import com.example.service.customers.model.profile.ProfilePublicCustomerVerifyPhoneModel;
import com.example.service.customers.request.profile.ProfilePublicCustomerVerifyPhoneRequest;
import com.example.service.customers.response.profile.ProfilePublicCustomerVerifyPhoneResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfilePublicCustomerVerifyPhoneService {

    private final PublicCustomerVerifyPhoneRepository publicCustomerVerifyPhoneRepository;
    private final EntityManager entityManager;
    private final ConversionService conversionService;
    private final EvaluatorService evaluatorService;
    private final GeneratorService generatorService;
    
    @Transactional
    @Event(topic = "verify_phone", type = "created", source = "service:service_customers", payloadEl = "#result.created")
    public ProfilePublicCustomerVerifyPhoneResponse.Create create(
        ProfilePublicCustomerVerifyPhoneRequest.Context context,
        ProfilePublicCustomerVerifyPhoneRequest.Create request
    ) {
        PublicCustomerVerifyPhoneEntity.PublicCustomerVerifyPhoneEntityBuilder builder = PublicCustomerVerifyPhoneEntity.builder();
        
        builder.id(generatorService.randomUUID());
        
        builder.customerId(context.getCustomerId());
        Optional.ofNullable(request.getPhone())
                .ifPresent((value) -> builder.phone(value.orElse(null)));
        builder.secret(evaluatorService.evaluate("@generatorService.randomInt(1000, 9999)", java.lang.Integer.class));
        builder.isConfirmed(false);

        PublicCustomerVerifyPhoneEntity entity = publicCustomerVerifyPhoneRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        ProfilePublicCustomerVerifyPhoneModel created = conversionService.convert(entity, ProfilePublicCustomerVerifyPhoneModel.class);

        return ProfilePublicCustomerVerifyPhoneResponse.Create
            .builder()
            .created(created)
            .build();
    }
    
    @Transactional
    public ProfilePublicCustomerVerifyPhoneResponse.Remove remove(
        ProfilePublicCustomerVerifyPhoneRequest.Context context,
        ProfilePublicCustomerVerifyPhoneRequest.Id key
    ) {
        PublicCustomerVerifyPhoneEntity entity = publicCustomerVerifyPhoneRepository
                .findById(key.getId())
                .orElseThrow();

        ProfilePublicCustomerVerifyPhoneModel removed = conversionService.convert(entity, ProfilePublicCustomerVerifyPhoneModel.class);

        publicCustomerVerifyPhoneRepository.delete(entity);

        return ProfilePublicCustomerVerifyPhoneResponse.Remove
            .builder()
            .removed(removed)
            .build();
    }
    
    @Transactional
    @Event(topic = "update_email", type = "updated", source = "service:service_customers", payloadEl = "#result.updated")
    public ProfilePublicCustomerVerifyPhoneResponse.Update update(
        ProfilePublicCustomerVerifyPhoneRequest.Context context,
        ProfilePublicCustomerVerifyPhoneRequest.Update request
    ) {
        PublicCustomerVerifyPhoneEntity example = PublicCustomerVerifyPhoneEntity
                .builder()
                .id(request.getId())
                .customerId(context.getCustomerId())
                .build();

        PublicCustomerVerifyPhoneEntity entity = publicCustomerVerifyPhoneRepository
                .findOne(Example.of(example))
                .orElseThrow();

        PublicCustomerVerifyPhoneEntity.PublicCustomerVerifyPhoneEntityBuilder builder = entity.toBuilder();
        
        builder.customerId(context.getCustomerId());
        Optional.ofNullable(request.getPhone())
                .ifPresent((value) -> builder.phone(value.orElse(null)));
        Optional.ofNullable(request.getSecret())
                .ifPresent((value) -> builder.secret(value.orElse(null)));
        Optional.ofNullable(request.getIsConfirmed())
                .ifPresent((value) -> builder.isConfirmed(value.orElse(null)));

        entity = publicCustomerVerifyPhoneRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        ProfilePublicCustomerVerifyPhoneModel updated = conversionService.convert(entity, ProfilePublicCustomerVerifyPhoneModel.class);

        return ProfilePublicCustomerVerifyPhoneResponse.Update
            .builder()
            .updated(updated)
            .build();
    }
    
    @Transactional
    public Page<ProfilePublicCustomerVerifyPhoneModel> select(
        ProfilePublicCustomerVerifyPhoneRequest.Context context,
        ProfilePublicCustomerVerifyPhoneRequest.Select request,
        Pageable pageable
    ) {
        ExampleMatcher matcher = ExampleMatcher.matchingAll();

        PublicCustomerVerifyPhoneEntity template = new PublicCustomerVerifyPhoneEntity();
        
        
        Optional.ofNullable(request.getId())
                .ifPresent(optional -> {
                    matcher.withMatcher("id", m -> m.exact());
                    template.setId(optional.orElse(null));
                });
        
        
        matcher.withMatcher("customerId", m -> m.exact());
        template.setCustomerId(context.getCustomerId());
        
        Optional.ofNullable(request.getPhone())
                .ifPresent(optional -> {
                    matcher.withMatcher("phone", m -> m.exact());
                    template.setPhone(optional.orElse(null));
                });
        
        Optional.ofNullable(request.getIsConfirmed())
                .ifPresent(optional -> {
                    matcher.withMatcher("isConfirmed", m -> m.exact());
                    template.setIsConfirmed(optional.orElse(null));
                });

        Example<PublicCustomerVerifyPhoneEntity> example = Example.of(template, matcher);

        return publicCustomerVerifyPhoneRepository
                .findAll(example, pageable)
                .map(item -> conversionService.convert(item, ProfilePublicCustomerVerifyPhoneModel.class));
    }
    
    @Transactional
    public ProfilePublicCustomerVerifyPhoneModel get(
        ProfilePublicCustomerVerifyPhoneRequest.Context context,
        ProfilePublicCustomerVerifyPhoneRequest.Id key
    ) {
        PublicCustomerVerifyPhoneEntity entity = publicCustomerVerifyPhoneRepository
                .findById(key.getId())
                .orElseThrow();
        ProfilePublicCustomerVerifyPhoneModel result = conversionService.convert(entity, ProfilePublicCustomerVerifyPhoneModel.class);
        return result;
    }
}
