package com.lhjundi.facade;

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
