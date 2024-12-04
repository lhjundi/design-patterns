package com.lhjundi.state;

public class NoMoneyState implements VendingMachineState{

    private VendingMachine vendingMachine;

    public NoMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }


    @Override
    public void insertCoin(int amount) {
        vendingMachine.addMoney(amount);
        vendingMachine.setState(new HasMoneyState(vendingMachine));
        System.out.println(STR."Moeda inserida: $\{amount}");
    }

    @Override
    public void selectProduct(String product) {
        System.out.println("Por favor, insira moedas primeiro");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Por favor, insira moedas primeiro");
    }
}
