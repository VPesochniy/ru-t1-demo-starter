package ru.t1.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.t1.demo.config.HttpLoggingProperties;

import java.util.Arrays;

@Aspect
@Component
public class HttpLoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(HttpLoggingAspect.class);
    private final HttpLoggingProperties httpLoggingProperties;

    public HttpLoggingAspect(HttpLoggingProperties httpLoggingProperties) {
        this.httpLoggingProperties = httpLoggingProperties;
    }


    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void restMethod() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void getMapping() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void postMapping() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    public void deleteMapping() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PutMapping)")
    public void putMapping() {
    }


    @Before("restMethod()")
    public void logBeforeControllerMethod(JoinPoint joinPoint) {

        String methodName = joinPoint.getSignature().toLongString();

        logger.info("Accessing method: {}", methodName);
    }


    @AfterReturning(value = "restMethod()", returning = "result")
    public void logAfterControllerMethod(JoinPoint joinPoint, Object result) {

        String methodName = joinPoint.getSignature().toLongString();

        logger.info("Method completed: {}. Returning: {}", methodName, result);
    }

    @AfterThrowing(value = "restMethod()", throwing = "ex")
    public void logAfterControllerMethodException(JoinPoint joinPoint, Exception ex) {

        String methodName = joinPoint.getSignature().toLongString();
        String methodArguments = Arrays.toString(joinPoint.getArgs());

        String exceptionName = ex.getClass().getName();
        String exceptionMessage = ex.getMessage();

        logger.error("Method: {} has thrown: {} ({}) with parameters: {}",
                methodName,
                exceptionName,
                exceptionMessage,
                methodArguments);
    }

}
