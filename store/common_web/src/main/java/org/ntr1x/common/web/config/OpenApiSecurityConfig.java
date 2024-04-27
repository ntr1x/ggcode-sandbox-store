package org.ntr1x.common.web.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "Bearer",
        type = SecuritySchemeType.OPENIDCONNECT,
        openIdConnectUrl = "${spring.security.oauth2.resourceserver.jwt.issuer-uri}/.well-known/openid-configuration",
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class OpenApiSecurityConfig {
}
