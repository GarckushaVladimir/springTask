import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import project.Calculator.*;
import project.Cart.StoreCart;
import project.Cart.StoreCartIterator;
import project.Items.*;
import project.People.Person;

import java.util.ArrayList;

@Configuration
@ComponentScan("project")
public class AppConfig {
    @Bean
    public ItemFactory itemFactory() {
        return SimpleItemFactory.getInstance();
    }

    @Bean
    @Scope(value = "singleton")
    public Item simpleItem() {
        return itemFactory().createItem(10.0, 5.0);
    }

    @Bean
    @Scope(value = "prototype")
    public SailDecorator sailDecorator() {
        return new SailDecorator(simpleItem(), 0.5);
    }

    @Bean
    @Scope(value = "prototype")
    public StoreCart storeCart() {
        return new StoreCart();
    }

    @Bean
    @Scope(value = "prototype")
    public Person person() {
        return new Person(storeCart());
    }

    @Bean
    @Scope(value = "prototype")
    public Calculator calculator() {
        return new Calculator(improvedCostCalculateStrategy(), costCalculatorVisitor());
    }

    @Bean
    public CostCalculateStrategy simpleCostCalculateStrategy() {
        return new SimpleCostCalculateStrategy();
    }

    @Bean
    public CostCalculateStrategy improvedCostCalculateStrategy() {
        return new ImprovedCostCalculateStrategy();
    }

    @Bean
    public CostCalculatorVisitor costCalculatorVisitor() {
        return new CostCalculatorVisitor();
    }

    @Bean
    public StoreCartIterator storeCartIterator() {
        return new StoreCartIterator(new ArrayList<>());
    }
}
