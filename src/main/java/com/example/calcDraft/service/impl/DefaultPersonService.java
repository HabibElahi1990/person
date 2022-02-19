package com.example.calcDraft.service.impl;

import com.example.calcDraft.model.Person;
import com.example.calcDraft.repository.PersonRepository;
import com.example.calcDraft.service.api.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultPersonService implements PersonService {
    private final PersonRepository personRepository;

    public DefaultPersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void removePerson(String nationalCode) {
        personRepository.findPersonByNationalCode(nationalCode).ifPresent(n -> personRepository.delete(n));
    }

    @Override
    public Person getPersonByNationalCode(String nationalCode) {
        Optional<Person> personByNationalCode = personRepository.findPersonByNationalCode(nationalCode);
        if (personByNationalCode.isPresent()){
            return personByNationalCode.get();
        }
        throw new IllegalArgumentException("there is not any person with "+nationalCode);
    }

    @Override
    public List<Person> getPersonList() {
        return personRepository.findAllPersonOrOrderById();
    }
}
