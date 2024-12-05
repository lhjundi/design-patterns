package com.lhjundi.observer;

public class AdminDashboard implements OrderObserver{
    @Override
    public void update(Order order) {
        System.out.println(STR. "Dashboard atualizado: Novo status do pedido é \{order.getStatus()}");
    }
}
