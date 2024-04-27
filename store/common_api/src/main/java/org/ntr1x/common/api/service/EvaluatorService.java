package org.ntr1x.common.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;

@Service
public class EvaluatorService {
    public static final ExpressionParser EXPRESSION_PARSER = new SpelExpressionParser();

    @Autowired
    private ApplicationContext context;

    public <T> T evaluate(String expression, Class<T> clazz) {
        StandardEvaluationContext evaluationContext = new StandardEvaluationContext();
        evaluationContext.setBeanResolver(new BeanFactoryResolver(context));

        return EXPRESSION_PARSER
                .parseExpression(expression)
                .getValue(evaluationContext, clazz);
    }
}
