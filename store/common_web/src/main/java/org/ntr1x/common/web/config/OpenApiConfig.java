package org.ntr1x.common.web.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "${springdoc.api.title}",
        version = "${springdoc.api.version}",
        description = "${springdoc.api.description}"
))
public class OpenApiConfig {
}
