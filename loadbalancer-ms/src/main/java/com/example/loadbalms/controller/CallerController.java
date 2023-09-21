package com.example.loadbalms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/caller")
public class CallerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CallerController.class);

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    Environment environment;
    @Autowired
    RestTemplate template;
    @GetMapping
    public String call() {
        String url = "http://BILL-SERVICE/billms/allbills";
        String callmeResponse = template.getForObject(url, String.class);
        LOGGER.info("Response: {}", callmeResponse);
        return "I'm Caller running on port " + environment.getProperty("local.server.port")
                + " calling-> " + callmeResponse;
    }
    @GetMapping("/invoke-service")
    public String invokeService() {
        // Choose a service instance by its service name
        ServiceInstance instance = loadBalancerClient.choose("BILL-SERVICE");
        LOGGER.info("instance Host: {}", instance.getHost() + instance.getUri());
        LOGGER.info("instance: {}", instance.getPort() );
        // Perform the request using the instance's URI
        String response = instance.getUri().toString();
        
        return response;
    }

}