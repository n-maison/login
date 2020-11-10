package com.bitlogic.login.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "personas")
@Data
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "phone_number", unique = true, nullable = false)
    @JsonProperty("username")
    private String phoneNumber;
    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;
    @JsonIgnore
    @Transient
    private Collection<GrantedAuthority> aouth;

    public Persona() {

    }

    public Persona(String phoneNumber, String password) {
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
