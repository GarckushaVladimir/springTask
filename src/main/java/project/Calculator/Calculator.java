package project.Calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.People.Buyer;
import project.Cart.StoreCart;
@Component
public class Calculator {
    @Autowired
    private CostCalculateStrategy costCalculateStrategy;

    public Calculator(CostCalculateStrategy costCalculateStrategy) {
        this.costCalculateStrategy = costCalculateStrategy;
    }

    public double calculateCost(Buyer buyer) {
        StoreCart cart = buyer.getCart();
        return costCalculateStrategy.calculateCost(cart);
    }
}
