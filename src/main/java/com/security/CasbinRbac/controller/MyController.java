package com.security.CasbinRbac.controller;

import com.security.CasbinRbac.CasbinRbacApplication;
import org.casbin.jcasbin.main.Enforcer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyController {

    private final Enforcer enforcer;
    String resPath= CasbinRbacApplication.class.getResource("/").getPath();

    //@Autowired
    public MyController() {
        this.enforcer = new Enforcer(resPath+"model.conf",resPath+"policy.csv");
        //this.enforcer = new Enforcer(resPath+"model.conf", resPath+"policy.csv");
    }

    @GetMapping("/normal")
    public String normalMethod(){
        return "Im inside normal method";
    }


    // Define other API endpoints here
    @GetMapping("/admin")
    public ResponseEntity<String> adminMethod() {
        // Define the user and role
        String subject="akash";
        String object ="/depts";
        String act = "GET" ;

        boolean hasPermission = enforcer.enforce(subject, object, act);
        if (hasPermission) {
            return ResponseEntity.ok("Admin can access this API.");
        } else {
            return ResponseEntity.status(403).body("Access denied.");
        }
    }

}
