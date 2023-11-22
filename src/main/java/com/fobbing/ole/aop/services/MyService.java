package com.fobbing.ole.aop.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private final Logger logger = LoggerFactory.getLogger(MyService.class);

    public void doSomething(){
        logger.info("Doing Something");
    }
}
