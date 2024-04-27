package org.ntr1x.common.web.config;

import org.ntr1x.common.api.component.AppConverter;
import org.ntr1x.common.web.component.AppArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired(required = false)
    private List<AppConverter<?, ?>> converters;

    @Autowired(required = false)
    private List<AppArgumentResolver> argumentResolvers;

    @Bean
    public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
        return new Jackson2ObjectMapperBuilder().defaultViewInclusion(true);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        if (converters != null) {
            for (AppConverter converter : converters) {
                registry.addConverter(converter);
            }
        }
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        if (argumentResolvers != null) {
            for (AppArgumentResolver resolver : argumentResolvers) {
                resolvers.add(resolver);
            }
        }
    }
}
