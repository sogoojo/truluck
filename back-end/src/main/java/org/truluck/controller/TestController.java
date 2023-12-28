package org.truluck.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @GetMapping("/greeting")
  public String greeting(){
    return "Hello from the backend";
  }
}
