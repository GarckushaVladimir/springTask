package project.Items;

import org.springframework.stereotype.Component;

/*
  Паттерн Фабрика
  Определяет метод создания товара createItem()
*/
@Component
public interface ItemFactory {
    Item createItem(double price, double weight, String name);
}
