import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import project.Calculator.Calculator;
import project.Calculator.CostCalculateStrategy;
import project.Calculator.ImprovedCostCalculateStrategy;
import project.Calculator.SimpleCostCalculateStrategy;
import project.Cart.StoreCart;
import project.Items.ItemFactory;
import project.People.Person;
import project.Items.SailDecorator;
import project.Items.SimpleItem;
import project.Items.SimpleItemFactory;

@Configuration
@ComponentScan("project")
public class AppConfig {
    @Bean
    public ItemFactory itemFactory() {
        return SimpleItemFactory.getInstance();
    }

    @Bean
    @Scope(value = "prototype") // Установить область действия в prototype
    public SimpleItem simpleItem() { // Предполагая, что SimpleItem находится в пакете 'project.Items'
        return itemFactory().createItem(); // Получить SimpleItem из фабрики
    }

    @Bean
    @Scope(value = "prototype") // Установить область действия в prototype
    public SailDecorator sailDecorator() { // Предполагая, что SailDecorator находится в пакете 'project.SailDecorators'
        return new SailDecorator(); // Заменить на фактическое создание экземпляра класса SailDecorator
    }

    @Bean
    @Scope(value = "prototype") // Установить область действия в prototype
    public StoreCart storeReceipt() { // Предполагая, что StoreReceipt находится в пакете 'project.Receipts'
        return new StoreCart(); // Заменить на фактическое создание экземпляра класса StoreReceipt
    }

    @Bean
    @Scope(value = "prototype") // Установить область действия в prototype
    public Person person() { // Предполагая, что Person находится в пакете 'project.People'
        return new Person(); // Заменить на фактическое создание экземпляра класса Person
    }

    @Bean
    @Scope(value = "prototype") // Установить область действия в prototype
    public Calculator calculator() {
        return new Calculator(); // Заменить на фактическое создание экземпляра класса Calculator
    }

    @Bean
    public CostCalculateStrategy simpleCostCalculatorStrategy() {
        return new SimpleCostCalculateStrategy();
    }

    @Bean
    public CostCalculateStrategy improvedCostCalculateStrategy() {
        return new ImprovedCostCalculateStrategy();
    }
}
