package project.Calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.People.Buyer;
import project.Cart.StoreCart;
@Component
public class Calculator {
    @Autowired
    private CostCalculateStrategy costCalculateStrategy;
    @Autowired
    private CostCalculatorVisitor costCalculatorVisitor;

    public Calculator(CostCalculateStrategy costCalculateStrategy, CostCalculatorVisitor costCalculatorVisitor) {
        this.costCalculateStrategy = costCalculateStrategy;
        this.costCalculatorVisitor = costCalculatorVisitor;
    }

    public double calculateCost(Buyer buyer) {
        StoreCart cart = buyer.getCart();
        // Устанавливаем стратегию визитору перед его использованием
        costCalculatorVisitor.setCostCalculateStrategy(costCalculateStrategy);
        costCalculatorVisitor.visit(cart);
        return costCalculatorVisitor.getTotalCost();
    }
}
