package com.lhjundi.factory_method.head_first.new_sample;

public class PepperoniPizza extends Pizza{
    public PepperoniPizza(){
        name = "Pepperoni Pizza";
        dough = "Crust";
        sauce = "Marinara sauce";
        toppings.add("Sliced Pepperoni");
        toppings.add("Sliced Onion");
        toppings.add("Grated parmesan cheese");
    }
}
