package org.ntr1x.common.api.config;

import org.ntr1x.common.api.service.EvaluatorService;
import org.ntr1x.common.api.service.GeneratorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonBeanConfig {
    @Bean
    public GeneratorService generatorService() {
        return new GeneratorService();
    }

    @Bean
    public EvaluatorService evaluatorService() {
        return new EvaluatorService();
    }
}
