package com.lhjundi.factory_method.head_first.old_sample;

import com.lhjundi.factory_method.head_first.old_sample.pizza.Pizza;
import com.lhjundi.factory_method.head_first.old_sample.pizzaStore.ChicagoPizzaStore;
import com.lhjundi.factory_method.head_first.old_sample.pizzaStore.NYPizzaStore;
import com.lhjundi.factory_method.head_first.old_sample.pizzaStore.PizzaStore;

public class PizzaTestDrive {
    void main(){
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println(STR."""
Ethan ordered a \{pizza}
""");

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println(STR."""
Joel ordered a \{pizza}
""");

        pizza = nyStore.orderPizza("clam");
        System.out.println(STR."""
Ethan ordered a \{pizza}
""");

        pizza = chicagoStore.orderPizza("clam");
        System.out.println(STR."""
Joel ordered a \{pizza}
""");

        pizza = nyStore.orderPizza("pepperoni");
        System.out.println(STR."""
Ethan ordered a \{pizza}
""");

        pizza = chicagoStore.orderPizza("pepperoni");
        System.out.println(STR."""
Joel ordered a \{pizza}
""");

        pizza = nyStore.orderPizza("veggie");
        System.out.println(STR."""
Ethan ordered a \{pizza}
""");

        pizza = chicagoStore.orderPizza("veggie");
        System.out.println(STR."""
Joel ordered a \{pizza}
""");
    }
}
