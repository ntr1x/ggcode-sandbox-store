package com.example.service.customers.service.profile;

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

import com.example.service.customers.entity.PublicCustomerEntity;
import com.example.service.customers.repository.PublicCustomerRepository;
import com.example.service.customers.model.profile.ProfilePublicCustomerModel;
import com.example.service.customers.request.profile.ProfilePublicCustomerRequest;
import com.example.service.customers.response.profile.ProfilePublicCustomerResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfilePublicCustomerService {

    private final PublicCustomerRepository publicCustomerRepository;
    private final EntityManager entityManager;
    private final ConversionService conversionService;
    private final EvaluatorService evaluatorService;
    private final GeneratorService generatorService;
    
    @Transactional
    @Event(topic = "public_customer", type = "updated", source = "service:service_customers", payloadEl = "#result.updated")
    public ProfilePublicCustomerResponse.Upsert upsert(
        ProfilePublicCustomerRequest.Context context,
        ProfilePublicCustomerRequest.Upsert request
    ) {
        PublicCustomerEntity example = PublicCustomerEntity
                .builder()
                .id(context.getCustomerId())
                .build();

        PublicCustomerEntity entity = publicCustomerRepository
                .findOne(Example.of(example))
                .orElse(example);

        PublicCustomerEntity.PublicCustomerEntityBuilder builder = entity.toBuilder();
        
        Optional.ofNullable(request.getName())
                .ifPresent((value) -> builder.name(value.orElse(null)));

        entity = publicCustomerRepository.saveAndFlush(builder.build());

        entityManager.refresh(entity);

        ProfilePublicCustomerModel updated = conversionService.convert(entity, ProfilePublicCustomerModel.class);

        return ProfilePublicCustomerResponse.Upsert
            .builder()
            .updated(updated)
            .build();
    }
    
    @Transactional
    public ProfilePublicCustomerModel find(
        ProfilePublicCustomerRequest.Context context,
        ProfilePublicCustomerRequest.Find request
    ) {
        ExampleMatcher matcher = ExampleMatcher.matchingAll();

        PublicCustomerEntity template = new PublicCustomerEntity();
        
        
        matcher.withMatcher("id", m -> m.exact());
        template.setId(context.getCustomerId());
        

        Example<PublicCustomerEntity> example = Example.of(template, matcher);

        return publicCustomerRepository
                .findOne(example)
                .map(item -> conversionService.convert(item, ProfilePublicCustomerModel.class))
                .orElse(null);
    }
}
