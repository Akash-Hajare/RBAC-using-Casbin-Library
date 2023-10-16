package com.security.CasbinRbac.controller;

import org.casbin.jcasbin.main.Enforcer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CasbinController {
    private final Enforcer enforcer;

    public CasbinController(Enforcer enforcer){
        this.enforcer=enforcer;
    }


    @GetMapping("/admin/{user}")
    public ResponseEntity<String> adminMethod(@PathVariable String user) {
        // Define the user and role
        String subject="akash";
        String object ="/api/v1/admin";
        String act = "GET" ;

        boolean hasPermission = enforcer.enforce(user, object, act);
        if (hasPermission) {
            return ResponseEntity.ok("Admin can access this API.");
        } else {
            return ResponseEntity.status(403).body("Access denied.");
        }
    }
}
