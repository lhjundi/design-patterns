package com.lhjundi.factory_method.head_first.new_sample;

import java.util.ArrayList;
import java.util.List;

abstract public class Pizza {
    String name;
    String dough;
    String sauce;
    List<String> toppings = new ArrayList<String>();

    public String getName(){
        return name;
    }

    public void prepare(){
        System.out.println(STR."Preparing \{name}");
    }

    public void bake(){
        System.out.println(STR."Baking \{name}");
    }

    public void cut(){
        System.out.println(STR."Cutting \{name}");

    }

    public void box(){
        System.out.println(STR."Boxing \{name}");
    }


    public String toString() {
        // code to display pizza name and ingredients
        StringBuilder display = new StringBuilder();
        display.append("---- ").append(name).append(" ----\n");
        display.append(dough).append("\n");
        display.append(sauce).append("\n");
        for (String topping : toppings) {
            display.append(topping).append("\n");
        }
        return display.toString();
    }
}
