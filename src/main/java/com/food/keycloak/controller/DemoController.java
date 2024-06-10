package com.food.keycloak.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {

    @GetMapping
    @PreAuthorize("hasRole('client_user')")
    public String hello() {
        return "Hello from Spring boot & Keycloak";
    }

    @GetMapping("/hello-2")
    @PreAuthorize("hasRole('client_admin')")
    public String hello2(Authentication authentication, @AuthenticationPrincipal Jwt jwt) {
//        User user = ((User) authentication.getPrincipal());
//        return "Hello "+ user.getName()+ " from Spring boot & Keycloak - ADMIN";
//        System.out.println("auth-> " + jwt.getClaim("preferred_username"));
        return "Hello "+ authentication.getName()+ " from Spring boot & Keycloak - ADMIN";
    }
}