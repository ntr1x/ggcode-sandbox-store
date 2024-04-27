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

import com.example.service.payments.entity.PublicPaymentTypeEntity;
import com.example.service.payments.repository.PublicPaymentTypeRepository;
import com.example.service.payments.model.anonymous.AnonymousPublicPaymentTypeModel;
import com.example.service.payments.request.anonymous.AnonymousPublicPaymentTypeRequest;
import com.example.service.payments.response.anonymous.AnonymousPublicPaymentTypeResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnonymousPublicPaymentTypeService {

    private final PublicPaymentTypeRepository publicPaymentTypeRepository;
    private final EntityManager entityManager;
    private final ConversionService conversionService;
    private final EvaluatorService evaluatorService;
    private final GeneratorService generatorService;
    
    @Transactional
    public Page<AnonymousPublicPaymentTypeModel> select(
        AnonymousPublicPaymentTypeRequest.Context context,
        AnonymousPublicPaymentTypeRequest.Select request,
        Pageable pageable
    ) {
        ExampleMatcher matcher = ExampleMatcher.matchingAll();

        PublicPaymentTypeEntity template = new PublicPaymentTypeEntity();
        
        
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

        Example<PublicPaymentTypeEntity> example = Example.of(template, matcher);

        return publicPaymentTypeRepository
                .findAll(example, pageable)
                .map(item -> conversionService.convert(item, AnonymousPublicPaymentTypeModel.class));
    }
    
    @Transactional
    public AnonymousPublicPaymentTypeModel get(
        AnonymousPublicPaymentTypeRequest.Context context,
        AnonymousPublicPaymentTypeRequest.Id key
    ) {
        PublicPaymentTypeEntity entity = publicPaymentTypeRepository
                .findById(key.getId())
                .orElseThrow();
        AnonymousPublicPaymentTypeModel result = conversionService.convert(entity, AnonymousPublicPaymentTypeModel.class);
        return result;
    }
}
