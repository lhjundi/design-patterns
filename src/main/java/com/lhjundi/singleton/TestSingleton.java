package com.lhjundi.singleton;

public class TestSingleton {
    void main() {

        // Obtém a mesma instância em qualquer parte do código
        ApplicationConfig config = ApplicationConfig.getInstance();

        // Lê uma configuração que será vista por toda a aplicação
        config.setConfig("app.theme", "dark");

        // Em outro ponto do código, obtém a mesma instância
        ApplicationConfig sameConfig = ApplicationConfig.getInstance();

        String theme = sameConfig.getConfig("app.theme");
    }

}
