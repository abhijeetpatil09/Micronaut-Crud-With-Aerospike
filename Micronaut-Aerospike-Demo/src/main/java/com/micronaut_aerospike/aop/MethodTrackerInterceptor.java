package com.micronaut_aerospike.aop;

import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import jakarta.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;


@Singleton
public class MethodTrackerInterceptor implements MethodInterceptor<Object, Object> {
   private static final Logger LOGGER = LoggerFactory.getLogger(MethodTrackerInterceptor.class);


   private int count = 0;

   @Override
   public Object intercept(MethodInvocationContext<Object, Object> context) {
      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
      Date date = new Date();
      long startTime = System.nanoTime();

      String methodName = context.getMethodName();
      count++;
      try {
         if (methodName == null || methodName.isEmpty()) {
            throw new NullPointerException();
         } else {

            long endTime = System.nanoTime();

            long duration = (endTime - startTime);
            LOGGER.info("Controller entry method::" + methodName + "   calling .." + count);
            LOGGER.info("Entry time of Controller::" + formatter.format(date));
            LOGGER.info("Exit time of Controller" + formatter.format(date));
            LOGGER.info("Total method Execution Time:" + duration + "milliSeconds");
            LOGGER.info("*******************************************************");
            LOGGER.info("*******************************************************");
         }
      } catch (Exception e) {
         e.getMessage();
         e.getStackTrace();
      }
      return context.proceed();
   }
}