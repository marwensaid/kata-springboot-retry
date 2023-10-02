package com.howtodoinjava.app;

import org.springframework.retry.annotation.Recover;

public interface BackendAdapter {


  //TODO: use retryable annotation with max 3 times and 1s delay
  public String getBackendResponse(String param1, String param2);

  @Recover
  public String getBackendResponseFallback(RemoteServiceNotAvailableException e, String param1, String param2);
}
