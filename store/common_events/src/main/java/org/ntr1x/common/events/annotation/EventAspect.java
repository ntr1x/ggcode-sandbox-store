package org.ntr1x.common.events.annotation;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cloudevents.CloudEvent;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.ntr1x.common.api.annotation.Event;
import org.ntr1x.common.events.CloudEventsConstants;
import org.ntr1x.common.events.model.CloudEventRoute;
import org.ntr1x.common.events.model.CloudEventTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Aspect
@Component
public class EventAspect {
    public static final ExpressionParser EXPRESSION_PARSER = new SpelExpressionParser();

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    @Qualifier(CloudEventsConstants.KAFKA_TEMPLATE_CLOUD_EVENT)
    private KafkaTemplate<String, CloudEvent> cloudEventKafkaTemplate;

    @Around(value = "@annotation(annotation)", argNames = "annotation")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint, Event annotation) throws Throwable {
        try {
            log.info("Emit cloud event");
            Object result = joinPoint.proceed(joinPoint.getArgs());
            log.info("Value: {}", result);
            log.info("Class: {}", result.getClass());

            EvaluationContext evaluationContext = new StandardEvaluationContext();

            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            Object[] args = joinPoint.getArgs();
            String[] parameterNames = signature.getParameterNames();

            Map<String, Object> params = new HashMap<>();
            for (int i = 0; i < args.length; i++) {
                params.put(parameterNames[i], args[i]);
            }

            evaluationContext.setVariable("result", result);
            evaluationContext.setVariable("params", params);

            Boolean isEnabled = ObjectUtils.isEmpty(annotation.conditionEl())
                ? true
                : EXPRESSION_PARSER
                    .parseExpression(annotation.conditionEl())
                    .getValue(evaluationContext, Boolean.class);

            if (isEnabled != null && isEnabled) {

                Object payload = EXPRESSION_PARSER
                        .parseExpression(annotation.payloadEl())
                        .getValue(evaluationContext, Object.class);

                CloudEventRoute.CloudEventRouteBuilder routeBuilder = CloudEventRoute.builder();

                Optional.of(annotation.topic())
                        .map(topic -> topic.isEmpty() ? null : topic)
                        .ifPresent(topic -> routeBuilder.topic(topic));

                Optional.of(annotation.type())
                        .map(type -> type.isEmpty() ? null : type)
                        .ifPresent(type -> routeBuilder.type(type));

                Optional.of(annotation.source())
                        .map(source -> source.isEmpty() ? null : source)
                        .ifPresent(source -> routeBuilder.source(URI.create(source)));

                CloudEventRoute route = routeBuilder.build();

                CloudEventTemplate template = CloudEventTemplate
                        .builder()
                        .objectMapper(objectMapper)
                        .kafkaTemplate(cloudEventKafkaTemplate)
                        .build();

                template.send(payload, route);
            }

            return result;
        } catch (Throwable th) {
            log.error(th.getMessage(), th);
            throw th;
        }
    }
}
