package com.example.calcDraft.controller;

import com.example.calcDraft.model.Person;
import com.example.calcDraft.service.api.PersonService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/add")
    public Person addPerson(@RequestBody Person person) {
        return personService.addPerson(person);
    }

    @PutMapping("/update")
    public Person updatePerson(@RequestParam String nationalCode, @RequestBody Person newPersonInfo) {
        Person person = personService.getPersonByNationalCode(nationalCode);
        return personService.addPerson(mapPerson(person, newPersonInfo));
    }

    private Person mapPerson(Person currentPerson, Person newPerson) {
        currentPerson.setName(newPerson.getName());
        currentPerson.setAge(newPerson.getAge());
        return currentPerson;
    }

    @DeleteMapping("/delete")
    public void removePerson(@RequestParam String nationalCode) {
        personService.removePerson(nationalCode);
    }

    @GetMapping("/findByNationalCode")
    public Person findByNationalCode(@RequestParam String nationalCode){
        return personService.getPersonByNationalCode(nationalCode);
    }

    @GetMapping("/getAllPerson")
    public List<Person> getAllPerson(){
        return personService.getPersonList();
    }
}
