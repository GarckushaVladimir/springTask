package project.People;

/*
  Интерфейс покупателя
*/

import org.springframework.stereotype.Component;
import project.Cart.StoreCart;
@Component
public interface Buyer {
    StoreCart getCart();
}
