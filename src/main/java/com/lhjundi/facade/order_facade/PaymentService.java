package com.lhjundi.facade.order_facade;

public class PaymentService {
    public boolean processPayment(double amount){
        System.out.println(STR."Processando pagamento de R$: \{amount}");
        return true;
    }
}
