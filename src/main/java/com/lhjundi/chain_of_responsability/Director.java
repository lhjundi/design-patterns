package com.lhjundi.chain_of_responsability;

public class Director extends AbstractExpenseHandler{
    public Director(){
        super(10000.0); // Pode aprovar até $10000
    }

    @Override
    protected void approve(ExpenseRequest request) {
        System.out.println(STR.
                "Director aprovou despesa de $\{request.amount()} para \{request.description()}");
    }

    @Override
    protected void deny(ExpenseRequest request) {
        System.out.println("Despesa negada - valor excede limite máximo de aprovação");
    }
}
