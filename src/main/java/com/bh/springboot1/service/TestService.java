package com.bh.springboot1.service;

import com.bh.springboot1.anno.CountMetrics;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @CountMetrics
    public String test(Integer num) {
        if (num >0) {
            throw new RuntimeException();
        }else {
            return "ok";
        }
    }
}
