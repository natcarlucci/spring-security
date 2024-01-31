package com.nathalia.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String printMessage() {
        return "Hello, YT!";
    }

    @GetMapping("/admin")
    public String printAdminMessage() {
        return "Hello, Admin!";
    }
}

