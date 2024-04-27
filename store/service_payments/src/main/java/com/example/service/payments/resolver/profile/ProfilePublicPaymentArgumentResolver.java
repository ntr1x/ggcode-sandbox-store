package com.example.service.payments.resolver.profile;

import com.example.service.payments.request.profile.ProfilePublicPaymentRequest;
import org.ntr1x.common.web.component.AppArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.MethodParameter;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.security.Principal;

@Component
public class ProfilePublicPaymentArgumentResolver implements AppArgumentResolver {

    @Autowired @Lazy
    private ConversionService conversionService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return ProfilePublicPaymentRequest.Context.class.equals(parameter.getParameterType());
    }

    @Override
    public ProfilePublicPaymentRequest.Context resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Principal principal = webRequest.getUserPrincipal();

        if (principal instanceof JwtAuthenticationToken token) {
            Jwt jwt = token.getToken();

            return ProfilePublicPaymentRequest.Context
                    .builder()
                    .customerId(conversionService.convert(jwt.getClaim("sub"), java.util.UUID.class))
                    .build();
        }
        return null;
    }
}
