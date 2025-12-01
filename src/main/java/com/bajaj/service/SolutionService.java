package com.bajaj.service;

import com.bajaj.model.SolutionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SolutionService {

  private static final Logger logger = LoggerFactory.getLogger(SolutionService.class);

  @Value("${api.base.url}")
  private String baseUrl;

  @Value("${api.submit.webhook}")
  private String submitWebhookPath;

  @Value("${sql.query}")
  private String sqlQuery;

  private final RestTemplate restTemplate;

  public SolutionService() {
    this.restTemplate = new RestTemplate();
  }

  /**
   * Submits the SQL solution to the webhook URL with JWT authentication
   * 
   * @param webhookUrl  The webhook URL to submit the solution to
   * @param accessToken The JWT access token for authentication
   */
  public void submitSolution(String webhookUrl, String accessToken) {
    try {
      String url = baseUrl + submitWebhookPath;
      logger.info("Submitting solution to URL: {}", url);
      logger.debug("SQL Query: {}", sqlQuery);

      // Create request body
      SolutionRequest request = new SolutionRequest(sqlQuery);

      // Set headers with JWT token
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_JSON);
      headers.set("Authorization", accessToken);

      // Create HTTP entity
      HttpEntity<SolutionRequest> entity = new HttpEntity<>(request, headers);

      // Send POST request
      ResponseEntity<String> response = restTemplate.exchange(
          url,
          HttpMethod.POST,
          entity,
          String.class);

      logger.info("Solution submitted successfully. Status: {}", response.getStatusCode());
      logger.info("Response: {}", response.getBody());

    } catch (Exception e) {
      logger.error("Error submitting solution: {}", e.getMessage(), e);
      throw new RuntimeException("Failed to submit solution", e);
    }
  }
}
