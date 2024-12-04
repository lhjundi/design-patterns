package com.lhjundi.facade;

public class EmailSender {
    public void send(String to, String subject, String content){
        //Simula o envio de email usando protocolo SMTP
        System.out.println(STR."Sending email to \{to}");
        System.out.println(STR."Suject: \{subject}");
        System.out.println(STR. "Content: \{content}");

    }
}
