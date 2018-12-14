package com.ylt.springsecuritydemo.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy =MyConstraintValidator.class )//标注此注解需要被哪个类处理
public @interface MyConstraint {
    String message() default "{javax.validation.constraints.NotNull.message}";//校验失败时给与的提示

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
