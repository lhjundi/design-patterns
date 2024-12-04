package com.lhjundi.facade.order_facade;

public class Main {
    void main(){
        OrderFacade orderFacade = new OrderFacade();

        orderFacade.processOrder(
                "PROD-123",
                1,
                99.99,
                "Rua Principal, 123",
                "cliente@email.com"
        );
    }
}
