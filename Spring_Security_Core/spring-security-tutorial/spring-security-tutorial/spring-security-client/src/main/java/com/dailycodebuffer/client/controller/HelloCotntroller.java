package com.dailycodebuffer.client.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloCotntroller {
	@GetMapping("/api/hello")
    public String hello() {
        return "Hello, Welcome to Daily Code Buffer!!";
    }

}
