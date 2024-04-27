package com.example.service.basket.controller.profile;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

import com.example.service.basket.model.profile.ProfilePublicFavoriteModel;
import com.example.service.basket.service.profile.ProfilePublicFavoriteService;
import com.example.service.basket.request.profile.ProfilePublicFavoriteRequest;
import com.example.service.basket.response.profile.ProfilePublicFavoriteResponse;

import org.ntr1x.common.api.views.Views;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@Tag(name = "Favorites")
@RequestMapping("/profile/public_favorite")
@RequiredArgsConstructor
public class ProfilePublicFavoriteController {

    private final ProfilePublicFavoriteService profilePublicFavoriteService;
    
    @PostMapping
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Create.class)
    public ProfilePublicFavoriteResponse.Create create(
            @Parameter(hidden = true) ProfilePublicFavoriteRequest.Context context,
            @RequestBody ProfilePublicFavoriteRequest.Create request
    ) {
        return profilePublicFavoriteService.create(context, request);
    }
    
    @PostMapping("/remove")
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Remove.class)
    public ProfilePublicFavoriteResponse.Remove remove(
            @Parameter(hidden = true) ProfilePublicFavoriteRequest.Context context,
            @RequestBody ProfilePublicFavoriteRequest.Id key
    ) {
        return profilePublicFavoriteService.remove(context, key);
    }
    
    @PutMapping("/update")
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Update.class)
    public ProfilePublicFavoriteResponse.Update update(
            @Parameter(hidden = true) ProfilePublicFavoriteRequest.Context context,
            @RequestBody ProfilePublicFavoriteRequest.Update request
    ) {
        return profilePublicFavoriteService.update(context, request);
    }
    
    @DeleteMapping("/i/{id}")
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Remove.class)
    public ProfilePublicFavoriteResponse.Remove remove(
            @Parameter(hidden = true) ProfilePublicFavoriteRequest.Context context,
            @PathVariable("id") java.util.UUID id
    ) {
        ProfilePublicFavoriteRequest.Id recordKey = ProfilePublicFavoriteRequest.Id.builder()
                .id(id)
                .build();
        return profilePublicFavoriteService.remove(context, recordKey);
    }
    
    @PutMapping("/i/{id}")
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Replace.class)
    public ProfilePublicFavoriteResponse.Replace replace(
            @Parameter(hidden = true) ProfilePublicFavoriteRequest.Context context,
            @PathVariable("id") java.util.UUID id,
            @RequestBody ProfilePublicFavoriteRequest.Replace request
    ) {
        ProfilePublicFavoriteRequest.Id recordKey = ProfilePublicFavoriteRequest.Id.builder()
                .id(id)
                .build();
        return profilePublicFavoriteService.replace(context, recordKey, request);
    }
    
    @PostMapping("/select")
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Select.class)
    public Page<ProfilePublicFavoriteModel> select(
            @Parameter(hidden = true) ProfilePublicFavoriteRequest.Context context,
            @RequestBody ProfilePublicFavoriteRequest.Select request,
            @ParameterObject Pageable pageable
    ) {
        return profilePublicFavoriteService.select(context, request, pageable);
    }
    
    @GetMapping("/i/{id}")
    @PreAuthorize("isAuthenticated()")
    @SecurityRequirement(name = "Bearer")
    @JsonView(Views.Select.class)
    public ProfilePublicFavoriteModel get(
            @Parameter(hidden = true) ProfilePublicFavoriteRequest.Context context,
            @PathVariable("id") java.util.UUID id
    ) {
        ProfilePublicFavoriteRequest.Id recordKey = ProfilePublicFavoriteRequest.Id.builder()
                .id(id)
                .build();
        return profilePublicFavoriteService.get(context, recordKey);
    }
}
