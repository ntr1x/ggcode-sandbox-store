package com.example.service.basket.service.profile;

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

import com.example.service.basket.entity.PublicBasketEntryEntity;
import com.example.service.basket.repository.PublicBasketEntryRepository;
import com.example.service.basket.model.profile.ProfilePublicBasketEntryModel;
import com.example.service.basket.request.profile.ProfilePublicBasketEntryRequest;
import com.example.service.basket.response.profile.ProfilePublicBasketEntryResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfilePublicBasketEntryService {

    private final PublicBasketEntryRepository publicBasketEntryRepository;
    private final EntityManager entityManager;
    private final ConversionService conversionService;
    private final EvaluatorService evaluatorService;
    private final GeneratorService generatorService;
    
    @Transactional
    public ProfilePublicBasketEntryResponse.Create create(
        ProfilePublicBasketEntryRequest.Context context,
        ProfilePublicBasketEntryRequest.Create request
    ) {
        PublicBasketEntryEntity.PublicBasketEntryEntityBuilder builder = PublicBasketEntryEntity.builder();
        
        builder.id(generatorService.randomUUID());
        
        builder.customerId(context.getCustomerId());
        Optional.ofNullable(request.getProductId())
                .ifPresent((value) -> builder.productId(value.orElse(null)));
        Optional.ofNullable(request.getQuantity())
                .ifPresent((value) -> builder.quantity(value.orElse(null)));

        PublicBasketEntryEntity entity = publicBasketEntryRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        ProfilePublicBasketEntryModel created = conversionService.convert(entity, ProfilePublicBasketEntryModel.class);

        return ProfilePublicBasketEntryResponse.Create
            .builder()
            .created(created)
            .build();
    }
    
    @Transactional
    public ProfilePublicBasketEntryResponse.Remove remove(
        ProfilePublicBasketEntryRequest.Context context,
        ProfilePublicBasketEntryRequest.Id key
    ) {
        PublicBasketEntryEntity entity = publicBasketEntryRepository
                .findById(key.getId())
                .orElseThrow();

        ProfilePublicBasketEntryModel removed = conversionService.convert(entity, ProfilePublicBasketEntryModel.class);

        publicBasketEntryRepository.delete(entity);

        return ProfilePublicBasketEntryResponse.Remove
            .builder()
            .removed(removed)
            .build();
    }
    
    @Transactional
    public ProfilePublicBasketEntryResponse.Update update(
        ProfilePublicBasketEntryRequest.Context context,
        ProfilePublicBasketEntryRequest.Update request
    ) {
        PublicBasketEntryEntity example = PublicBasketEntryEntity
                .builder()
                .id(request.getId())
                .customerId(context.getCustomerId())
                .build();

        PublicBasketEntryEntity entity = publicBasketEntryRepository
                .findOne(Example.of(example))
                .orElseThrow();

        PublicBasketEntryEntity.PublicBasketEntryEntityBuilder builder = entity.toBuilder();
        
        builder.customerId(context.getCustomerId());
        Optional.ofNullable(request.getProductId())
                .ifPresent((value) -> builder.productId(value.orElse(null)));
        Optional.ofNullable(request.getQuantity())
                .ifPresent((value) -> builder.quantity(value.orElse(null)));

        entity = publicBasketEntryRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        ProfilePublicBasketEntryModel updated = conversionService.convert(entity, ProfilePublicBasketEntryModel.class);

        return ProfilePublicBasketEntryResponse.Update
            .builder()
            .updated(updated)
            .build();
    }
    
    @Transactional
    public ProfilePublicBasketEntryResponse.Replace replace(
        ProfilePublicBasketEntryRequest.Context context,
        ProfilePublicBasketEntryRequest.Id key,
        ProfilePublicBasketEntryRequest.Replace request
    ) {
        PublicBasketEntryEntity example = PublicBasketEntryEntity
                .builder()
                .id(key.getId())
                .customerId(context.getCustomerId())
                .build();

        PublicBasketEntryEntity entity = publicBasketEntryRepository
                .findOne(Example.of(example))
                .orElseThrow();

        ProfilePublicBasketEntryModel removed = conversionService.convert(entity, ProfilePublicBasketEntryModel.class);

        PublicBasketEntryEntity.PublicBasketEntryEntityBuilder builder = entity.toBuilder();
        
        Optional.ofNullable(request.getId())
                .ifPresent((value) -> builder.id(value.orElse(null)));
        Optional.ofNullable(request.getProductId())
                .ifPresent((value) -> builder.productId(value.orElse(null)));
        Optional.ofNullable(request.getQuantity())
                .ifPresent((value) -> builder.quantity(value.orElse(null)));

        entity = publicBasketEntryRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        ProfilePublicBasketEntryModel created = conversionService.convert(entity, ProfilePublicBasketEntryModel.class);

        return ProfilePublicBasketEntryResponse.Replace
            .builder()
            .removed(removed)
            .created(created)
            .build();
    }
    
    @Transactional
    public Page<ProfilePublicBasketEntryModel> select(
        ProfilePublicBasketEntryRequest.Context context,
        ProfilePublicBasketEntryRequest.Select request,
        Pageable pageable
    ) {
        ExampleMatcher matcher = ExampleMatcher.matchingAll();

        PublicBasketEntryEntity template = new PublicBasketEntryEntity();
        
        
        Optional.ofNullable(request.getId())
                .ifPresent(optional -> {
                    matcher.withMatcher("id", m -> m.exact());
                    template.setId(optional.orElse(null));
                });
        
        
        matcher.withMatcher("customerId", m -> m.exact());
        template.setCustomerId(context.getCustomerId());
        
        Optional.ofNullable(request.getProductId())
                .ifPresent(optional -> {
                    matcher.withMatcher("productId", m -> m.exact());
                    template.setProductId(optional.orElse(null));
                });
        
        Optional.ofNullable(request.getQuantity())
                .ifPresent(optional -> {
                    matcher.withMatcher("quantity", m -> m.exact());
                    template.setQuantity(optional.orElse(null));
                });

        Example<PublicBasketEntryEntity> example = Example.of(template, matcher);

        return publicBasketEntryRepository
                .findAll(example, pageable)
                .map(item -> conversionService.convert(item, ProfilePublicBasketEntryModel.class));
    }
    
    @Transactional
    public ProfilePublicBasketEntryModel get(
        ProfilePublicBasketEntryRequest.Context context,
        ProfilePublicBasketEntryRequest.Id key
    ) {
        PublicBasketEntryEntity entity = publicBasketEntryRepository
                .findById(key.getId())
                .orElseThrow();
        ProfilePublicBasketEntryModel result = conversionService.convert(entity, ProfilePublicBasketEntryModel.class);
        return result;
    }
}
