package com.example.service.events.controller.system;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

import com.example.service.events.model.system.SystemPublicEventModel;
import com.example.service.events.service.system.SystemPublicEventService;
import com.example.service.events.request.system.SystemPublicEventRequest;
import com.example.service.events.response.system.SystemPublicEventResponse;

import org.ntr1x.common.api.views.Views;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@Tag(name = "Events")
@RequestMapping("/system/public_event")
@RequiredArgsConstructor
public class SystemPublicEventController {

    private final SystemPublicEventService systemPublicEventService;
    
    @PostMapping
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Create.class)
    public SystemPublicEventResponse.Create create(
            @Parameter(hidden = true) SystemPublicEventRequest.Context context,
            @RequestBody SystemPublicEventRequest.Create request
    ) {
        return systemPublicEventService.create(context, request);
    }
    
    @PostMapping("/remove")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Remove.class)
    public SystemPublicEventResponse.Remove remove(
            @Parameter(hidden = true) SystemPublicEventRequest.Context context,
            @RequestBody SystemPublicEventRequest.Id key
    ) {
        return systemPublicEventService.remove(context, key);
    }
    
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Update.class)
    public SystemPublicEventResponse.Update update(
            @Parameter(hidden = true) SystemPublicEventRequest.Context context,
            @RequestBody SystemPublicEventRequest.Update request
    ) {
        return systemPublicEventService.update(context, request);
    }
    
    @DeleteMapping("/i/{id}")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Remove.class)
    public SystemPublicEventResponse.Remove remove(
            @Parameter(hidden = true) SystemPublicEventRequest.Context context,
            @PathVariable("id") java.util.UUID id
    ) {
        SystemPublicEventRequest.Id recordKey = SystemPublicEventRequest.Id.builder()
                .id(id)
                .build();
        return systemPublicEventService.remove(context, recordKey);
    }
    
    @PutMapping("/i/{id}")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Replace.class)
    public SystemPublicEventResponse.Replace replace(
            @Parameter(hidden = true) SystemPublicEventRequest.Context context,
            @PathVariable("id") java.util.UUID id,
            @RequestBody SystemPublicEventRequest.Replace request
    ) {
        SystemPublicEventRequest.Id recordKey = SystemPublicEventRequest.Id.builder()
                .id(id)
                .build();
        return systemPublicEventService.replace(context, recordKey, request);
    }
    
    @PostMapping("/select")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Select.class)
    public Page<SystemPublicEventModel> select(
            @Parameter(hidden = true) SystemPublicEventRequest.Context context,
            @RequestBody SystemPublicEventRequest.Select request,
            @ParameterObject Pageable pageable
    ) {
        return systemPublicEventService.select(context, request, pageable);
    }
    
    @GetMapping("/i/{id}")
    @PreAuthorize("hasAuthority('realm:admin')")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Select.class)
    public SystemPublicEventModel get(
            @Parameter(hidden = true) SystemPublicEventRequest.Context context,
            @PathVariable("id") java.util.UUID id
    ) {
        SystemPublicEventRequest.Id recordKey = SystemPublicEventRequest.Id.builder()
                .id(id)
                .build();
        return systemPublicEventService.get(context, recordKey);
    }
}
