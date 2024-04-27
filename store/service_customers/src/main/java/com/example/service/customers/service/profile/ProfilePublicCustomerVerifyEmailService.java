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

import com.example.service.customers.entity.PublicCustomerVerifyEmailEntity;
import com.example.service.customers.repository.PublicCustomerVerifyEmailRepository;
import com.example.service.customers.model.profile.ProfilePublicCustomerVerifyEmailModel;
import com.example.service.customers.request.profile.ProfilePublicCustomerVerifyEmailRequest;
import com.example.service.customers.response.profile.ProfilePublicCustomerVerifyEmailResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfilePublicCustomerVerifyEmailService {

    private final PublicCustomerVerifyEmailRepository publicCustomerVerifyEmailRepository;
    private final EntityManager entityManager;
    private final ConversionService conversionService;
    private final EvaluatorService evaluatorService;
    private final GeneratorService generatorService;
    
    @Transactional
    @Event(topic = "verify_email", type = "created", source = "service:service_customers", payloadEl = "#result.created")
    public ProfilePublicCustomerVerifyEmailResponse.Create create(
        ProfilePublicCustomerVerifyEmailRequest.Context context,
        ProfilePublicCustomerVerifyEmailRequest.Create request
    ) {
        PublicCustomerVerifyEmailEntity.PublicCustomerVerifyEmailEntityBuilder builder = PublicCustomerVerifyEmailEntity.builder();
        
        builder.id(generatorService.randomUUID());
        
        builder.customerId(context.getCustomerId());
        Optional.ofNullable(request.getEmail())
                .ifPresent((value) -> builder.email(value.orElse(null)));
        builder.secret(evaluatorService.evaluate("@generatorService.randomString(12)", java.lang.String.class));
        builder.isConfirmed(false);

        PublicCustomerVerifyEmailEntity entity = publicCustomerVerifyEmailRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        ProfilePublicCustomerVerifyEmailModel created = conversionService.convert(entity, ProfilePublicCustomerVerifyEmailModel.class);

        return ProfilePublicCustomerVerifyEmailResponse.Create
            .builder()
            .created(created)
            .build();
    }
    
    @Transactional
    public ProfilePublicCustomerVerifyEmailResponse.Remove remove(
        ProfilePublicCustomerVerifyEmailRequest.Context context,
        ProfilePublicCustomerVerifyEmailRequest.Id key
    ) {
        PublicCustomerVerifyEmailEntity entity = publicCustomerVerifyEmailRepository
                .findById(key.getId())
                .orElseThrow();

        ProfilePublicCustomerVerifyEmailModel removed = conversionService.convert(entity, ProfilePublicCustomerVerifyEmailModel.class);

        publicCustomerVerifyEmailRepository.delete(entity);

        return ProfilePublicCustomerVerifyEmailResponse.Remove
            .builder()
            .removed(removed)
            .build();
    }
    
    @Transactional
    @Event(topic = "update_email", type = "updated", source = "service:service_customers", payloadEl = "#result.updated")
    public ProfilePublicCustomerVerifyEmailResponse.Update update(
        ProfilePublicCustomerVerifyEmailRequest.Context context,
        ProfilePublicCustomerVerifyEmailRequest.Update request
    ) {
        PublicCustomerVerifyEmailEntity example = PublicCustomerVerifyEmailEntity
                .builder()
                .id(request.getId())
                .customerId(context.getCustomerId())
                .build();

        PublicCustomerVerifyEmailEntity entity = publicCustomerVerifyEmailRepository
                .findOne(Example.of(example))
                .orElseThrow();

        PublicCustomerVerifyEmailEntity.PublicCustomerVerifyEmailEntityBuilder builder = entity.toBuilder();
        
        builder.customerId(context.getCustomerId());
        Optional.ofNullable(request.getEmail())
                .ifPresent((value) -> builder.email(value.orElse(null)));
        Optional.ofNullable(request.getSecret())
                .ifPresent((value) -> builder.secret(value.orElse(null)));
        Optional.ofNullable(request.getIsConfirmed())
                .ifPresent((value) -> builder.isConfirmed(value.orElse(null)));

        entity = publicCustomerVerifyEmailRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        ProfilePublicCustomerVerifyEmailModel updated = conversionService.convert(entity, ProfilePublicCustomerVerifyEmailModel.class);

        return ProfilePublicCustomerVerifyEmailResponse.Update
            .builder()
            .updated(updated)
            .build();
    }
    
    @Transactional
    public Page<ProfilePublicCustomerVerifyEmailModel> select(
        ProfilePublicCustomerVerifyEmailRequest.Context context,
        ProfilePublicCustomerVerifyEmailRequest.Select request,
        Pageable pageable
    ) {
        ExampleMatcher matcher = ExampleMatcher.matchingAll();

        PublicCustomerVerifyEmailEntity template = new PublicCustomerVerifyEmailEntity();
        
        
        Optional.ofNullable(request.getId())
                .ifPresent(optional -> {
                    matcher.withMatcher("id", m -> m.exact());
                    template.setId(optional.orElse(null));
                });
        
        
        matcher.withMatcher("customerId", m -> m.exact());
        template.setCustomerId(context.getCustomerId());
        
        Optional.ofNullable(request.getEmail())
                .ifPresent(optional -> {
                    matcher.withMatcher("email", m -> m.exact());
                    template.setEmail(optional.orElse(null));
                });
        
        Optional.ofNullable(request.getIsConfirmed())
                .ifPresent(optional -> {
                    matcher.withMatcher("isConfirmed", m -> m.exact());
                    template.setIsConfirmed(optional.orElse(null));
                });

        Example<PublicCustomerVerifyEmailEntity> example = Example.of(template, matcher);

        return publicCustomerVerifyEmailRepository
                .findAll(example, pageable)
                .map(item -> conversionService.convert(item, ProfilePublicCustomerVerifyEmailModel.class));
    }
    
    @Transactional
    public ProfilePublicCustomerVerifyEmailModel get(
        ProfilePublicCustomerVerifyEmailRequest.Context context,
        ProfilePublicCustomerVerifyEmailRequest.Id key
    ) {
        PublicCustomerVerifyEmailEntity entity = publicCustomerVerifyEmailRepository
                .findById(key.getId())
                .orElseThrow();
        ProfilePublicCustomerVerifyEmailModel result = conversionService.convert(entity, ProfilePublicCustomerVerifyEmailModel.class);
        return result;
    }
}
