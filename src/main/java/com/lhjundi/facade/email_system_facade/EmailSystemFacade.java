package com.lhjundi.facade.email_system_facade;

public class EmailSystemFacade {
    void main(){
        EmailFacade emailFacade = new EmailFacade();

        //Cliente usa uma interface simples, sem conhecer a complexidade
        try{
            emailFacade.sendWelcomeEmail("john@example.com", "John");
        } catch (IllegalArgumentException e){
            System.out.println(STR."Error: \{e.getMessage()}");
        }
    }
}
