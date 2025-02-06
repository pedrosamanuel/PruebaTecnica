package org.example.domain;

import lombok.Getter;
import lombok.Setter;
import org.example.strategy.CommissionStrategy;
import org.example.strategy.CommissionStrategyFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Sale {
    private Long saleId;
    private LocalDate date;
    private float total;
    private float commission;
    private Salesman salesman;
    private List<SaleProduct> saleProducts = new ArrayList<>();
    private static Long count = 1L;

    public Sale(LocalDate date, Salesman salesman) {
        this.saleId = count++;
        this.date = date;
        this.salesman = salesman;
    }
    public void addProduct(Product product, int quantity) {
        this.saleProducts.add(new SaleProduct(quantity, product));
    }
    public void closeSale(){
        this.total = (float) this.getTotalAmount();
        CommissionStrategy strategy = CommissionStrategyFactory.getStrategy(this);
        this.commission = (float) strategy.calculateCommission(this);
    }
    public int getTotalProducts() {
        return this.saleProducts.stream().mapToInt(SaleProduct::getQuantity).sum();
    }

    public double getTotalAmount() {
        return this.saleProducts.stream()
                .mapToDouble(sp -> sp.getProduct().getPrice() * sp.getQuantity())
                .sum();
    }
}
