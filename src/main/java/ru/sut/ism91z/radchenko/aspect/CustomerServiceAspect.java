package ru.sut.ism91z.radchenko.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.sut.ism91z.radchenko.model.Customer;

/**
 * This is a demo of how all types of advices work
 */
@Aspect
@Component
public class CustomerServiceAspect {

    private final boolean blockMethodCalls;

    CustomerServiceAspect(@Value("${aspect.interrupt.service.methods.call:false}") boolean blockMethodCalls) {
        this.blockMethodCalls = blockMethodCalls;
    }

    @Pointcut("execution(public * ru.sut.ism91z.radchenko.service.impl.CustomerServiceImpl.*(..))")
    private void callService() { }

    @Before("callService()")
    private void before(JoinPoint joinPoint) {
        System.out.println("BEFORE advice execute start");
        Customer customer = ((Customer) (joinPoint.getArgs()[0]));
        String serviceName = joinPoint.getSignature().getDeclaringTypeName();
        System.out.println("This advice sees that Customer with id = " +
                           customer.getId() + " is provided to service " + serviceName);
        System.out.println("BEFORE advice execute end");
    }

    @AfterReturning(value = "callService()", returning = "result")
    private void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("AFTER RETURNING advice execute start");
        Integer value = (Integer) result;
        System.out.println("This advice sees that returned value is " + value);
        System.out.println("AFTER RETURNING advice execute end");
    }

    @AfterThrowing(value = "callService()", throwing = "throwable")
    private void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
        System.out.println("AFTER THROWING advice execute start");
        System.out.println("This advice sees the throwable message is:");
        System.out.println(throwable.getLocalizedMessage());
        System.out.println("AFTER THROWING advice execute end");
    }

    @Around("callService()")
    private Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("AROUND advice execute start");
        System.out.println("This advice is handling a method call and is able to interrupt it.");
        System.out.println("Current setting is: " + (blockMethodCalls ? "BLOCK" : "ALLOW"));
        System.out.println("AROUND advice execute end");
        if (!blockMethodCalls) {
            return joinPoint.proceed(joinPoint.getArgs());
        }
        return null;
    }
}
