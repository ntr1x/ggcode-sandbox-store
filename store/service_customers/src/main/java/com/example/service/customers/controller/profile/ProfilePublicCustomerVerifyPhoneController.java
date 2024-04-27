package com.example.service.customers.controller.profile;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

import com.example.service.customers.model.profile.ProfilePublicCustomerVerifyPhoneModel;
import com.example.service.customers.service.profile.ProfilePublicCustomerVerifyPhoneService;
import com.example.service.customers.request.profile.ProfilePublicCustomerVerifyPhoneRequest;
import com.example.service.customers.response.profile.ProfilePublicCustomerVerifyPhoneResponse;

import org.ntr1x.common.api.views.Views;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@Tag(name = "Customer Profile")
@RequestMapping("/profile/public_customer_verify_phone")
@RequiredArgsConstructor
public class ProfilePublicCustomerVerifyPhoneController {

    private final ProfilePublicCustomerVerifyPhoneService profilePublicCustomerVerifyPhoneService;
    
    @PostMapping
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Create.class)
    public ProfilePublicCustomerVerifyPhoneResponse.Create create(
            @Parameter(hidden = true) ProfilePublicCustomerVerifyPhoneRequest.Context context,
            @RequestBody ProfilePublicCustomerVerifyPhoneRequest.Create request
    ) {
        return profilePublicCustomerVerifyPhoneService.create(context, request);
    }
    
    @PutMapping("/update")
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Update.class)
    public ProfilePublicCustomerVerifyPhoneResponse.Update update(
            @Parameter(hidden = true) ProfilePublicCustomerVerifyPhoneRequest.Context context,
            @RequestBody ProfilePublicCustomerVerifyPhoneRequest.Update request
    ) {
        return profilePublicCustomerVerifyPhoneService.update(context, request);
    }
    
    @DeleteMapping("/i/{id}")
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Remove.class)
    public ProfilePublicCustomerVerifyPhoneResponse.Remove remove(
            @Parameter(hidden = true) ProfilePublicCustomerVerifyPhoneRequest.Context context,
            @PathVariable("id") java.util.UUID id
    ) {
        ProfilePublicCustomerVerifyPhoneRequest.Id recordKey = ProfilePublicCustomerVerifyPhoneRequest.Id.builder()
                .id(id)
                .build();
        return profilePublicCustomerVerifyPhoneService.remove(context, recordKey);
    }
    
    @PostMapping("/select")
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Select.class)
    public Page<ProfilePublicCustomerVerifyPhoneModel> select(
            @Parameter(hidden = true) ProfilePublicCustomerVerifyPhoneRequest.Context context,
            @RequestBody ProfilePublicCustomerVerifyPhoneRequest.Select request,
            @ParameterObject Pageable pageable
    ) {
        return profilePublicCustomerVerifyPhoneService.select(context, request, pageable);
    }
    
    @GetMapping("/i/{id}")
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Select.class)
    public ProfilePublicCustomerVerifyPhoneModel get(
            @Parameter(hidden = true) ProfilePublicCustomerVerifyPhoneRequest.Context context,
            @PathVariable("id") java.util.UUID id
    ) {
        ProfilePublicCustomerVerifyPhoneRequest.Id recordKey = ProfilePublicCustomerVerifyPhoneRequest.Id.builder()
                .id(id)
                .build();
        return profilePublicCustomerVerifyPhoneService.get(context, recordKey);
    }
}
