package com.lhjundi.factory_method;

public class SMSFactory extends NotificationFactory{
    @Override
    Notification createNotification() {
        return new SMSNotification();
    }
}
