package com.example.service.payments.controller.anonymous;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

import com.example.service.payments.model.anonymous.AnonymousPublicOrderStatusModel;
import com.example.service.payments.service.anonymous.AnonymousPublicOrderStatusService;
import com.example.service.payments.request.anonymous.AnonymousPublicOrderStatusRequest;
import com.example.service.payments.response.anonymous.AnonymousPublicOrderStatusResponse;

import org.ntr1x.common.api.views.Views;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@Tag(name = "Public")
@RequestMapping("/anonymous/public_order_status")
@RequiredArgsConstructor
public class AnonymousPublicOrderStatusController {

    private final AnonymousPublicOrderStatusService anonymousPublicOrderStatusService;
    
    @PostMapping("/select")
    @JsonView(Views.Select.class)
    public Page<AnonymousPublicOrderStatusModel> select(
            @Parameter(hidden = true) AnonymousPublicOrderStatusRequest.Context context,
            @RequestBody AnonymousPublicOrderStatusRequest.Select request,
            @ParameterObject Pageable pageable
    ) {
        return anonymousPublicOrderStatusService.select(context, request, pageable);
    }
    
    @GetMapping("/i/{id}")
    @JsonView(Views.Select.class)
    public AnonymousPublicOrderStatusModel get(
            @Parameter(hidden = true) AnonymousPublicOrderStatusRequest.Context context,
            @PathVariable("id") java.util.UUID id
    ) {
        AnonymousPublicOrderStatusRequest.Id recordKey = AnonymousPublicOrderStatusRequest.Id.builder()
                .id(id)
                .build();
        return anonymousPublicOrderStatusService.get(context, recordKey);
    }
}
