package com.lhjundi.chain_of_responsability;

public interface ExpenseHandler {
    //Interface base para os handlers

    void setNextHandler(ExpenseHandler handler);
    void handleExpense(ExpenseRequest request);
}
