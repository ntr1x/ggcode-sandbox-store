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

import com.example.service.basket.entity.PublicFavoriteEntity;
import com.example.service.basket.repository.PublicFavoriteRepository;
import com.example.service.basket.model.profile.ProfilePublicFavoriteModel;
import com.example.service.basket.request.profile.ProfilePublicFavoriteRequest;
import com.example.service.basket.response.profile.ProfilePublicFavoriteResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfilePublicFavoriteService {

    private final PublicFavoriteRepository publicFavoriteRepository;
    private final EntityManager entityManager;
    private final ConversionService conversionService;
    private final EvaluatorService evaluatorService;
    private final GeneratorService generatorService;
    
    @Transactional
    public ProfilePublicFavoriteResponse.Create create(
        ProfilePublicFavoriteRequest.Context context,
        ProfilePublicFavoriteRequest.Create request
    ) {
        PublicFavoriteEntity.PublicFavoriteEntityBuilder builder = PublicFavoriteEntity.builder();
        
        builder.id(generatorService.randomUUID());
        
        builder.customerId(context.getCustomerId());
        Optional.ofNullable(request.getProductId())
                .ifPresent((value) -> builder.productId(value.orElse(null)));

        PublicFavoriteEntity entity = publicFavoriteRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        ProfilePublicFavoriteModel created = conversionService.convert(entity, ProfilePublicFavoriteModel.class);

        return ProfilePublicFavoriteResponse.Create
            .builder()
            .created(created)
            .build();
    }
    
    @Transactional
    public ProfilePublicFavoriteResponse.Remove remove(
        ProfilePublicFavoriteRequest.Context context,
        ProfilePublicFavoriteRequest.Id key
    ) {
        PublicFavoriteEntity entity = publicFavoriteRepository
                .findById(key.getId())
                .orElseThrow();

        ProfilePublicFavoriteModel removed = conversionService.convert(entity, ProfilePublicFavoriteModel.class);

        publicFavoriteRepository.delete(entity);

        return ProfilePublicFavoriteResponse.Remove
            .builder()
            .removed(removed)
            .build();
    }
    
    @Transactional
    public ProfilePublicFavoriteResponse.Update update(
        ProfilePublicFavoriteRequest.Context context,
        ProfilePublicFavoriteRequest.Update request
    ) {
        PublicFavoriteEntity example = PublicFavoriteEntity
                .builder()
                .id(request.getId())
                .customerId(context.getCustomerId())
                .build();

        PublicFavoriteEntity entity = publicFavoriteRepository
                .findOne(Example.of(example))
                .orElseThrow();

        PublicFavoriteEntity.PublicFavoriteEntityBuilder builder = entity.toBuilder();
        
        builder.customerId(context.getCustomerId());
        Optional.ofNullable(request.getProductId())
                .ifPresent((value) -> builder.productId(value.orElse(null)));

        entity = publicFavoriteRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        ProfilePublicFavoriteModel updated = conversionService.convert(entity, ProfilePublicFavoriteModel.class);

        return ProfilePublicFavoriteResponse.Update
            .builder()
            .updated(updated)
            .build();
    }
    
    @Transactional
    public ProfilePublicFavoriteResponse.Replace replace(
        ProfilePublicFavoriteRequest.Context context,
        ProfilePublicFavoriteRequest.Id key,
        ProfilePublicFavoriteRequest.Replace request
    ) {
        PublicFavoriteEntity example = PublicFavoriteEntity
                .builder()
                .id(key.getId())
                .customerId(context.getCustomerId())
                .build();

        PublicFavoriteEntity entity = publicFavoriteRepository
                .findOne(Example.of(example))
                .orElseThrow();

        ProfilePublicFavoriteModel removed = conversionService.convert(entity, ProfilePublicFavoriteModel.class);

        PublicFavoriteEntity.PublicFavoriteEntityBuilder builder = entity.toBuilder();
        
        Optional.ofNullable(request.getId())
                .ifPresent((value) -> builder.id(value.orElse(null)));
        Optional.ofNullable(request.getProductId())
                .ifPresent((value) -> builder.productId(value.orElse(null)));

        entity = publicFavoriteRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        ProfilePublicFavoriteModel created = conversionService.convert(entity, ProfilePublicFavoriteModel.class);

        return ProfilePublicFavoriteResponse.Replace
            .builder()
            .removed(removed)
            .created(created)
            .build();
    }
    
    @Transactional
    public Page<ProfilePublicFavoriteModel> select(
        ProfilePublicFavoriteRequest.Context context,
        ProfilePublicFavoriteRequest.Select request,
        Pageable pageable
    ) {
        ExampleMatcher matcher = ExampleMatcher.matchingAll();

        PublicFavoriteEntity template = new PublicFavoriteEntity();
        
        
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

        Example<PublicFavoriteEntity> example = Example.of(template, matcher);

        return publicFavoriteRepository
                .findAll(example, pageable)
                .map(item -> conversionService.convert(item, ProfilePublicFavoriteModel.class));
    }
    
    @Transactional
    public ProfilePublicFavoriteModel get(
        ProfilePublicFavoriteRequest.Context context,
        ProfilePublicFavoriteRequest.Id key
    ) {
        PublicFavoriteEntity entity = publicFavoriteRepository
                .findById(key.getId())
                .orElseThrow();
        ProfilePublicFavoriteModel result = conversionService.convert(entity, ProfilePublicFavoriteModel.class);
        return result;
    }
}
