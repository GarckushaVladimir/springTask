package logger;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import project.Items.Item;

import java.time.LocalDateTime;

@Aspect
@Component
public class CartLoggingAspect {

    @AfterReturning(value = "execution(project.Cart.StoreCart *.*(..))", returning = "storeCart")
    public void afterCreateCart() {
        System.out.println("[CartLoggingAspect] " + LocalDateTime.now() + "- Cart created");
    }

    @Before("execution(* project.Cart.StoreCart.addItem(..)) && args(item)")
    public void beforeAddItem(Item item) {
        System.out.println("[CartLoggingAspect] " + LocalDateTime.now() + " - Adding item: " + item.getName() + " (price: " + item.getPrice() + ", weight: " + item.getWeight() + ")");
    }

    @AfterReturning("execution(* project.Cart.StoreCart.addItem(..)) && args(item)")
    public void afterAddItem(Item item) {
        System.out.println("[CartLoggingAspect] " + LocalDateTime.now() + " - Item added: " + item.getName() + " (price: " + item.getPrice() + ", weight: " + item.getWeight() + ")");
    }

    @Before("execution(double project.Cart.StoreCart.getTotalWeight())")
    public void beforeGetTotalWeight() {
        System.out.println("[StoreCartAspect] " + LocalDateTime.now() + " - Calling getTotalWeight() method");
    }

    @AfterReturning(value = "execution(double project.Cart.StoreCart.getTotalWeight())", returning = "totalWeight")
    public void afterGetTotalWeight(double totalWeight) {
        System.out.println("[StoreCartAspect] " + LocalDateTime.now() + " - getTotalWeight() method called. Total weight: " + totalWeight);
    }
}
