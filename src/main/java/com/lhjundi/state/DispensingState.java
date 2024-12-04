package com.lhjundi.state;

public class DispensingState implements VendingMachineState {

    private VendingMachine vendingMachine;

    public DispensingState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int amount) {
        System.out.println("Aguarde, dispensando o produto");

    }

    @Override
    public void selectProduct(String product) {
        System.out.println("Aguarde, dispensando o produto");
    }

    @Override
    public void dispenseProduct() {
        System.out.println(STR. "Dispensando: \{vendingMachine.getSelectedProduct()}");
        vendingMachine.resetMoney();
        vendingMachine.setState(new NoMoneyState(vendingMachine));
    }
}
