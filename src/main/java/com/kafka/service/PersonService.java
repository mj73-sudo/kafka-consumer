package com.kafka.service;

import com.kafka.dto.CreatePersonDTO;
import com.kafka.entity.Person;
import com.kafka.mapper.PersonMapper;
import com.kafka.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    @KafkaListener(topics = "per")
    public void consume(@Payload() CreatePersonDTO personDTO) {
        PersonMapper mapper = new PersonMapper();
        Person person = mapper.toEntity(personDTO);
        personRepository.save(person);
    }
}
