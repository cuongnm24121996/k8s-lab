package com.cuongnm.application.service;

import com.cuongnm.application.domain.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PersonService {

    @Transactional(readOnly = true)
    public Person findOne(Long id) {
        Person person = new Person("cuong", "nguyen");
        return person;
    }

    public Person save(Person person) {

        return person;
    }
}
