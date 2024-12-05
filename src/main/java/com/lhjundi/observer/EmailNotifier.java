package com.lhjundi.observer;

public class EmailNotifier implements OrderObserver{

    @Override
    public void update(Order order) {
        System.out.println(STR.
                "Email enviado: Status do pedido atualizado para \{order.getStatus()}");
    }
}
