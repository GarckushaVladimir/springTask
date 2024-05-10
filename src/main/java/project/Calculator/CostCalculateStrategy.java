package project.Calculator;

import project.Cart.StoreCart;

public interface CostCalculateStrategy {
    double calculateCost(StoreCart cart);
}
