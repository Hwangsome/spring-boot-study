package com.bh.springboot1.controller;

import com.bh.springboot1.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("test/{num}")
    public String test(@PathVariable(name = "num")  Integer num){
        return  testService.test(num);
    }
}
