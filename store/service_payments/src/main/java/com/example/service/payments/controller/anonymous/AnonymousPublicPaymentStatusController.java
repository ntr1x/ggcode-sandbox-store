package com.example.service.payments.controller.anonymous;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

import com.example.service.payments.model.anonymous.AnonymousPublicPaymentStatusModel;
import com.example.service.payments.service.anonymous.AnonymousPublicPaymentStatusService;
import com.example.service.payments.request.anonymous.AnonymousPublicPaymentStatusRequest;
import com.example.service.payments.response.anonymous.AnonymousPublicPaymentStatusResponse;

import org.ntr1x.common.api.views.Views;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@Tag(name = "Public")
@RequestMapping("/anonymous/public_payment_status")
@RequiredArgsConstructor
public class AnonymousPublicPaymentStatusController {

    private final AnonymousPublicPaymentStatusService anonymousPublicPaymentStatusService;
    
    @PostMapping("/select")
    @JsonView(Views.Select.class)
    public Page<AnonymousPublicPaymentStatusModel> select(
            @Parameter(hidden = true) AnonymousPublicPaymentStatusRequest.Context context,
            @RequestBody AnonymousPublicPaymentStatusRequest.Select request,
            @ParameterObject Pageable pageable
    ) {
        return anonymousPublicPaymentStatusService.select(context, request, pageable);
    }
    
    @GetMapping("/i/{id}")
    @JsonView(Views.Select.class)
    public AnonymousPublicPaymentStatusModel get(
            @Parameter(hidden = true) AnonymousPublicPaymentStatusRequest.Context context,
            @PathVariable("id") java.util.UUID id
    ) {
        AnonymousPublicPaymentStatusRequest.Id recordKey = AnonymousPublicPaymentStatusRequest.Id.builder()
                .id(id)
                .build();
        return anonymousPublicPaymentStatusService.get(context, recordKey);
    }
}
