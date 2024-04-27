package com.example.service.payments.service.profile;

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

import com.example.service.payments.entity.PublicPaymentEntity;
import com.example.service.payments.repository.PublicPaymentRepository;
import com.example.service.payments.model.profile.ProfilePublicPaymentModel;
import com.example.service.payments.request.profile.ProfilePublicPaymentRequest;
import com.example.service.payments.response.profile.ProfilePublicPaymentResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfilePublicPaymentService {

    private final PublicPaymentRepository publicPaymentRepository;
    private final EntityManager entityManager;
    private final ConversionService conversionService;
    private final EvaluatorService evaluatorService;
    private final GeneratorService generatorService;
    
    @Transactional
    public Page<ProfilePublicPaymentModel> select(
        ProfilePublicPaymentRequest.Context context,
        ProfilePublicPaymentRequest.Select request,
        Pageable pageable
    ) {
        ExampleMatcher matcher = ExampleMatcher.matchingAll();

        PublicPaymentEntity template = new PublicPaymentEntity();
        
        
        Optional.ofNullable(request.getId())
                .ifPresent(optional -> {
                    matcher.withMatcher("id", m -> m.exact());
                    template.setId(optional.orElse(null));
                });
        
        
        matcher.withMatcher("customerId", m -> m.exact());
        template.setCustomerId(context.getCustomerId());
        
        Optional.ofNullable(request.getOrderId())
                .ifPresent(optional -> {
                    matcher.withMatcher("orderId", m -> m.exact());
                    template.setOrderId(optional.orElse(null));
                });
        
        Optional.ofNullable(request.getPaymentStatusId())
                .ifPresent(optional -> {
                    matcher.withMatcher("paymentStatusId", m -> m.exact());
                    template.setPaymentStatusId(optional.orElse(null));
                });
        
        Optional.ofNullable(request.getPaymentTypeId())
                .ifPresent(optional -> {
                    matcher.withMatcher("paymentTypeId", m -> m.exact());
                    template.setPaymentTypeId(optional.orElse(null));
                });
        
        Optional.ofNullable(request.getValue())
                .ifPresent(optional -> {
                    matcher.withMatcher("value", m -> m.exact());
                    template.setValue(optional.orElse(null));
                });
        
        Optional.ofNullable(request.getCreatedAt())
                .ifPresent(optional -> {
                    matcher.withMatcher("createdAt", m -> m.exact());
                    template.setCreatedAt(optional.orElse(null));
                });
        
        Optional.ofNullable(request.getUpdatedAt())
                .ifPresent(optional -> {
                    matcher.withMatcher("updatedAt", m -> m.exact());
                    template.setUpdatedAt(optional.orElse(null));
                });

        Example<PublicPaymentEntity> example = Example.of(template, matcher);

        return publicPaymentRepository
                .findAll(example, pageable)
                .map(item -> conversionService.convert(item, ProfilePublicPaymentModel.class));
    }
    
    @Transactional
    public ProfilePublicPaymentModel get(
        ProfilePublicPaymentRequest.Context context,
        ProfilePublicPaymentRequest.Id key
    ) {
        PublicPaymentEntity entity = publicPaymentRepository
                .findById(key.getId())
                .orElseThrow();
        ProfilePublicPaymentModel result = conversionService.convert(entity, ProfilePublicPaymentModel.class);
        return result;
    }
}
