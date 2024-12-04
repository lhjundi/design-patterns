package com.lhjundi.factory_method;

public class Main {
    void main(){
        NotificationFactory emailFactory = new EmailFactory();
        NotificationFactory smsFactory = new SMSFactory();

        // Usando a fábrica de email
        emailFactory.processNotification("Hi, this is a notification!");

        // Usando a fábrica de SMS
        smsFactory.processNotification("Hi, this is a notification!");
    }
}
