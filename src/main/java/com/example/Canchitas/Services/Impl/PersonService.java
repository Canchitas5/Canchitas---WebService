package com.example.Canchitas.Services.Impl;

import com.example.Canchitas.Entities.Person;
import com.example.Canchitas.Repositores.PersonRepository;
import com.example.Canchitas.Services.PersonServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService implements PersonServices {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person save(Person person) throws Exception {
        return personRepository.save(person);
    }

    @Override
    public void delete(Long id) throws Exception {
        personRepository.deleteById(id);
    }

    @Override
    public List<Person> getAll() throws Exception {
        return personRepository.findAll();
    }

    @Override
    public Optional<Person> getById(Long id) throws Exception {
        return personRepository.findById(id);
    }
}
