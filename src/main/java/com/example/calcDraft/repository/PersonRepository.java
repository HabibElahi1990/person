package com.example.calcDraft.repository;

import com.example.calcDraft.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {

    Optional<Person> findPersonByNationalCode(String nationalCode);

    @Query("select p from Person p order by p.id desc")
    List<Person> findAllPersonOrOrderById();
}
