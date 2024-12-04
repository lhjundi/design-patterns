package com.lhjundi.factory_method;

public class EmailNotification implements Notification{
    @Override
    public void send(String message) {
        System.out.println(STR. "Sending email: \{message}");
    }
}
