package com.develhope.logging1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class BasicController {

    private Logger logger = LoggerFactory.getLogger(BasicController.class);

    @Autowired
    BasicService basicService;

    @GetMapping("/")
    public String greetings(){
        logger.info("Welcome!");
        return basicService.getWelcome(); //Hello
    }

    @Value("${customEnvs.n1}")
    int customEnvs1;
    @Value("${customEnvs.n2}")
    int customEnvs2;

    @GetMapping("/exp")
    public String exp() {

        logger.debug("Starting calculation...");
        double result = Math.pow(customEnvs1, customEnvs2);
        logger.debug("Calculation finished.");
        logger.info("Result: " + result);
        return "Result: " + result;
    }

    @GetMapping("/errors")
    public String getErrors() {
        logger.error("Something went wrong.");
        return "Something went wrong";
    }
}