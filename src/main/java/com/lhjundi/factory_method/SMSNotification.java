package com.lhjundi.factory_method;

public class SMSNotification implements Notification{
    @Override
    public void send(String message) {
        System.out.println(STR. "Sending SMS: \{message}");
    }
}
