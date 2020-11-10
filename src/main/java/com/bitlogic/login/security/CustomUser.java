package com.bitlogic.login.security;

import com.bitlogic.login.model.Persona;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {
    private static final long serialVersionUID = 1L;
    public CustomUser(Persona person) {
        super(person.getPhoneNumber(), person.getPassword(), person.getAouth());
    }
}
