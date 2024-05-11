package project.Items;

import org.springframework.stereotype.Component;

/*
  Паттерн Декоратор
  Реализует интерфейс project.Items.Item, предоставляет возможность добавления скидки
*/
//@Component
public class SailDecorator implements Item{
    private Item item;
    private double sailPercent;

    public SailDecorator(Item item, double sailPercent) {
        this.item = item;
        this.sailPercent = sailPercent;
    }

    @Override
    public double getPrice() {
        return item.getPrice() * (1 - sailPercent);
    }

    @Override
    public double getWeight() {
        return item.getWeight();
    }

    @Override
    public String getName() {
        return item.getName();
    }
}
