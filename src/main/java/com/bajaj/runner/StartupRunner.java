package com.bajaj.runner;

import com.bajaj.model.WebhookResponse;
import com.bajaj.service.SolutionService;
import com.bajaj.service.WebhookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

  private static final Logger logger = LoggerFactory.getLogger(StartupRunner.class);

  private final WebhookService webhookService;
  private final SolutionService solutionService;

  @Autowired
  public StartupRunner(WebhookService webhookService, SolutionService solutionService) {
    this.webhookService = webhookService;
    this.solutionService = solutionService;
  }

  @Override
  public void run(String... args) throws Exception {
    logger.info("========================================");
    logger.info("Starting Bajaj Java Challenge Application");
    logger.info("========================================");

    try {
      // Step 1: Generate webhook
      logger.info("Step 1: Generating webhook...");
      WebhookResponse webhookResponse = webhookService.generateWebhook();

      if (webhookResponse == null) {
        logger.error("Failed to generate webhook - received null response");
        return;
      }

      String webhookUrl = webhookResponse.getWebhook();
      String accessToken = webhookResponse.getAccessToken();

      logger.info("Webhook URL received: {}", webhookUrl);
      logger.info("Access Token received: {}", accessToken != null ? "***" : "null");

      // Step 2: Submit solution
      logger.info("Step 2: Submitting SQL solution...");
      solutionService.submitSolution(webhookUrl, accessToken);

      logger.info("========================================");
      logger.info("Process completed successfully!");
      logger.info("========================================");

    } catch (Exception e) {
      logger.error("========================================");
      logger.error("Error during execution: {}", e.getMessage(), e);
      logger.error("========================================");
    }
  }
}
