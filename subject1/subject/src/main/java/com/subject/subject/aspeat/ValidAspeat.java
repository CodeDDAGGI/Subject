package com.subject.subject.aspeat;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.validation.BeanPropertyBindingResult;

@Aspect
@Component
public class ValidAspeat {

    @Pointcut("@anotation(com.subject.subject.aspeat.anotation.ValidAop)")
    private void pointCut(){}

    @Around("pointCut")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        Object[] args = proceedingJoinPoint.getArgs();
        BeanPropertyBindingResult bindingResult = null;

        for(Object arg : args) {
            if(arg.getClass() == BeanPropertyBindingResult.class){
                bindingResult = (BeanPropertyBindingResult) arg;
                break;
            }
        }

        return proceedingJoinPoint.proceed();


    }
}
