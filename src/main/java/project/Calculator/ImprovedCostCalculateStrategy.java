package project.Calculator;

import org.springframework.stereotype.Component;
import project.Items.Item;
import project.Cart.StoreCart;
@Component
public class ImprovedCostCalculateStrategy implements CostCalculateStrategy {
    @Override
    public double calculateCost(StoreCart cart) {
        double totalCost = 0;
        for (Item item : cart) {
            totalCost += item.getPrice();
        }
        return totalCost * 1.13; // С учетом налога 13%
    }
}
