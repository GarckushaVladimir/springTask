package project.Cart;

/*
  Паттерн Компоновщик, Итератор
  Реализует интерфейс project.Cart.Iterable, позволяя перебирать список покупок
*/

import org.springframework.stereotype.Component;
import project.Items.Item; // подключили интерфейс товар
import java.util.ArrayList;
import java.util.Iterator;
@Component
public class StoreCart implements Iterable<Item>{
    // Список товаров в чеке
    private final ArrayList<Item> items;


    public StoreCart() {
        this.items = new ArrayList<>();
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    @Override
    public Iterator<Item> iterator(){
        return new StoreCartIterator(items);
    }

    public double getTotalWeight() {
        double totalWeight = 0;
        for (Item item : items) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }
}
