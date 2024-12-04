package com.lhjundi.chain_of_responsability;

public abstract class AbstractExpenseHandler implements ExpenseHandler{
    protected ExpenseHandler nextHandler;
    protected double approvalLimit;

    protected AbstractExpenseHandler(double approvalLimit){
        this.approvalLimit = approvalLimit;
    }

    @Override
    public void setNextHandler(ExpenseHandler handler) {
        this.nextHandler = handler;
    }

    @Override
    public void handleExpense(ExpenseRequest request) {
        if (request.amount() <= approvalLimit){
            approve(request);
        } else if (nextHandler != null){
            nextHandler.handleExpense(request);
        } else {
            deny(request);
        }
    }

    protected abstract void approve(ExpenseRequest request);
    protected abstract void deny(ExpenseRequest request);
}
