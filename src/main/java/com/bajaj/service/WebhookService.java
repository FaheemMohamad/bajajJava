package com.bajaj.service;

import com.bajaj.model.WebhookRequest;
import com.bajaj.model.WebhookResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebhookService {

  private static final Logger logger = LoggerFactory.getLogger(WebhookService.class);

  @Value("${api.base.url}")
  private String baseUrl;

  @Value("${api.generate.webhook}")
  private String generateWebhookPath;

  @Value("${user.name}")
  private String userName;

  @Value("${user.regNo}")
  private String userRegNo;

  @Value("${user.email}")
  private String userEmail;

  private final RestTemplate restTemplate;

  public WebhookService() {
    this.restTemplate = new RestTemplate();
  }

  /**
   * Generates a webhook by sending a POST request to the API
   * 
   * @return WebhookResponse containing webhook URL and access token
   */
  public WebhookResponse generateWebhook() {
    try {
      String url = baseUrl + generateWebhookPath;
      logger.info("Generating webhook at URL: {}", url);

      // Create request body
      WebhookRequest request = new WebhookRequest(userName, userRegNo, userEmail);
      logger.debug("Request payload: {}", request);

      // Set headers
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);

      // Create HTTP entity
      HttpEntity<WebhookRequest> entity = new HttpEntity<>(request, headers);

      // Send POST request
      ResponseEntity<WebhookResponse> response = restTemplate.exchange(
          url,
          HttpMethod.POST,
          entity,
          WebhookResponse.class);

      WebhookResponse webhookResponse = response.getBody();
      logger.info("Webhook generated successfully: {}", webhookResponse);

      return webhookResponse;

    } catch (Exception e) {
      logger.error("Error generating webhook: {}", e.getMessage(), e);
      throw new RuntimeException("Failed to generate webhook", e);
    }
  }
}
