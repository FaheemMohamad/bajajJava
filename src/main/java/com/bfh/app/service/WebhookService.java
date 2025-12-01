package com.bfh.app.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class WebhookService {

    private final RestTemplate restTemplate;

    public WebhookService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${bfh.name}")
    private String name;

    @Value("${bfh.email}")
    private String email;

    @Value("${bfh.regno}")
    private String regNo;

    @Value("${bfh.final-query}")
    private String finalQuery;

    private String webhookUrl;
    private String accessToken;

    @PostConstruct
    public void init() {
        generateWebhook();
        sendFinalQuery();
    }

    private void generateWebhook() {
        String url = "https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA";

        Map<String, String> body = new HashMap<>();
        body.put("name", name);
        body.put("regNo", regNo);
        body.put("email", email);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(url, entity, Map.class);

        webhookUrl = (String) response.getBody().get("webhook");
        accessToken = (String) response.getBody().get("accessToken");

        System.out.println("Webhook: " + webhookUrl);
        System.out.println("Token: " + accessToken);
    }

    private void sendFinalQuery() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", accessToken);

        Map<String, String> body = new HashMap<>();
        body.put("finalQuery", finalQuery);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response =
                restTemplate.postForEntity(webhookUrl, entity, String.class);

        System.out.println("Response:");
        System.out.println(response.getBody());
    }
}
