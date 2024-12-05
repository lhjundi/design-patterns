package com.lhjundi.refactoring;

import java.util.ArrayList;
import java.util.List;

public class Customer extends DomainObject{

    private final List<Rental> rentals = new ArrayList<>();

    public Customer(String name){
        this.name = name;
    }

    public String statement(){
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder(STR."Rental Record for \{getName()}\{'\n'}");

        for (Rental rental : rentals) {
            totalAmount += rental.getCharge();
            frequentRenterPoints++;

            if((rental.getToolItem().getTool().priceCode() == Tool.NEW_RELEASE)
                && rental.getDaysRented() > 1)
                frequentRenterPoints++;

            result.append(STR."""
                    \t\{rental.getToolItem().getTool().getName()}\t\{rental.getCharge()}
                    """);
        }
        //add footer lines
        result.append("Amount owed is ").append(String.valueOf(totalAmount)).append("\n");
        result.append("You earned ").append(String.valueOf(frequentRenterPoints)).append(" frequent renter points");
        return result.toString();

    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public void removeRental(Rental arg) {
        rentals.remove(arg);
    }
}
