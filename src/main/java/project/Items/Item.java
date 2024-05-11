package project.Items;

import org.springframework.stereotype.Component;

/*
  Определяет базовый интерфейс для всех товаров
*/
@Component
public interface Item {
    double getPrice();
    double getWeight();
}
