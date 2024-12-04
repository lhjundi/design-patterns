package com.lhjundi.facade.order_facade;

public class OrderFacade {
    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final ShippingService shippingService;
    private final EmailService emailService;

    public OrderFacade(){
        this.inventoryService = new InventoryService();
        this.paymentService = new PaymentService();
        this.shippingService = new ShippingService();
        this. emailService = new EmailService();
    }

    public boolean processOrder(String productId, int quantity, double amount, String address, String email){
        // Verifica se tem todas as validações necessárias
        if (!inventoryService.checkStock(productId, quantity)) {
            System.out.println("Produto fora de estoque");
            return false;
        }

        // Processa o pagamento
        if (!paymentService.processPayment(amount)){
            System.out.println("Falha no pagamento");
            return false;
        }

        // Agenda a entrega
        shippingService.scheduleDelivery(address);

        //Envia confirmação
        emailService.sendConfirmation(email);

        System.out.println("Pedido processado com sucesso!");
        return true;
    }
}
