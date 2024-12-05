package com.lhjundi.refactoring;

public class Tool extends DomainObject{
    public static final int REFURBISHED = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private int priceCode;

    public Tool(String name, int priceCode){
        this.name = name;
        this.priceCode = priceCode;
    }

    public int priceCode(){
        return priceCode;
    }
}
