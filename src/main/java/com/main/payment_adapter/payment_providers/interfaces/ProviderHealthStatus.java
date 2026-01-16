package com.main.payment_adapter.payment_providers.interfaces;

import java.time.LocalDateTime;

/**
 * \n * Provider Health Status\n * Contains health and monitoring information
 * for a payment provider\n
 */
public class ProviderHealthStatus {
    public enum HealthStatus {
        HEALTHY,
        DEGRADED,
        UNHEALTHY,
        UNKNOWN
    }

    private HealthStatus status;
    private String message;
    private LocalDateTime lastChecked;
    private long responseTimeMs;
    private double successRate;
    private int totalTransactions;
    private int failedTransactions;

    public ProviderHealthStatus() {
        this.lastChecked = LocalDateTime.now();
    }

    public ProviderHealthStatus(HealthStatus status) {
        this();
        this.status = status;
    }

    // Getters and Setters
    public HealthStatus getStatus() {
        return status;
    }

    public void setStatus(HealthStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getLastChecked() {
        return lastChecked;
    }

    public void setLastChecked(LocalDateTime lastChecked) {
        this.lastChecked = lastChecked;
    }

    public long getResponseTimeMs() {
        return responseTimeMs;
    }

    public void setResponseTimeMs(long responseTimeMs) {
        this.responseTimeMs = responseTimeMs;
    }

    public double getSuccessRate() {
        return successRate;
    }

    public void setSuccessRate(double successRate) {
        this.successRate = successRate;
    }

    public int getTotalTransactions() {
        return totalTransactions;
    }

    public void setTotalTransactions(int totalTransactions) {
        this.totalTransactions = totalTransactions;
    }

    public int getFailedTransactions() {
        return failedTransactions;
    }

    public void setFailedTransactions(int failedTransactions) {
        this.failedTransactions = failedTransactions;
    }

    public boolean isHealthy() {
        return status == HealthStatus.HEALTHY;
    }
}