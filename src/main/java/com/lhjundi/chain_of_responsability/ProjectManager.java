package com.lhjundi.chain_of_responsability;

public class ProjectManager extends AbstractExpenseHandler{

    public ProjectManager(){
        super(5000.0); // Pode aprovar até $5000
    }

    @Override
    protected void approve(ExpenseRequest request) {
        System.out.println(STR.
                "Project manager aprovou despesa de $ \{request.amount()} para \{request.description()}");
    }

    @Override
    protected void deny(ExpenseRequest request) {
        System.out.println("Despesa negada - necessita aprovação superior");
    }
}
