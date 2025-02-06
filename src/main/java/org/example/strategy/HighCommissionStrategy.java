package org.example.strategy;

import org.example.domain.Sale;

public class HighCommissionStrategy implements CommissionStrategy {
    @Override
    public double calculateCommission(Sale sale) {
        double totalSale = sale.getTotalAmount();
        return totalSale * 0.10;
    }
}
