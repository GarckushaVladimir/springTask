package project.Calculator;

import project.Items.Item; // подключили интерфейс товар
import project.Cart.StoreCart;  // подключили класс чек


/*
  Паттерн Стратегия, Посетитель
  Реализует стратегию расчета стоимости покупок в чеке
*/

public class CostCalculatorVisitor implements Visitor{
    private double totalCost = 0;

    // Подсчет общей стомости
    @Override
    public void visit(StoreCart cart) {
        for (Item item : cart) {
            totalCost += item.getPrice();
        }
    }

    public double getTotalCost() {
        return totalCost;
    }
}
