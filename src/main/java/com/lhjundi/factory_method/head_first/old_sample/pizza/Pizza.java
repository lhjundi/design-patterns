package com.lhjundi.factory_method.head_first.old_sample.pizza;

import com.lhjundi.factory_method.head_first.old_sample.ingredients.sauce.Sauce;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.cheese.Cheese;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.clams.Clams;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.dough.Dough;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.pepperoni.Pepperoni;
import com.lhjundi.factory_method.head_first.old_sample.ingredients.veggies.Veggies;

public abstract class Pizza {

    String name;
    Dough dough;
    Sauce sauce;
    Veggies[] veggies;
    Cheese cheese;
    Pepperoni pepperoni;
    Clams clams;

    public abstract void prepare();

    public void bake() {
        System.out.println("Bake fo 25 minutes at 350");
    }

    public void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(STR."----\{name}----");
        if (dough != null) {
            result.append(dough);
            result.append("\n");
        }
        if (sauce != null) {
            result.append(sauce);
            result.append("\n");
        }
        if (cheese != null) {
            result.append(cheese);
            result.append("\n");
        }
        if (veggies != null) {
            for (int i = 0; i < veggies.length; i++) {
                result.append(veggies[i]);
                if (i < veggies.length - 1) {
                    result.append(", ");
                }
            }
            result.append("\n");
        }

        if (clams != null) {
            result.append(clams);
            result.append("\n");
        }

        if (pepperoni != null) {
            result.append(pepperoni);
            result.append("\n");
        }
        return result.toString();
    }
}
