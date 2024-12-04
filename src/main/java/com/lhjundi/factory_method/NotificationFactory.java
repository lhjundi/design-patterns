package com.lhjundi.factory_method;

public abstract class NotificationFactory {
    // Classe abstrata criadora

    abstract Notification createNotification();

    // Método que utiliza a fábrica

    public void processNotification(String message){
        Notification notification = createNotification();
        notification.send(message);
    }
}
