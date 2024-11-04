package com.catalyst.aopdemo.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {
    @Before("com.catalyst.aopdemo.aspect.CatalystAopExpressions.forDaoPackageNoGetterSetter()")
    public void logToCloud(){
        System.out.println("\n ====>>> Logging to cloud in async fashion");
    }
}
