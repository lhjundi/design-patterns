package com.lhjundi.factory_method.head_first.old_sample.factory;

import com.lhjundi.factory_method.head_first.old_sample.ingredients.sauce.Sauce;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.cheese.Cheese;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.clams.Clams;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.dough.Dough;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.pepperoni.Pepperoni;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.veggies.Veggies;

public interface PizzaIngredientFactory {

    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
    public Pepperoni createPepperoni();
    public Clams createClam();
}
