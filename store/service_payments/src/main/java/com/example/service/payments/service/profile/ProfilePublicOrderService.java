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

import com.example.service.payments.entity.PublicOrderEntity;
import com.example.service.payments.repository.PublicOrderRepository;
import com.example.service.payments.model.profile.ProfilePublicOrderModel;
import com.example.service.payments.request.profile.ProfilePublicOrderRequest;
import com.example.service.payments.response.profile.ProfilePublicOrderResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfilePublicOrderService {

    private final PublicOrderRepository publicOrderRepository;
    private final EntityManager entityManager;
    private final ConversionService conversionService;
    private final EvaluatorService evaluatorService;
    private final GeneratorService generatorService;
    
    @Transactional
    public ProfilePublicOrderResponse.Create create(
        ProfilePublicOrderRequest.Context context,
        ProfilePublicOrderRequest.Create request
    ) {
        PublicOrderEntity.PublicOrderEntityBuilder builder = PublicOrderEntity.builder();
        
        builder.id(generatorService.randomUUID());
        
        builder.customerId(context.getCustomerId());
        Optional.ofNullable(request.getOrderTypeId())
                .ifPresent((value) -> builder.orderTypeId(value.orElse(null)));
        Optional.ofNullable(request.getOrderStatusId())
                .ifPresent((value) -> builder.orderStatusId(value.orElse(null)));
        Optional.ofNullable(request.getCreatedAt())
                .ifPresent((value) -> builder.createdAt(value.orElse(null)));
        Optional.ofNullable(request.getUpdatedAt())
                .ifPresent((value) -> builder.updatedAt(value.orElse(null)));

        PublicOrderEntity entity = publicOrderRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        ProfilePublicOrderModel created = conversionService.convert(entity, ProfilePublicOrderModel.class);

        return ProfilePublicOrderResponse.Create
            .builder()
            .created(created)
            .build();
    }
    
    @Transactional
    public Page<ProfilePublicOrderModel> select(
        ProfilePublicOrderRequest.Context context,
        ProfilePublicOrderRequest.Select request,
        Pageable pageable
    ) {
        ExampleMatcher matcher = ExampleMatcher.matchingAll();

        PublicOrderEntity template = new PublicOrderEntity();
        
        
        Optional.ofNullable(request.getId())
                .ifPresent(optional -> {
                    matcher.withMatcher("id", m -> m.exact());
                    template.setId(optional.orElse(null));
                });
        
        
        matcher.withMatcher("customerId", m -> m.exact());
        template.setCustomerId(context.getCustomerId());
        
        Optional.ofNullable(request.getOrderTypeId())
                .ifPresent(optional -> {
                    matcher.withMatcher("orderTypeId", m -> m.exact());
                    template.setOrderTypeId(optional.orElse(null));
                });
        
        Optional.ofNullable(request.getOrderStatusId())
                .ifPresent(optional -> {
                    matcher.withMatcher("orderStatusId", m -> m.exact());
                    template.setOrderStatusId(optional.orElse(null));
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

        Example<PublicOrderEntity> example = Example.of(template, matcher);

        return publicOrderRepository
                .findAll(example, pageable)
                .map(item -> conversionService.convert(item, ProfilePublicOrderModel.class));
    }
    
    @Transactional
    public ProfilePublicOrderModel get(
        ProfilePublicOrderRequest.Context context,
        ProfilePublicOrderRequest.Id key
    ) {
        PublicOrderEntity entity = publicOrderRepository
                .findById(key.getId())
                .orElseThrow();
        ProfilePublicOrderModel result = conversionService.convert(entity, ProfilePublicOrderModel.class);
        return result;
    }
}
