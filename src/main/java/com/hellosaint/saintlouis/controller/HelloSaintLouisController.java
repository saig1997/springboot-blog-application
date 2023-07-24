package com.hellosaint.saintlouis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloSaintLouisController {

    //http://localhost:8080/hello-saint
    @GetMapping("/hello-saint")
    public String helloSaintLouis(){

        return "Hello Saint Louis";
    }
}
