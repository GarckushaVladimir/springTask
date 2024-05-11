/*
  Используются паттерны: Фабрика, Декоратор, Компоновщик, Итератор, Стратегия, Посетитель, Синглтон
*/

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import project.Calculator.Calculator;
import project.People.Buyer;

public class Main {
    public static void main(String[] args) {
        // Создаем контекст приложения на основе конфигурации AppConfig
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Получаем бины из контекста
        Calculator simpleCalculator = context.getBean("calculator", Calculator.class);
        Calculator improvedCalculator = context.getBean("calculator", Calculator.class);
        Buyer person = context.getBean("person", Buyer.class);

        // Подсчет стоимости с помощью разных калькуляторов
        System.out.println("Total cost with SimpleCalculator: " + simpleCalculator.calculateCost(person));
        System.out.println("Total cost with ImprovedCalculator: " + improvedCalculator.calculateCost(person));
    }
}