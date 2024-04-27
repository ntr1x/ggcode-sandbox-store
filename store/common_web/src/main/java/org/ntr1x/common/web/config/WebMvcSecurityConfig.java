package org.ntr1x.common.web.config;

import jakarta.servlet.http.HttpServletRequest;
import org.ntr1x.common.web.security.GrantedAuthoritiesExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationManagerResolver;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.security.oauth2.server.resource.authentication.JwtIssuerAuthenticationManagerResolver;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebMvcSecurityConfig {
    @Bean
    SecurityFilterChain apiSecurity(
            HttpSecurity http,
            AuthenticationManagerResolver<HttpServletRequest> authenticationManagerResolver
    ) throws Exception {
        return http
                .csrf(c -> c.disable())
                .cors(c -> c.disable())
                .authorizeHttpRequests(authorize -> authorize.anyRequest().permitAll())
                .oauth2ResourceServer(oauth2 -> oauth2.authenticationManagerResolver(authenticationManagerResolver))
                .build();
    }

    @Bean
    AuthenticationManagerResolver<HttpServletRequest> tokenAuthenticationManagerResolver(JwtDecoder jwtDecoder) {
        return new JwtIssuerAuthenticationManagerResolver(issuerUri -> externalJwt(jwtDecoder));
    }

    Converter<Jwt, AbstractAuthenticationToken> grantedAuthoritiesExtractor() {
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new GrantedAuthoritiesExtractor());
        return jwtAuthenticationConverter;
    }

    AuthenticationManager externalJwt(JwtDecoder jwtDecoder) {
        JwtAuthenticationProvider authenticationProvider = new JwtAuthenticationProvider(jwtDecoder);
        authenticationProvider.setJwtAuthenticationConverter(grantedAuthoritiesExtractor());
        return new ProviderManager(authenticationProvider);
    }
}
