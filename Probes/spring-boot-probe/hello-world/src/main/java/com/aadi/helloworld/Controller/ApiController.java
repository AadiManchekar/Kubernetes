package com.aadi.helloworld.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

  @GetMapping("/hello")
  public String getMethodName() {
    return "hello-world";
  }
}
