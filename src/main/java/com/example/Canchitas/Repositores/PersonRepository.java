package com.example.Canchitas.Repositores;

import com.example.Canchitas.Entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
