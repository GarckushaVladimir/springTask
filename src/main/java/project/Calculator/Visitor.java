package project.Calculator;

import project.Cart.StoreCart;  // подключили класс чек

/*
  Паттерн Посетитель
*/

public interface Visitor {
    void visit(StoreCart cart);
}