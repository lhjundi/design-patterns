package com.lhjundi.chain_of_responsability;

public class TeamLeader extends AbstractExpenseHandler{

    public TeamLeader(){
        super(1000.0); // Pode aprovar até $1000
    }

    @Override
    protected void approve(ExpenseRequest request) {
        System.out.println(STR.
                "Team Leader aprovou despesa de $ \{request.amount()} para \{request.description()}");
    }

    @Override
    protected void deny(ExpenseRequest request) {
        System.out.println("Despesa negada- necessita aprovação superior");
    }
}
