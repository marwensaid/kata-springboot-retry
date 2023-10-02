package com.howtodoinjava.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

//TODO this class is a configuration class enabled to retry
public class RetryConfig {

  @Bean
  public RetryTemplate retryTemplate() {
    RetryTemplate retryTemplate = new RetryTemplate();

    //Fixed delay of 2 seconds between retries
    FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
    fixedBackOffPolicy.setBackOffPeriod(2000L);
    retryTemplate.setBackOffPolicy(fixedBackOffPolicy);

    //Retry only 2 times
    SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy();
    retryPolicy.setMaxAttempts(2);
    retryTemplate.setRetryPolicy(retryPolicy);

    return retryTemplate;
  }
}
