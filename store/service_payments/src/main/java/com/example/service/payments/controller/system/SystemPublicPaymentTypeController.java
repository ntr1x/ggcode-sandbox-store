package com.example.service.payments.controller.system;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

import com.example.service.payments.model.system.SystemPublicPaymentTypeModel;
import com.example.service.payments.service.system.SystemPublicPaymentTypeService;
import com.example.service.payments.request.system.SystemPublicPaymentTypeRequest;
import com.example.service.payments.response.system.SystemPublicPaymentTypeResponse;

import org.ntr1x.common.api.views.Views;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@Tag(name = "Dictionaries")
@RequestMapping("/system/public_payment_type")
@RequiredArgsConstructor
public class SystemPublicPaymentTypeController {

    private final SystemPublicPaymentTypeService systemPublicPaymentTypeService;
    
    @PostMapping
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Create.class)
    public SystemPublicPaymentTypeResponse.Create create(
            @Parameter(hidden = true) SystemPublicPaymentTypeRequest.Context context,
            @RequestBody SystemPublicPaymentTypeRequest.Create request
    ) {
        return systemPublicPaymentTypeService.create(context, request);
    }
    
    @PostMapping("/remove")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Remove.class)
    public SystemPublicPaymentTypeResponse.Remove remove(
            @Parameter(hidden = true) SystemPublicPaymentTypeRequest.Context context,
            @RequestBody SystemPublicPaymentTypeRequest.Id key
    ) {
        return systemPublicPaymentTypeService.remove(context, key);
    }
    
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Update.class)
    public SystemPublicPaymentTypeResponse.Update update(
            @Parameter(hidden = true) SystemPublicPaymentTypeRequest.Context context,
            @RequestBody SystemPublicPaymentTypeRequest.Update request
    ) {
        return systemPublicPaymentTypeService.update(context, request);
    }
    
    @DeleteMapping("/i/{id}")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Remove.class)
    public SystemPublicPaymentTypeResponse.Remove remove(
            @Parameter(hidden = true) SystemPublicPaymentTypeRequest.Context context,
            @PathVariable("id") java.util.UUID id
    ) {
        SystemPublicPaymentTypeRequest.Id recordKey = SystemPublicPaymentTypeRequest.Id.builder()
                .id(id)
                .build();
        return systemPublicPaymentTypeService.remove(context, recordKey);
    }
    
    @PutMapping("/i/{id}")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Replace.class)
    public SystemPublicPaymentTypeResponse.Replace replace(
            @Parameter(hidden = true) SystemPublicPaymentTypeRequest.Context context,
            @PathVariable("id") java.util.UUID id,
            @RequestBody SystemPublicPaymentTypeRequest.Replace request
    ) {
        SystemPublicPaymentTypeRequest.Id recordKey = SystemPublicPaymentTypeRequest.Id.builder()
                .id(id)
                .build();
        return systemPublicPaymentTypeService.replace(context, recordKey, request);
    }
    
    @PostMapping("/select")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Select.class)
    public Page<SystemPublicPaymentTypeModel> select(
            @Parameter(hidden = true) SystemPublicPaymentTypeRequest.Context context,
            @RequestBody SystemPublicPaymentTypeRequest.Select request,
            @ParameterObject Pageable pageable
    ) {
        return systemPublicPaymentTypeService.select(context, request, pageable);
    }
    
    @GetMapping("/i/{id}")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Select.class)
    public SystemPublicPaymentTypeModel get(
            @Parameter(hidden = true) SystemPublicPaymentTypeRequest.Context context,
            @PathVariable("id") java.util.UUID id
    ) {
        SystemPublicPaymentTypeRequest.Id recordKey = SystemPublicPaymentTypeRequest.Id.builder()
                .id(id)
                .build();
        return systemPublicPaymentTypeService.get(context, recordKey);
    }
}
