package com.bitlogic.login.security;

import com.bitlogic.login.model.Persona;
import com.bitlogic.login.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomDetailService implements UserDetailsService {

    private final PersonaRepository personaRepository;
    private  BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public CustomDetailService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public CustomUser loadUserByUsername(String s) throws UsernameNotFoundException {
          Persona persona = personaRepository.findByPhoneNumberEquals(s)
                  .orElseThrow( ()-> new UsernameNotFoundException(s));
        persona.setPassword(bCryptPasswordEncoder.encode(persona.getPassword()));

        return new CustomUser(persona);
    }



}
