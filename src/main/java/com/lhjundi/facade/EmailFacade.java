package com.lhjundi.facade;

import java.util.HashMap;
import java.util.Map;

public class EmailFacade {
    // A Facade que simplifica o uso do subsitema

    private final EmailValidator validator;
    private final TemplateEngine templateEngine;
    private final EmailSender sender;

    public EmailFacade(){
        this.validator = new EmailValidator();
        this.templateEngine = new TemplateEngine();
        this.sender = new EmailSender();
    }

    public void sendWelcomeEmail(String to, String name){
        if (!validator.validateEmail(to)){
            throw new IllegalArgumentException("Invalid email address");
        }

        String template = "Welcome {{name}}! Thank you for joining us.";
        Map<String, String> params = new HashMap<>();
        params.put("name", name);

        String content = templateEngine.generateEmailContent(template, params);
        sender.send(to, "Welcome!", content );

    }
}
