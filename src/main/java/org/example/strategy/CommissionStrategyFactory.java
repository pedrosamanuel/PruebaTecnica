package org.example.strategy;

import org.example.domain.Sale;

public class CommissionStrategyFactory {
    public static CommissionStrategy getStrategy(Sale sale) {
        int totalProducts = sale.getTotalProducts();
        return totalProducts > 2 ? new HighCommissionStrategy() : new LowCommissionStrategy();
    }
}