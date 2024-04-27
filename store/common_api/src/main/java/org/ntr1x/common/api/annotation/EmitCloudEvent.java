package org.ntr1x.common.api.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmitCloudEvent {
    String route() default "";

    String type() default "";

    String payloadEl() default "#result";

    String topic() default "";

    /**
     * URI of the event source
     *
     * @return URI in string representation
     */
    String source() default "";
}
