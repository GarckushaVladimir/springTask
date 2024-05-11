package project.Calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import project.Items.Item;
import project.People.Buyer;
import project.Cart.StoreCart;
@Component
public class Calculator {
    private CostCalculateStrategy costCalculateStrategy;
    @Autowired
    public Calculator(CostCalculateStrategy costCalculateStrategy) {
        this.costCalculateStrategy = costCalculateStrategy;
    }

    public double calculateCost(Buyer buyer) {
        return costCalculateStrategy.calculateCost(buyer);
    }
}
