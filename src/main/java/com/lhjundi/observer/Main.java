package com.lhjundi.observer;

public class Main {
    void main(){
        Order order = new Order();

        // Criando observers
        OrderObserver emailNotifier = new EmailNotifier();
        OrderObserver smsNotifier = new SMSNotifier();
        OrderObserver adminDashboard = new AdminDashboard();

        // Registrando observers
        order.attach(emailNotifier);
        order.attach(smsNotifier);
        order.attach(adminDashboard);

        // Alterando estado - todos os observers serão notificados
        order.setStatus("Em processamento");

        System.out.println("\n Removendo SMS notifier....\n");
        order.detach(smsNotifier);

        // Alterando estado novamente - apenas email e dashboard serão notificados
        order.setStatus("Em transporte");
    }
}
