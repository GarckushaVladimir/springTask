import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import project.Calculator.Calculator;
import project.Calculator.CostCalculateStrategy;
import project.Calculator.ImprovedCostCalculateStrategy;
import project.Calculator.SimpleCostCalculateStrategy;
import project.Cart.StoreCart;
import project.Items.Item;
import project.Items.ItemFactory;
import project.Items.SailDecorator;
import project.Items.SimpleItemFactory;
import project.People.Buyer;
import project.People.Person;

@Configuration
@ComponentScan(basePackages = {"project"})
public class AppConfig {
    @Bean
    public ItemFactory itemFactory () {
        return SimpleItemFactory.getInstance();
    }

    @Bean
    public Buyer buyer(StoreCart cart) {
        return new Person(cart);
    }

    @Bean
    @Primary // Добавляем эту аннотацию, чтобы указать, что это основной бин
    public CostCalculateStrategy simpleCostCalculateStrategy() {
        return new SimpleCostCalculateStrategy();
    }

    @Bean
    public CostCalculateStrategy improvedCostCalculateStrategy() {
        return new ImprovedCostCalculateStrategy();
    }
    @Bean
    public Calculator simpleCalculator(@Qualifier("simpleCostCalculateStrategy") CostCalculateStrategy costCalculateStrategy) {
        return new Calculator(costCalculateStrategy);
    }

    @Bean
    public Calculator improvedCalculator(@Qualifier("improvedCostCalculateStrategy") CostCalculateStrategy costCalculateStrategy) {
        return new Calculator(costCalculateStrategy);
    }
//    @Bean
//    public Calculator calculator(CostCalculateStrategy costCalculateStrategy) {
//        return new Calculator(costCalculateStrategy);
//    }
    @Bean
    @Scope(value = "prototype")
    public StoreCart storeCart() {
        return new StoreCart();
    }
}
