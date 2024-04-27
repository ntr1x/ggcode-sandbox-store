package com.example.service.payments.controller.profile;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

import com.example.service.payments.model.profile.ProfilePublicPaymentModel;
import com.example.service.payments.service.profile.ProfilePublicPaymentService;
import com.example.service.payments.request.profile.ProfilePublicPaymentRequest;
import com.example.service.payments.response.profile.ProfilePublicPaymentResponse;

import org.ntr1x.common.api.views.Views;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@Tag(name = "Payments")
@RequestMapping("/profile/public_payment")
@RequiredArgsConstructor
public class ProfilePublicPaymentController {

    private final ProfilePublicPaymentService profilePublicPaymentService;
    
    @PostMapping("/select")
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Select.class)
    public Page<ProfilePublicPaymentModel> select(
            @Parameter(hidden = true) ProfilePublicPaymentRequest.Context context,
            @RequestBody ProfilePublicPaymentRequest.Select request,
            @ParameterObject Pageable pageable
    ) {
        return profilePublicPaymentService.select(context, request, pageable);
    }
    
    @GetMapping("/i/{id}")
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Select.class)
    public ProfilePublicPaymentModel get(
            @Parameter(hidden = true) ProfilePublicPaymentRequest.Context context,
            @PathVariable("id") java.util.UUID id
    ) {
        ProfilePublicPaymentRequest.Id recordKey = ProfilePublicPaymentRequest.Id.builder()
                .id(id)
                .build();
        return profilePublicPaymentService.get(context, recordKey);
    }
}
