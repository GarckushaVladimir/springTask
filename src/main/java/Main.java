/*
  Используются паттерны: Фабрика, Декоратор, Компоновщик, Итератор, Стратегия, Посетитель, Синглтон
*/

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import project.Calculator.Calculator;
import project.Calculator.CostCalculateStrategy;
import project.Cart.StoreCart;
import project.Items.Item;
import project.Items.ItemFactory;
import project.Items.SailDecorator;
import project.People.Buyer;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ItemFactory itemFactory = context.getBean(ItemFactory.class);

        Item item1 = itemFactory.createItem(10, 5);
        Item item2 = itemFactory.createItem(20, 2);


        StoreCart cart = context.getBean(StoreCart.class);

        cart.addItem(item1);
        cart.addItem(item2);

        Buyer buyer = context.getBean(Buyer.class, cart);

//        CostCalculateStrategy simpleCostCalculateStrategy = context.getBean("simpleCostCalculateStrategy", CostCalculateStrategy.class);
//        CostCalculateStrategy improvedCostCalculateStrategy = context.getBean("improvedCostCalculateStrategy", CostCalculateStrategy.class);

        Calculator calculator1 = context.getBean("simpleCalculator", Calculator.class);
        System.out.println("Total cost with SimpleCalculator: " + calculator1.calculateCost(buyer));

        Calculator calculator2 = context.getBean("improvedCalculator", Calculator.class);
        System.out.println("Total cost with SimpleCalculator: " + calculator2.calculateCost(buyer));

        System.out.println("Total weight: " + cart.getTotalWeight());
    }
}