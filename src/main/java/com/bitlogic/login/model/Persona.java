package com.bitlogic.login.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "personas")
public class Persona {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String phoneNumber;
    @JsonIgnore
    private String password;

    public Persona(){

    }

    public Persona(Long id, String phoneNumber, String password) {
        this.id = id;
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
