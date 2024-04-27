package com.example.service.customers.controller.profile;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

import com.example.service.customers.model.profile.ProfilePublicCustomerVerifyEmailModel;
import com.example.service.customers.service.profile.ProfilePublicCustomerVerifyEmailService;
import com.example.service.customers.request.profile.ProfilePublicCustomerVerifyEmailRequest;
import com.example.service.customers.response.profile.ProfilePublicCustomerVerifyEmailResponse;

import org.ntr1x.common.api.views.Views;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@Tag(name = "Customer Profile")
@RequestMapping("/profile/public_customer_verify_email")
@RequiredArgsConstructor
public class ProfilePublicCustomerVerifyEmailController {

    private final ProfilePublicCustomerVerifyEmailService profilePublicCustomerVerifyEmailService;
    
    @PostMapping
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Create.class)
    public ProfilePublicCustomerVerifyEmailResponse.Create create(
            @Parameter(hidden = true) ProfilePublicCustomerVerifyEmailRequest.Context context,
            @RequestBody ProfilePublicCustomerVerifyEmailRequest.Create request
    ) {
        return profilePublicCustomerVerifyEmailService.create(context, request);
    }
    
    @PutMapping("/update")
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Update.class)
    public ProfilePublicCustomerVerifyEmailResponse.Update update(
            @Parameter(hidden = true) ProfilePublicCustomerVerifyEmailRequest.Context context,
            @RequestBody ProfilePublicCustomerVerifyEmailRequest.Update request
    ) {
        return profilePublicCustomerVerifyEmailService.update(context, request);
    }
    
    @DeleteMapping("/i/{id}")
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Remove.class)
    public ProfilePublicCustomerVerifyEmailResponse.Remove remove(
            @Parameter(hidden = true) ProfilePublicCustomerVerifyEmailRequest.Context context,
            @PathVariable("id") java.util.UUID id
    ) {
        ProfilePublicCustomerVerifyEmailRequest.Id recordKey = ProfilePublicCustomerVerifyEmailRequest.Id.builder()
                .id(id)
                .build();
        return profilePublicCustomerVerifyEmailService.remove(context, recordKey);
    }
    
    @PostMapping("/select")
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Select.class)
    public Page<ProfilePublicCustomerVerifyEmailModel> select(
            @Parameter(hidden = true) ProfilePublicCustomerVerifyEmailRequest.Context context,
            @RequestBody ProfilePublicCustomerVerifyEmailRequest.Select request,
            @ParameterObject Pageable pageable
    ) {
        return profilePublicCustomerVerifyEmailService.select(context, request, pageable);
    }
    
    @GetMapping("/i/{id}")
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Select.class)
    public ProfilePublicCustomerVerifyEmailModel get(
            @Parameter(hidden = true) ProfilePublicCustomerVerifyEmailRequest.Context context,
            @PathVariable("id") java.util.UUID id
    ) {
        ProfilePublicCustomerVerifyEmailRequest.Id recordKey = ProfilePublicCustomerVerifyEmailRequest.Id.builder()
                .id(id)
                .build();
        return profilePublicCustomerVerifyEmailService.get(context, recordKey);
    }
}
