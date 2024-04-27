package com.example.service.payments.controller.profile;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

import com.example.service.payments.model.profile.ProfilePublicOrderModel;
import com.example.service.payments.service.profile.ProfilePublicOrderService;
import com.example.service.payments.request.profile.ProfilePublicOrderRequest;
import com.example.service.payments.response.profile.ProfilePublicOrderResponse;

import org.ntr1x.common.api.views.Views;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@Tag(name = "Orders")
@RequestMapping("/profile/public_order")
@RequiredArgsConstructor
public class ProfilePublicOrderController {

    private final ProfilePublicOrderService profilePublicOrderService;
    
    @PostMapping
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Create.class)
    public ProfilePublicOrderResponse.Create create(
            @Parameter(hidden = true) ProfilePublicOrderRequest.Context context,
            @RequestBody ProfilePublicOrderRequest.Create request
    ) {
        return profilePublicOrderService.create(context, request);
    }
    
    @PostMapping("/select")
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Select.class)
    public Page<ProfilePublicOrderModel> select(
            @Parameter(hidden = true) ProfilePublicOrderRequest.Context context,
            @RequestBody ProfilePublicOrderRequest.Select request,
            @ParameterObject Pageable pageable
    ) {
        return profilePublicOrderService.select(context, request, pageable);
    }
    
    @GetMapping("/i/{id}")
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Select.class)
    public ProfilePublicOrderModel get(
            @Parameter(hidden = true) ProfilePublicOrderRequest.Context context,
            @PathVariable("id") java.util.UUID id
    ) {
        ProfilePublicOrderRequest.Id recordKey = ProfilePublicOrderRequest.Id.builder()
                .id(id)
                .build();
        return profilePublicOrderService.get(context, recordKey);
    }
}
