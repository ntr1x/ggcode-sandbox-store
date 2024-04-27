package com.example.service.payments.controller.anonymous;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

import com.example.service.payments.model.anonymous.AnonymousPublicOrderTypeModel;
import com.example.service.payments.service.anonymous.AnonymousPublicOrderTypeService;
import com.example.service.payments.request.anonymous.AnonymousPublicOrderTypeRequest;
import com.example.service.payments.response.anonymous.AnonymousPublicOrderTypeResponse;

import org.ntr1x.common.api.views.Views;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@Tag(name = "Public")
@RequestMapping("/anonymous/public_order_type")
@RequiredArgsConstructor
public class AnonymousPublicOrderTypeController {

    private final AnonymousPublicOrderTypeService anonymousPublicOrderTypeService;
    
    @PostMapping("/select")
    @JsonView(Views.Select.class)
    public Page<AnonymousPublicOrderTypeModel> select(
            @Parameter(hidden = true) AnonymousPublicOrderTypeRequest.Context context,
            @RequestBody AnonymousPublicOrderTypeRequest.Select request,
            @ParameterObject Pageable pageable
    ) {
        return anonymousPublicOrderTypeService.select(context, request, pageable);
    }
    
    @GetMapping("/i/{id}")
    @JsonView(Views.Select.class)
    public AnonymousPublicOrderTypeModel get(
            @Parameter(hidden = true) AnonymousPublicOrderTypeRequest.Context context,
            @PathVariable("id") java.util.UUID id
    ) {
        AnonymousPublicOrderTypeRequest.Id recordKey = AnonymousPublicOrderTypeRequest.Id.builder()
                .id(id)
                .build();
        return anonymousPublicOrderTypeService.get(context, recordKey);
    }
}
