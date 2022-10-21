package com.micronaut_aerospike.aop;


import io.micronaut.aop.Around;
import io.micronaut.context.annotation.Type;
import io.micronaut.core.annotation.Internal;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Around
@Type(MethodTrackerInterceptor.class)
@Internal
public @interface MethodTracker {

}