package com.lhjundi.state;

public class Main {
    void main() {
        VendingMachine machine = new VendingMachine();

        // Tentativa de selecionar sem dinheiro
        machine.selectProduct("Coca:"); // Saida: Por favor, insira moedas primeiro

        //Inserindo dinheiro
        machine.insertCoin(3); // Saída moeda inserida: $3

        // Tentativa com dinheiro insuficiente
        machine.selectProduct("Coca"); // Saída: Dinheiro insuficiente para Coca

        // Inserindo mais dinheiro
        machine.insertCoin(2); // Saída: Moeda adicional inserida: $2

        // Selecionando produto com dinheiro suficiente
        machine.selectProduct("Coca"); // Saída: Produtp selecionado: Coca

        //Dispensando o produto
        machine.dispenseProduct(); // Saída: Dispensando: Coca

        //Máquina volta ao estado inicial
        machine.selectProduct("Snack"); // Por facor, insira moedas primeiro
    }
}
