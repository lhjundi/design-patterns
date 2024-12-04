package com.lhjundi.factory_method;

public class EmailFactory extends NotificationFactory{
    @Override
    Notification createNotification() {
        return new EmailNotification();
    }
}
