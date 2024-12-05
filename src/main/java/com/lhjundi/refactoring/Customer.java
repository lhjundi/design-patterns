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
        List<Rental> rentals = this.rentals;
        String result = STR."Rental Record for \{getName()}\{'\n'}";

        for (Rental each : rentals) {
            double thisAmount = 0;

            //determine amounts for each line
            switch (each.getToolItem().getTool().priceCode()) {
                case Tool.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    break;
                case Tool.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Tool.REFURBISHED:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.0;
                    break;

            }
            totalAmount += thisAmount;

            // add frequent renter points
            frequentRenterPoints++;

            // add bonus for a two-day new release rental
            if ((each.getToolItem().getTool().priceCode() == Tool.NEW_RELEASE) && each.getDaysRented() > 1) frequentRenterPoints++;

            //show figures for this rental
            result += "\t" + each.getToolItem().getTool().getName() + "\t" + String.valueOf(thisAmount) + "\n";

        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;

    }

    public void addRental(Rental arg) {
        rentals.add(arg);
    }

    public void removeRental(Rental arg) {
        rentals.remove(arg);
    }
}
