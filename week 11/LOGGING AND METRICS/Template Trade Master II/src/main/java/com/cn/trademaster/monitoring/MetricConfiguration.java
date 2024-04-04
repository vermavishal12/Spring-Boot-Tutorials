package com.cn.trademaster.monitoring;

import io.micrometer.core.instrument.MeterRegistry;

//Annotate the class with @Configuration annotation
public class MetricConfiguration {

 /**
  1. Create a method public MeterRegistry getMeterRegistry() and do the following:
    a. Create a "CompositeMeterRegistry" object and return it.
    b. Annotate the method with "Bean" annotation.
 **/
   public MeterRegistry getMeterRegistry() {
     return null;
  }

 }
