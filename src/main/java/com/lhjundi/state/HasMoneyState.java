package com.lhjundi.state;

public class HasMoneyState implements VendingMachineState{

    private VendingMachine vendingMachine;

    public HasMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int amount) {
        vendingMachine.addMoney(amount);
        System.out.println(STR."Moeda adicional inserida: $\{amount}");
    }

    @Override
    public void selectProduct(String product) {
        if (vendingMachine.getCurrentMoney() >= vendingMachine.getProductPrice(product)){
            vendingMachine.setSelectedProduct(product);
            vendingMachine.setState(new DispensingState(vendingMachine));
            System.out.println(STR. "Produto selecionado: \{product}");
        } else {
            System.out.println(STR."Dinheiro insuficiente para: \{product}");
        }

    }

    @Override
    public void dispenseProduct() {

    }
}
