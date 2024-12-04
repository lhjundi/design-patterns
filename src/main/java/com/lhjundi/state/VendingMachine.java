package com.lhjundi.state;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {
    // Classe contexto que mantém o estado atual

    private VendingMachineState state;
    private int currentMoney;
    private String selectedProduct;
    private Map<String, Integer> prices;

    public VendingMachine(){
        this.state = new NoMoneyState(this);
        this.currentMoney = 0;
        this.prices = new HashMap<>();
        prices.put("Coca", 5);
        prices.put("Snack", 3);
    }

    public void setState(VendingMachineState state) {
        this.state = state;
    }

    public void insertCoin(int amount){
        state.insertCoin(amount);
    }

    public void selectProduct(String product){
        state.selectProduct(product);
    }

    public void dispenseProduct(){
        state.dispenseProduct();
    }

    // Métodos auxiliares
    public void addMoney(int amount) {
        currentMoney += amount;
    }

    public void resetMoney(){
        currentMoney = 0;
    }

    public int getCurrentMoney() {
        return currentMoney;
    }

    public int getProductPrice(String product) {
        return prices.getOrDefault(product, 0);
    }

    public void setSelectedProduct(String product) {
        this.selectedProduct = product;
    }

    public String getSelectedProduct() {
        return selectedProduct;
    }
}
