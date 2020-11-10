package com.bitlogic.login.repository;

import com.bitlogic.login.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long> {
    Optional<Persona> findByPhoneNumberEquals(String phone);

    @Query(value = "select per from personas as per where phone_number = :phone ", nativeQuery = true)
    Persona searchperson(String phone);
}
