package com.security.CasbinRbac.config;

import com.security.CasbinRbac.CasbinRbacApplication;
import org.casbin.jcasbin.main.Enforcer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class casbinEnforcer {

    @Bean
    public Enforcer enforcer(){
        String resPath= casbinEnforcer.class.getResource("/").getPath();
        Enforcer e = new Enforcer(resPath+"model.conf", resPath+"policy.csv");
        return e;
    }
}