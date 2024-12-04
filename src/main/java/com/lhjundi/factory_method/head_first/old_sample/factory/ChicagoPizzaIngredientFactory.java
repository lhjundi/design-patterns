package com.lhjundi.factory_method.head_first.old_sample.factory;

import com.lhjundi.factory_method.head_first.old_sample.ingredients.cheese.MozzarellaCheese;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.clams.FrozenClams;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.dough.ThickCrustDough;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.pepperoni.SlicedPepperoni;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.sauce.PlumTomatoSauce;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.sauce.Sauce;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.cheese.Cheese;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.clams.Clams;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.dough.Dough;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.pepperoni.Pepperoni;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.veggies.BlackOlives;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.veggies.EggPlant;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.veggies.Spinach;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.veggies.Veggies;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory{

    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        return new Veggies[]{new BlackOlives(), new Spinach(), new EggPlant()};
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClam() {
        return new FrozenClams();
    }
}
