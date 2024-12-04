package com.lhjundi.state;

public interface VendingMachineState {
    // define os comportamentos possíveis em qualquer estado
    void insertCoin(int amount);
    void selectProduct(String product);
    void dispenseProduct();
}


