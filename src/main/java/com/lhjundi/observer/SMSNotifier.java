package com.lhjundi.observer;

public class SMSNotifier implements OrderObserver{
    @Override
    public void update(Order order) {
        System.out.println(STR. "SMS enviado: Status do pedido atualizado para \{order.getStatus()}");
    }
}
