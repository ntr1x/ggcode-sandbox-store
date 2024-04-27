package com.example.service.payments.controller.anonymous;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

import com.example.service.payments.model.anonymous.AnonymousPublicPaymentTypeModel;
import com.example.service.payments.service.anonymous.AnonymousPublicPaymentTypeService;
import com.example.service.payments.request.anonymous.AnonymousPublicPaymentTypeRequest;
import com.example.service.payments.response.anonymous.AnonymousPublicPaymentTypeResponse;

import org.ntr1x.common.api.views.Views;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@Tag(name = "Public")
@RequestMapping("/anonymous/public_payment_type")
@RequiredArgsConstructor
public class AnonymousPublicPaymentTypeController {

    private final AnonymousPublicPaymentTypeService anonymousPublicPaymentTypeService;
    
    @PostMapping("/select")
    @JsonView(Views.Select.class)
    public Page<AnonymousPublicPaymentTypeModel> select(
            @Parameter(hidden = true) AnonymousPublicPaymentTypeRequest.Context context,
            @RequestBody AnonymousPublicPaymentTypeRequest.Select request,
            @ParameterObject Pageable pageable
    ) {
        return anonymousPublicPaymentTypeService.select(context, request, pageable);
    }
    
    @GetMapping("/i/{id}")
    @JsonView(Views.Select.class)
    public AnonymousPublicPaymentTypeModel get(
            @Parameter(hidden = true) AnonymousPublicPaymentTypeRequest.Context context,
            @PathVariable("id") java.util.UUID id
    ) {
        AnonymousPublicPaymentTypeRequest.Id recordKey = AnonymousPublicPaymentTypeRequest.Id.builder()
                .id(id)
                .build();
        return anonymousPublicPaymentTypeService.get(context, recordKey);
    }
}
