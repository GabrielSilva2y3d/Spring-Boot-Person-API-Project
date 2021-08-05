package com.digitalinnovationone.personapi.service;
import java.util.List;
import java.util.Optional;

import com.digitalinnovationone.personapi.dto.request.PersonDTO;
import com.digitalinnovationone.personapi.entity.Person;
import com.digitalinnovationone.personapi.mapper.PersonMapper;
import com.digitalinnovationone.personapi.dto.response.MessageResponseDTO;
import com.digitalinnovationone.personapi.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    
    public List<Person> list(){
        return personRepository.findAll();
    }

    public Optional<Person> getById(Long personId){
        return personRepository.findById(personId);
    }

    public MessageResponseDTO create(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);
        Person created = personRepository.save(personToSave);
        return MessageResponseDTO
            .builder()
            .message("Person Created! " + created)
            .build();
    }

    public MessageResponseDTO update(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);
        Person updated = personRepository.save(personToSave);
        return MessageResponseDTO
            .builder()
            .message("Person Updated! " + updated)
            .build();
    }

    public void delete(Long personId){
        personRepository.deleteById(personId);;
    }

}