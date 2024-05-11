package project.People;

import org.springframework.beans.factory.annotation.Autowired;
import project.Cart.StoreCart;

/*
  Реализация Покупателя
*/
public class Person implements Buyer {
    private final StoreCart cart;

    @Autowired
    public Person(StoreCart cart) {
        this.cart = cart;
    }

    @Override
    public StoreCart getCart() {
        return cart;
    }
}
