package com.kafka.mapper;

import com.kafka.dto.CreatePersonDTO;
import com.kafka.entity.Person;
import org.springframework.stereotype.Component;

public class PersonMapper {
    public Person toEntity(CreatePersonDTO dto) {
        Person person = new Person();
        person.setFirstName(dto.getFirstName());
        person.setLastName(dto.getLastName());

        return person;
    }
}
