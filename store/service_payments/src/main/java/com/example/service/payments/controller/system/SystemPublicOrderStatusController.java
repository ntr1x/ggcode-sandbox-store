package com.example.service.payments.controller.system;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

import com.example.service.payments.model.system.SystemPublicOrderStatusModel;
import com.example.service.payments.service.system.SystemPublicOrderStatusService;
import com.example.service.payments.request.system.SystemPublicOrderStatusRequest;
import com.example.service.payments.response.system.SystemPublicOrderStatusResponse;

import org.ntr1x.common.api.views.Views;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@Tag(name = "Dictionaries")
@RequestMapping("/system/public_order_status")
@RequiredArgsConstructor
public class SystemPublicOrderStatusController {

    private final SystemPublicOrderStatusService systemPublicOrderStatusService;
    
    @PostMapping
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Create.class)
    public SystemPublicOrderStatusResponse.Create create(
            @Parameter(hidden = true) SystemPublicOrderStatusRequest.Context context,
            @RequestBody SystemPublicOrderStatusRequest.Create request
    ) {
        return systemPublicOrderStatusService.create(context, request);
    }
    
    @PostMapping("/remove")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Remove.class)
    public SystemPublicOrderStatusResponse.Remove remove(
            @Parameter(hidden = true) SystemPublicOrderStatusRequest.Context context,
            @RequestBody SystemPublicOrderStatusRequest.Id key
    ) {
        return systemPublicOrderStatusService.remove(context, key);
    }
    
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Update.class)
    public SystemPublicOrderStatusResponse.Update update(
            @Parameter(hidden = true) SystemPublicOrderStatusRequest.Context context,
            @RequestBody SystemPublicOrderStatusRequest.Update request
    ) {
        return systemPublicOrderStatusService.update(context, request);
    }
    
    @DeleteMapping("/i/{id}")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Remove.class)
    public SystemPublicOrderStatusResponse.Remove remove(
            @Parameter(hidden = true) SystemPublicOrderStatusRequest.Context context,
            @PathVariable("id") java.util.UUID id
    ) {
        SystemPublicOrderStatusRequest.Id recordKey = SystemPublicOrderStatusRequest.Id.builder()
                .id(id)
                .build();
        return systemPublicOrderStatusService.remove(context, recordKey);
    }
    
    @PutMapping("/i/{id}")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Replace.class)
    public SystemPublicOrderStatusResponse.Replace replace(
            @Parameter(hidden = true) SystemPublicOrderStatusRequest.Context context,
            @PathVariable("id") java.util.UUID id,
            @RequestBody SystemPublicOrderStatusRequest.Replace request
    ) {
        SystemPublicOrderStatusRequest.Id recordKey = SystemPublicOrderStatusRequest.Id.builder()
                .id(id)
                .build();
        return systemPublicOrderStatusService.replace(context, recordKey, request);
    }
    
    @PostMapping("/select")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Select.class)
    public Page<SystemPublicOrderStatusModel> select(
            @Parameter(hidden = true) SystemPublicOrderStatusRequest.Context context,
            @RequestBody SystemPublicOrderStatusRequest.Select request,
            @ParameterObject Pageable pageable
    ) {
        return systemPublicOrderStatusService.select(context, request, pageable);
    }
    
    @GetMapping("/i/{id}")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Select.class)
    public SystemPublicOrderStatusModel get(
            @Parameter(hidden = true) SystemPublicOrderStatusRequest.Context context,
            @PathVariable("id") java.util.UUID id
    ) {
        SystemPublicOrderStatusRequest.Id recordKey = SystemPublicOrderStatusRequest.Id.builder()
                .id(id)
                .build();
        return systemPublicOrderStatusService.get(context, recordKey);
    }
}
