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

import com.example.service.payments.entity.PublicOrderStatusEntity;
import com.example.service.payments.repository.PublicOrderStatusRepository;
import com.example.service.payments.model.anonymous.AnonymousPublicOrderStatusModel;
import com.example.service.payments.request.anonymous.AnonymousPublicOrderStatusRequest;
import com.example.service.payments.response.anonymous.AnonymousPublicOrderStatusResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnonymousPublicOrderStatusService {

    private final PublicOrderStatusRepository publicOrderStatusRepository;
    private final EntityManager entityManager;
    private final ConversionService conversionService;
    private final EvaluatorService evaluatorService;
    private final GeneratorService generatorService;
    
    @Transactional
    public Page<AnonymousPublicOrderStatusModel> select(
        AnonymousPublicOrderStatusRequest.Context context,
        AnonymousPublicOrderStatusRequest.Select request,
        Pageable pageable
    ) {
        ExampleMatcher matcher = ExampleMatcher.matchingAll();

        PublicOrderStatusEntity template = new PublicOrderStatusEntity();
        
        
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

        Example<PublicOrderStatusEntity> example = Example.of(template, matcher);

        return publicOrderStatusRepository
                .findAll(example, pageable)
                .map(item -> conversionService.convert(item, AnonymousPublicOrderStatusModel.class));
    }
    
    @Transactional
    public AnonymousPublicOrderStatusModel get(
        AnonymousPublicOrderStatusRequest.Context context,
        AnonymousPublicOrderStatusRequest.Id key
    ) {
        PublicOrderStatusEntity entity = publicOrderStatusRepository
                .findById(key.getId())
                .orElseThrow();
        AnonymousPublicOrderStatusModel result = conversionService.convert(entity, AnonymousPublicOrderStatusModel.class);
        return result;
    }
}
