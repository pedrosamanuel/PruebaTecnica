package org.example.strategy;

import org.example.domain.Sale;

public class LowCommissionStrategy implements CommissionStrategy {
    @Override
    public double calculateCommission(Sale sale) {
        double totalSales = sale.getTotalAmount();
        return totalSales * 0.05;
    }
}
