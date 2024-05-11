package project.Items;


/*
  Реализует товар, имеющий стоимость и вес
*/

public class SimpleItem implements Item {
    private String name;
    private double price;
    private double weight;

    public SimpleItem(double price, double weight, String name) {
        this.price = price;
        this.weight = weight;
        this.name = name;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
