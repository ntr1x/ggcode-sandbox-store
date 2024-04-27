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

import com.example.service.catalog.entity.PublicCategoryEntity;
import com.example.service.catalog.repository.PublicCategoryRepository;
import com.example.service.catalog.model.anonymous.AnonymousPublicCategoryModel;
import com.example.service.catalog.request.anonymous.AnonymousPublicCategoryRequest;
import com.example.service.catalog.response.anonymous.AnonymousPublicCategoryResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnonymousPublicCategoryService {

    private final PublicCategoryRepository publicCategoryRepository;
    private final EntityManager entityManager;
    private final ConversionService conversionService;
    private final EvaluatorService evaluatorService;
    private final GeneratorService generatorService;
    
    @Transactional
    public Page<AnonymousPublicCategoryModel> select(
        AnonymousPublicCategoryRequest.Context context,
        AnonymousPublicCategoryRequest.Select request,
        Pageable pageable
    ) {
        ExampleMatcher matcher = ExampleMatcher.matchingAll();

        PublicCategoryEntity template = new PublicCategoryEntity();
        
        
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

        Example<PublicCategoryEntity> example = Example.of(template, matcher);

        return publicCategoryRepository
                .findAll(example, pageable)
                .map(item -> conversionService.convert(item, AnonymousPublicCategoryModel.class));
    }
    
    @Transactional
    public AnonymousPublicCategoryModel get(
        AnonymousPublicCategoryRequest.Context context,
        AnonymousPublicCategoryRequest.Id key
    ) {
        PublicCategoryEntity entity = publicCategoryRepository
                .findById(key.getId())
                .orElseThrow();
        AnonymousPublicCategoryModel result = conversionService.convert(entity, AnonymousPublicCategoryModel.class);
        return result;
    }
}
