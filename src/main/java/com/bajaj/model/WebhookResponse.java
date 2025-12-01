package com.bajaj.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WebhookResponse {
  private String webhook;
  private String accessToken;

  public WebhookResponse() {
  }

  public String getWebhook() {
    return webhook;
  }

  public void setWebhook(String webhook) {
    this.webhook = webhook;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  @Override
  public String toString() {
    return "WebhookResponse{" +
        "webhook='" + webhook + '\'' +
        ", accessToken='" + accessToken + '\'' +
        '}';
  }
}
