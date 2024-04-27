package com.example.service.catalog.controller.anonymous;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

import com.example.service.catalog.model.anonymous.AnonymousPublicCategoryModel;
import com.example.service.catalog.service.anonymous.AnonymousPublicCategoryService;
import com.example.service.catalog.request.anonymous.AnonymousPublicCategoryRequest;
import com.example.service.catalog.response.anonymous.AnonymousPublicCategoryResponse;

import org.ntr1x.common.api.views.Views;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@Tag(name = "Public")
@RequestMapping("/anonymous/public_category")
@RequiredArgsConstructor
public class AnonymousPublicCategoryController {

    private final AnonymousPublicCategoryService anonymousPublicCategoryService;
    
    @PostMapping("/select")
    @JsonView(Views.Select.class)
    public Page<AnonymousPublicCategoryModel> select(
            @Parameter(hidden = true) AnonymousPublicCategoryRequest.Context context,
            @RequestBody AnonymousPublicCategoryRequest.Select request,
            @ParameterObject Pageable pageable
    ) {
        return anonymousPublicCategoryService.select(context, request, pageable);
    }
    
    @GetMapping("/i/{id}")
    @JsonView(Views.Select.class)
    public AnonymousPublicCategoryModel get(
            @Parameter(hidden = true) AnonymousPublicCategoryRequest.Context context,
            @PathVariable("id") java.util.UUID id
    ) {
        AnonymousPublicCategoryRequest.Id recordKey = AnonymousPublicCategoryRequest.Id.builder()
                .id(id)
                .build();
        return anonymousPublicCategoryService.get(context, recordKey);
    }
}
