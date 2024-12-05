package com.lhjundi.refactoring;

public class Rental {
    private int daysRented;
    private ToolItem toolItem;

    public Rental(ToolItem toolItem, int daysRented){
        this.toolItem = toolItem;
        this.daysRented = daysRented;
    }

    public double getCharge(){
        double thisAmount = 0;
        switch (getToolItem().getTool().priceCode()){
            case Tool.REGULAR -> {
                thisAmount += 2;
                if (getDaysRented() > 2)
                    thisAmount += (getDaysRented() -2) * 1.5;
            }
            case Tool.NEW_RELEASE ->
                thisAmount += getDaysRented() * 3;
            case Tool.REFURBISHED -> {
                thisAmount += 1.5;
                if (getDaysRented() > 3)
                    thisAmount += (getDaysRented() -3) * 1.0;
            }
        }
        return thisAmount;
    }

    public int getDaysRented(){
        return daysRented;
    }

    public ToolItem getToolItem(){
        return toolItem;
    }
}
