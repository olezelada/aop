package com.fobbing.ole.aop.controllers;

import com.fobbing.ole.aop.services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/aop")
public class MyController {

    @Autowired
    private final MyService service;

    public MyController(MyService service) {
        this.service = service;
    }

    @GetMapping( path = "/example")
    public void example(){
        this.service.doSomething();
    }
}
