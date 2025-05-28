package com.smita.ums.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HeathController {

    @GetMapping("")
    public String health(){
        return "I AM COOL";
    }
}
