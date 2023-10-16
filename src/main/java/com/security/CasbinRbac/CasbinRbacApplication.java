package com.security.CasbinRbac;

import org.casbin.jcasbin.main.Enforcer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class CasbinRbacApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasbinRbacApplication.class, args);


		String resPath=CasbinRbacApplication.class.getResource("/").getPath();
		//String path=CasbinRbacApplication.class.getResource("").getPath();
		//String modelPath=resPath+
		System.out.println(resPath+"model.conf");

		//System.out.println(path);
		Enforcer e = new Enforcer(resPath+"model.conf", resPath+"policy.csv");

		String subject="admin";
		String object ="/api/v1/admin";
		String act = "GET" ;

		if(e.enforce(subject,object,act)){
			System.out.println("Sucessfull");
		}else{
			System.out.println("something went wrong");
		}
	}

}
