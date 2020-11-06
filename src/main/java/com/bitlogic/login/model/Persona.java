package com.bitlogic.login.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "personas")
@Data
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "phone_number", unique = true, nullable = false)
    private String phoneNumber;
    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;
    @JsonIgnore
    @Transient
    private Collection<GrantedAuthority> aouth = new ArrayList<>();

    public Persona() {

    }

    public Persona(String phoneNumber, String password, ArrayList<GrantedAuthority> authorities) {
        this.aouth = authorities;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
