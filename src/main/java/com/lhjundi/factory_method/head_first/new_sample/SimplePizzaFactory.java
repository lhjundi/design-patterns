package com.lhjundi.factory_method.head_first.new_sample;


public class SimplePizzaFactory {
    public Pizza createPizza(String type){
        Pizza pizza = null;

        if (type.equals("cheese")){
            pizza = new CheesePizza();
        } else if (type.equals("pepperoni")){
            pizza = new PepperoniPizza();
        } else if (type.equals("clam")) {
            pizza = new VeggiePizza();
        }
        return pizza;
    }
}
