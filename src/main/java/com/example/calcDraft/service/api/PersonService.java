package com.example.calcDraft.service.api;

import com.example.calcDraft.model.Person;

import java.util.List;

public interface PersonService {

    Person addPerson(Person person);

    Person updatePerson(Person person);

    void removePerson(String nationalCode);

    Person getPersonByNationalCode(String nationalCode);

    List<Person> getPersonList();
}
