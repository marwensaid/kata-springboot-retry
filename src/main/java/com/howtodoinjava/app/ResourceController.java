package com.howtodoinjava.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

//TODO : class controller
public class ResourceController {

  @Autowired
  BackendAdapter backendAdapter;

  //TODO: path is : "/retryable-operation"
  public ResponseEntity<String> validateSpringRetryCapability(@RequestParam String param1, @RequestParam String param2) {
    String apiResponse = this.backendAdapter.getBackendResponse(param1, param2);
    return ResponseEntity.ok().body(apiResponse);
  }
}
