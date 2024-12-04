package com.lhjundi.factory_method.head_first.old_sample.factory;

import com.lhjundi.factory_method.head_first.old_sample.ingredients.cheese.Cheese;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.cheese.ReggianoCheese;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.clams.Clams;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.clams.FreshClams;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.dough.Dough;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.dough.ThinCrustDough;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.pepperoni.Pepperoni;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.pepperoni.SlicedPepperoni;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.sauce.MarinaraSauce;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.sauce.Sauce;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.veggies.*;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[] {new Garlic(), new Onion(), new Mushroom(), new RedPepper()};
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FreshClams();
    }
}
