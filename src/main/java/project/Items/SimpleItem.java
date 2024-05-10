package project.Items;

import org.springframework.stereotype.Component;

/*
  Реализует товар, имеющий стоимость и вес
*/
@Component
public class SimpleItem implements Item {
    private double price;
    private double weight;

    public SimpleItem(double price, double weight) {
        this.price = price;
        this.weight = weight;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }
}
