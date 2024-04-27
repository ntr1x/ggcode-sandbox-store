package com.example.service.customers.controller.system;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

import com.example.service.customers.model.system.SystemPublicCustomerModel;
import com.example.service.customers.service.system.SystemPublicCustomerService;
import com.example.service.customers.request.system.SystemPublicCustomerRequest;
import com.example.service.customers.response.system.SystemPublicCustomerResponse;

import org.ntr1x.common.api.views.Views;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@Tag(name = "Customers")
@RequestMapping("/system/public_customer")
@RequiredArgsConstructor
public class SystemPublicCustomerController {

    private final SystemPublicCustomerService systemPublicCustomerService;
    
    @PostMapping
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Create.class)
    public SystemPublicCustomerResponse.Create create(
            @Parameter(hidden = true) SystemPublicCustomerRequest.Context context,
            @RequestBody SystemPublicCustomerRequest.Create request
    ) {
        return systemPublicCustomerService.create(context, request);
    }
    
    @PostMapping("/remove")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Remove.class)
    public SystemPublicCustomerResponse.Remove remove(
            @Parameter(hidden = true) SystemPublicCustomerRequest.Context context,
            @RequestBody SystemPublicCustomerRequest.Id key
    ) {
        return systemPublicCustomerService.remove(context, key);
    }
    
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Update.class)
    public SystemPublicCustomerResponse.Update update(
            @Parameter(hidden = true) SystemPublicCustomerRequest.Context context,
            @RequestBody SystemPublicCustomerRequest.Update request
    ) {
        return systemPublicCustomerService.update(context, request);
    }
    
    @DeleteMapping("/i/{id}")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Remove.class)
    public SystemPublicCustomerResponse.Remove remove(
            @Parameter(hidden = true) SystemPublicCustomerRequest.Context context,
            @PathVariable("id") java.util.UUID id
    ) {
        SystemPublicCustomerRequest.Id recordKey = SystemPublicCustomerRequest.Id.builder()
                .id(id)
                .build();
        return systemPublicCustomerService.remove(context, recordKey);
    }
    
    @PutMapping("/i/{id}")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Replace.class)
    public SystemPublicCustomerResponse.Replace replace(
            @Parameter(hidden = true) SystemPublicCustomerRequest.Context context,
            @PathVariable("id") java.util.UUID id,
            @RequestBody SystemPublicCustomerRequest.Replace request
    ) {
        SystemPublicCustomerRequest.Id recordKey = SystemPublicCustomerRequest.Id.builder()
                .id(id)
                .build();
        return systemPublicCustomerService.replace(context, recordKey, request);
    }
    
    @PostMapping("/select")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Select.class)
    public Page<SystemPublicCustomerModel> select(
            @Parameter(hidden = true) SystemPublicCustomerRequest.Context context,
            @RequestBody SystemPublicCustomerRequest.Select request,
            @ParameterObject Pageable pageable
    ) {
        return systemPublicCustomerService.select(context, request, pageable);
    }
    
    @GetMapping("/i/{id}")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Select.class)
    public SystemPublicCustomerModel get(
            @Parameter(hidden = true) SystemPublicCustomerRequest.Context context,
            @PathVariable("id") java.util.UUID id
    ) {
        SystemPublicCustomerRequest.Id recordKey = SystemPublicCustomerRequest.Id.builder()
                .id(id)
                .build();
        return systemPublicCustomerService.get(context, recordKey);
    }
}
