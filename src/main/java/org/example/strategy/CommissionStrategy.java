package org.example.strategy;

import org.example.domain.Sale;

 public interface CommissionStrategy {
    double calculateCommission(Sale sale);
}