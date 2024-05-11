package project.Calculator;

import org.springframework.stereotype.Component;
import project.Cart.StoreCart;  // подключили класс чек


/*
  Паттерн Стратегия, Посетитель
  Реализует стратегию расчета стоимости покупок в чеке
*/
@Component
public class CostCalculatorVisitor implements Visitor{
    private double totalCost = 0;
    private CostCalculateStrategy costCalculateStrategy;

    public CostCalculatorVisitor() {}

    // Метод для установки стратегии
    public void setCostCalculateStrategy(CostCalculateStrategy costCalculateStrategy) {
        this.costCalculateStrategy = costCalculateStrategy;
    }

    // Подсчет общей стомости
    @Override
    public void visit(StoreCart cart) {
        // Используем стратегию из калькулятора для расчета стоимости
        totalCost = costCalculateStrategy.calculateCost(cart);
    }

    public double getTotalCost() {
        return totalCost;
    }
}
