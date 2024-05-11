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
@ComponentScan(basePackages = {"project", "logger"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig {
    @Bean
    public ItemFactory itemFactory () {
        return SimpleItemFactory.getInstance();
    }
//    @Bean
//    public Item sailDecorator(Item item, @Value("0.5") double percent) {
//        return new SailDecorator(item, percent);
//    }
    @Bean
    @Scope(value = "prototype")
    public StoreCart storeCart() {
        return new StoreCart();
    }
    @Bean
    @Scope(value = "prototype")
    public Buyer buyer(StoreCart cart) {
        return new Person(cart);
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
    @Scope(value = "prototype")
    public Calculator calculator(CostCalculateStrategy costCalculateStrategy) {
        return new Calculator(costCalculateStrategy);
    }

}
