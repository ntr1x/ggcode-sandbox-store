package com.example.service.payments.controller.system;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

import com.example.service.payments.model.system.SystemPublicPaymentStatusModel;
import com.example.service.payments.service.system.SystemPublicPaymentStatusService;
import com.example.service.payments.request.system.SystemPublicPaymentStatusRequest;
import com.example.service.payments.response.system.SystemPublicPaymentStatusResponse;

import org.ntr1x.common.api.views.Views;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@Tag(name = "Dictionaries")
@RequestMapping("/system/public_payment_status")
@RequiredArgsConstructor
public class SystemPublicPaymentStatusController {

    private final SystemPublicPaymentStatusService systemPublicPaymentStatusService;
    
    @PostMapping
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Create.class)
    public SystemPublicPaymentStatusResponse.Create create(
            @Parameter(hidden = true) SystemPublicPaymentStatusRequest.Context context,
            @RequestBody SystemPublicPaymentStatusRequest.Create request
    ) {
        return systemPublicPaymentStatusService.create(context, request);
    }
    
    @PostMapping("/remove")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Remove.class)
    public SystemPublicPaymentStatusResponse.Remove remove(
            @Parameter(hidden = true) SystemPublicPaymentStatusRequest.Context context,
            @RequestBody SystemPublicPaymentStatusRequest.Id key
    ) {
        return systemPublicPaymentStatusService.remove(context, key);
    }
    
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Update.class)
    public SystemPublicPaymentStatusResponse.Update update(
            @Parameter(hidden = true) SystemPublicPaymentStatusRequest.Context context,
            @RequestBody SystemPublicPaymentStatusRequest.Update request
    ) {
        return systemPublicPaymentStatusService.update(context, request);
    }
    
    @DeleteMapping("/i/{id}")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Remove.class)
    public SystemPublicPaymentStatusResponse.Remove remove(
            @Parameter(hidden = true) SystemPublicPaymentStatusRequest.Context context,
            @PathVariable("id") java.util.UUID id
    ) {
        SystemPublicPaymentStatusRequest.Id recordKey = SystemPublicPaymentStatusRequest.Id.builder()
                .id(id)
                .build();
        return systemPublicPaymentStatusService.remove(context, recordKey);
    }
    
    @PutMapping("/i/{id}")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Replace.class)
    public SystemPublicPaymentStatusResponse.Replace replace(
            @Parameter(hidden = true) SystemPublicPaymentStatusRequest.Context context,
            @PathVariable("id") java.util.UUID id,
            @RequestBody SystemPublicPaymentStatusRequest.Replace request
    ) {
        SystemPublicPaymentStatusRequest.Id recordKey = SystemPublicPaymentStatusRequest.Id.builder()
                .id(id)
                .build();
        return systemPublicPaymentStatusService.replace(context, recordKey, request);
    }
    
    @PostMapping("/select")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Select.class)
    public Page<SystemPublicPaymentStatusModel> select(
            @Parameter(hidden = true) SystemPublicPaymentStatusRequest.Context context,
            @RequestBody SystemPublicPaymentStatusRequest.Select request,
            @ParameterObject Pageable pageable
    ) {
        return systemPublicPaymentStatusService.select(context, request, pageable);
    }
    
    @GetMapping("/i/{id}")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Select.class)
    public SystemPublicPaymentStatusModel get(
            @Parameter(hidden = true) SystemPublicPaymentStatusRequest.Context context,
            @PathVariable("id") java.util.UUID id
    ) {
        SystemPublicPaymentStatusRequest.Id recordKey = SystemPublicPaymentStatusRequest.Id.builder()
                .id(id)
                .build();
        return systemPublicPaymentStatusService.get(context, recordKey);
    }
}
