package com.security.CasbinRbac;

import com.security.CasbinRbac.controller.MyController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = CasbinRbacApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testNormalMethod() {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity("/api/normal", String.class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Im inside normal method", responseEntity.getBody());
    }
}

