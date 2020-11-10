package com.bitlogic.login.security;

import com.bitlogic.login.model.Persona;
import com.bitlogic.login.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CustomDetailService implements UserDetailsService {

    private final PersonaRepository personaRepository;

    @Autowired
    public CustomDetailService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public CustomUser loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
        //phoneNumber = "3511234567";
          Persona persona = personaRepository.findByPhoneNumberEquals(phoneNumber)
                  .orElseThrow( ()-> new UsernameNotFoundException(phoneNumber));
        if (persona.getAouth() == null) {
            Collection<GrantedAuthority> aouth = new ArrayList<>();
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ADMIN");
            aouth.add(grantedAuthority);
            persona.setAouth(aouth);
        }
        return new CustomUser(persona);
    }



}
