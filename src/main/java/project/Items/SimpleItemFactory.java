package project.Items;

import org.springframework.stereotype.Component;

/*
  Паттерн Фабрика, Синглтон
  Реализует интерфейс project.Items.ItemFactory
*/
@Component
public class SimpleItemFactory implements ItemFactory{
    // Единственный экземпляр Фабрики (паттерн Синглтон)
    private static SimpleItemFactory instance;

    // Приватный конструктор
    private SimpleItemFactory() {}

    public static SimpleItemFactory getInstance() {
        if (instance == null) {
            instance = new SimpleItemFactory();
        }
        return instance;
    }

    @Override
    public Item createItem(double price, double weight, String name) {
        return new SimpleItem(price, weight, name);
    }
}
