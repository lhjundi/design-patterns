package com.lhjundi.factory_method.head_first.new_sample;

public class PizzaTestDrive {
    void main() {
        SimplePizzaFactory factory = new SimplePizzaFactory();
        PizzaStore store = new PizzaStore(factory);

        Pizza pizza = store.orderPizza("cheese");
        System.out.println(STR."""
We ordered a \{pizza.getName()}
""");
        System.out.println(pizza);

        pizza = store.orderPizza("veggie");
        System.out.println(STR."""
We ordered a \{pizza.getName()}
""");
        System.out.println(pizza);

    }
}
