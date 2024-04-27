package com.example.service.customers.controller.profile;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

import com.example.service.customers.model.profile.ProfilePublicCustomerModel;
import com.example.service.customers.service.profile.ProfilePublicCustomerService;
import com.example.service.customers.request.profile.ProfilePublicCustomerRequest;
import com.example.service.customers.response.profile.ProfilePublicCustomerResponse;

import org.ntr1x.common.api.views.Views;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@Tag(name = "Customer Profile")
@RequestMapping("/profile/public_customer")
@RequiredArgsConstructor
public class ProfilePublicCustomerController {

    private final ProfilePublicCustomerService profilePublicCustomerService;
    
    @PutMapping
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Update.class)
    public ProfilePublicCustomerResponse.Upsert upsert(
            @Parameter(hidden = true) ProfilePublicCustomerRequest.Context context,
            @RequestBody ProfilePublicCustomerRequest.Upsert request
    ) {
        return profilePublicCustomerService.upsert(context, request);
    }
    
    @GetMapping
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Select.class)
    public ProfilePublicCustomerModel find(
            @Parameter(hidden = true) ProfilePublicCustomerRequest.Context context,
            @ParameterObject @ModelAttribute ProfilePublicCustomerRequest.Find request
    ) {
        return profilePublicCustomerService.find(context, request);
    }
}
