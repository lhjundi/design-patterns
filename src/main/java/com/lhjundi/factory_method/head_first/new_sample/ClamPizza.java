package com.lhjundi.factory_method.head_first.new_sample;

public class ClamPizza extends Pizza{
    public ClamPizza(){
        name = "Clam Pizza";
        dough = "Thin crust";
        sauce = "White garlic sauce";
        toppings.add("Clams");
        toppings.add("Grated parmesan cheese");
    }
}
