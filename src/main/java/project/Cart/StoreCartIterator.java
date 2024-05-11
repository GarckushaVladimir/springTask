package project.Cart;
/*
  Паттерн Итератор
  Реализует интерфейс project.Cart.MyIterator, используется для итерации по списку покупок
*/

import org.springframework.stereotype.Component;
import project.Items.Item; // подключили интерфейс товар
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
@Component
public class StoreCartIterator implements Iterator<Item> {
    private final ArrayList<Item> items; // список товаров
    private int index; // индекс текущего элемента

    public StoreCartIterator(ArrayList<Item> items){
        this.items = items;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < items.size();
    }

    @Override
    public Item next() {
        if (!hasNext()){
            throw new NoSuchElementException();
        }
        Item item = items.get(index);
        index++;
        return item;
    }
}
