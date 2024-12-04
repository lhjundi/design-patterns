package com.lhjundi.facade.email_system_facade;

public class EmailValidator {
    public boolean validateEmail(String email){
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
}
