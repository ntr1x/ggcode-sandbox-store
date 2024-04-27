package com.example.service.payments.service.anonymous;

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
import com.example.service.payments.model.anonymous.AnonymousPublicOrderTypeModel;
import com.example.service.payments.request.anonymous.AnonymousPublicOrderTypeRequest;
import com.example.service.payments.response.anonymous.AnonymousPublicOrderTypeResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnonymousPublicOrderTypeService {

    private final PublicOrderTypeRepository publicOrderTypeRepository;
    private final EntityManager entityManager;
    private final ConversionService conversionService;
    private final EvaluatorService evaluatorService;
    private final GeneratorService generatorService;
    
    @Transactional
    public Page<AnonymousPublicOrderTypeModel> select(
        AnonymousPublicOrderTypeRequest.Context context,
        AnonymousPublicOrderTypeRequest.Select request,
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
                .map(item -> conversionService.convert(item, AnonymousPublicOrderTypeModel.class));
    }
    
    @Transactional
    public AnonymousPublicOrderTypeModel get(
        AnonymousPublicOrderTypeRequest.Context context,
        AnonymousPublicOrderTypeRequest.Id key
    ) {
        PublicOrderTypeEntity entity = publicOrderTypeRepository
                .findById(key.getId())
                .orElseThrow();
        AnonymousPublicOrderTypeModel result = conversionService.convert(entity, AnonymousPublicOrderTypeModel.class);
        return result;
    }
}
