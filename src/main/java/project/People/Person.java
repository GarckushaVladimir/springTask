package project.People;

import org.springframework.stereotype.Component;
import project.Cart.StoreCart;

/*
  Реализация Покупателя
*/
@Component
public class Person implements Buyer {
    private final StoreCart cart;

    public Person(StoreCart cart) {
        this.cart = cart;
    }

    @Override
    public StoreCart getCart() {
        return cart;
    }
}
