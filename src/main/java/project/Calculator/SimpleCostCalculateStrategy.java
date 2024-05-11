package project.Calculator;

import org.springframework.stereotype.Component;
import project.Cart.StoreCart;
import project.People.Buyer;

@Component
public class SimpleCostCalculateStrategy implements CostCalculateStrategy {
    @Override
    public double calculateCost(Buyer buyer) {
        StoreCart cart = buyer.getCart();

        CostCalculatorVisitor visitor = new CostCalculatorVisitor();
        visitor.visit(cart);

        return visitor.getTotalCost();
    }
}
