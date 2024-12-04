package com.lhjundi.factory_method.head_first.old_sample.pizza;

import com.lhjundi.factory_method.head_first.old_sample.factory.PizzaIngredientFactory;

public class ClamPizza extends Pizza{

    PizzaIngredientFactory ingredientFactory;

    public ClamPizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    @Override
    public void prepare() {
        System.out.println(STR."Preparing\{name}");
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        clams = ingredientFactory.createClam();
    }
}
