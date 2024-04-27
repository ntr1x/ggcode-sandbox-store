package com.example.service.catalog.controller.anonymous;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

import com.example.service.catalog.model.anonymous.AnonymousPublicProductModel;
import com.example.service.catalog.service.anonymous.AnonymousPublicProductService;
import com.example.service.catalog.request.anonymous.AnonymousPublicProductRequest;
import com.example.service.catalog.response.anonymous.AnonymousPublicProductResponse;

import org.ntr1x.common.api.views.Views;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@Tag(name = "Public")
@RequestMapping("/anonymous/public_product")
@RequiredArgsConstructor
public class AnonymousPublicProductController {

    private final AnonymousPublicProductService anonymousPublicProductService;
    
    @PostMapping("/select")
    @JsonView(Views.Select.class)
    public Page<AnonymousPublicProductModel> select(
            @Parameter(hidden = true) AnonymousPublicProductRequest.Context context,
            @RequestBody AnonymousPublicProductRequest.Select request,
            @ParameterObject Pageable pageable
    ) {
        return anonymousPublicProductService.select(context, request, pageable);
    }
    
    @GetMapping("/i/{id}")
    @JsonView(Views.Select.class)
    public AnonymousPublicProductModel get(
            @Parameter(hidden = true) AnonymousPublicProductRequest.Context context,
            @PathVariable("id") java.util.UUID id
    ) {
        AnonymousPublicProductRequest.Id recordKey = AnonymousPublicProductRequest.Id.builder()
                .id(id)
                .build();
        return anonymousPublicProductService.get(context, recordKey);
    }
}
