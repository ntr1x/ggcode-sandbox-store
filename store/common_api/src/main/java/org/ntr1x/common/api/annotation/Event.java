package org.ntr1x.common.api.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Events.class)
public @interface Event {

    String type() default "";

    /**
     * Expression to evaluate payload data
     *
     * @return Expression to evaluate
     */
    String payloadEl() default "#result";

    /**
     * Condition to check before sending an event
     *
     * @return Expression to evaluate
     */
    String conditionEl() default "true";

    String topic() default "";

    /**
     * URI of the event source
     *
     * @return URI in string representation
     */
    String source() default "";
}
