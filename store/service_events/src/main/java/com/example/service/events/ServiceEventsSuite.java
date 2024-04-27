package com.example.service.events;

import com.example.service.events.config.ServiceEventsConfig;
import org.ntr1x.common.api.config.CommonBeanConfig;
import org.ntr1x.common.events.config.CloudEventsBeanConfig;
import org.ntr1x.common.events.config.CloudEventsKafkaConfig;
import org.ntr1x.common.web.config.OpenApiConfig;
import org.ntr1x.common.web.config.OpenApiSecurityConfig;
import org.ntr1x.common.web.config.WebMvcConfig;
import org.ntr1x.common.web.config.WebMvcSecurityConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@Import({
        CommonBeanConfig.class,
        WebMvcConfig.class,
        WebMvcSecurityConfig.class,
        OpenApiConfig.class,
        OpenApiSecurityConfig.class,
        CloudEventsKafkaConfig.class,
        CloudEventsBeanConfig.class
})
@ComponentScan(basePackageClasses = ServiceEventsConfig.class)
@EnableJpaRepositories
public class ServiceEventsSuite {
}
