package com.example.service.catalog.service.anonymous;

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

import com.example.service.catalog.entity.PublicProductEntity;
import com.example.service.catalog.repository.PublicProductRepository;
import com.example.service.catalog.model.anonymous.AnonymousPublicProductModel;
import com.example.service.catalog.request.anonymous.AnonymousPublicProductRequest;
import com.example.service.catalog.response.anonymous.AnonymousPublicProductResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnonymousPublicProductService {

    private final PublicProductRepository publicProductRepository;
    private final EntityManager entityManager;
    private final ConversionService conversionService;
    private final EvaluatorService evaluatorService;
    private final GeneratorService generatorService;
    
    @Transactional
    public Page<AnonymousPublicProductModel> select(
        AnonymousPublicProductRequest.Context context,
        AnonymousPublicProductRequest.Select request,
        Pageable pageable
    ) {
        ExampleMatcher matcher = ExampleMatcher.matchingAll();

        PublicProductEntity template = new PublicProductEntity();
        
        
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
        
        Optional.ofNullable(request.getPrice())
                .ifPresent(optional -> {
                    matcher.withMatcher("price", m -> m.exact());
                    template.setPrice(optional.orElse(null));
                });
        
        Optional.ofNullable(request.getCategoryId())
                .ifPresent(optional -> {
                    matcher.withMatcher("categoryId", m -> m.exact());
                    template.setCategoryId(optional.orElse(null));
                });

        Example<PublicProductEntity> example = Example.of(template, matcher);

        return publicProductRepository
                .findAll(example, pageable)
                .map(item -> conversionService.convert(item, AnonymousPublicProductModel.class));
    }
    
    @Transactional
    public AnonymousPublicProductModel get(
        AnonymousPublicProductRequest.Context context,
        AnonymousPublicProductRequest.Id key
    ) {
        PublicProductEntity entity = publicProductRepository
                .findById(key.getId())
                .orElseThrow();
        AnonymousPublicProductModel result = conversionService.convert(entity, AnonymousPublicProductModel.class);
        return result;
    }
}
