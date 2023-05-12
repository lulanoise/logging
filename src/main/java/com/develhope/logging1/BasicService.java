package com.develhope.logging1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BasicService {
    private Logger logger = LoggerFactory.getLogger(BasicService.class);

    public String getWelcome(){
        logger.info("Starting greetings");
        return "Starting greetings...";
    }
}