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

import com.example.service.payments.entity.PublicPaymentStatusEntity;
import com.example.service.payments.repository.PublicPaymentStatusRepository;
import com.example.service.payments.model.anonymous.AnonymousPublicPaymentStatusModel;
import com.example.service.payments.request.anonymous.AnonymousPublicPaymentStatusRequest;
import com.example.service.payments.response.anonymous.AnonymousPublicPaymentStatusResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnonymousPublicPaymentStatusService {

    private final PublicPaymentStatusRepository publicPaymentStatusRepository;
    private final EntityManager entityManager;
    private final ConversionService conversionService;
    private final EvaluatorService evaluatorService;
    private final GeneratorService generatorService;
    
    @Transactional
    public Page<AnonymousPublicPaymentStatusModel> select(
        AnonymousPublicPaymentStatusRequest.Context context,
        AnonymousPublicPaymentStatusRequest.Select request,
        Pageable pageable
    ) {
        ExampleMatcher matcher = ExampleMatcher.matchingAll();

        PublicPaymentStatusEntity template = new PublicPaymentStatusEntity();
        
        
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

        Example<PublicPaymentStatusEntity> example = Example.of(template, matcher);

        return publicPaymentStatusRepository
                .findAll(example, pageable)
                .map(item -> conversionService.convert(item, AnonymousPublicPaymentStatusModel.class));
    }
    
    @Transactional
    public AnonymousPublicPaymentStatusModel get(
        AnonymousPublicPaymentStatusRequest.Context context,
        AnonymousPublicPaymentStatusRequest.Id key
    ) {
        PublicPaymentStatusEntity entity = publicPaymentStatusRepository
                .findById(key.getId())
                .orElseThrow();
        AnonymousPublicPaymentStatusModel result = conversionService.convert(entity, AnonymousPublicPaymentStatusModel.class);
        return result;
    }
}
