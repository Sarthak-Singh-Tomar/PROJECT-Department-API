package com.sartech.springboot.project.controller;
import org.apache.tomcat.jni.Global;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


// Created Welcome controller
@RestController
public class WelcomeController {

//    this is verbose right
//    @RequestMapping(value = "/", method = RequestMethod.GET)

//    Instead of RequestMapping we will use GetMapping
    @GetMapping("/")
    public String Welcome() {
        String project = "<h1>SarTech Inc.</h1>";
        return "<h1>Welcome to </h1> " + project;
    }
}
