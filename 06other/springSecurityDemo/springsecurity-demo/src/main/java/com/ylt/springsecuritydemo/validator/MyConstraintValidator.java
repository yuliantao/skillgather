package com.ylt.springsecuritydemo.validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object> {
    //此处可以使用@Autowired注入不同的服务进行使用，该类也不用@componet，它会自动被注入容器

    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("初始化");
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        //校验逻辑，其中o是传进来的值，constraintValidatorContext是传进来的上下文
        System.out.println(o);
        return false;
    }
}
