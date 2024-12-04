package com.lhjundi.factory_method.head_first.old_sample.pizzaStore;

import com.lhjundi.factory_method.head_first.old_sample.pizza.Pizza;

public abstract class PizzaStore {
    protected abstract Pizza createPizza(String item);

    public Pizza orderPizza(String type){
        Pizza pizza = createPizza(type);
        System.out.println(STR."--- Making a \{pizza.getName()}---");
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
