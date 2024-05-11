package project.Calculator;


import project.People.Buyer;

public interface CostCalculateStrategy {
    double calculateCost(Buyer buyer);
}
