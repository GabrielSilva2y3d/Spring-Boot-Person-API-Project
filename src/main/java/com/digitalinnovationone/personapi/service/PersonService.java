package com.digitalinnovationone.personapi.service;
import java.util.List;
import java.util.stream.Collectors;

import com.digitalinnovationone.personapi.dto.mapper.PersonMapper;
import com.digitalinnovationone.personapi.dto.request.PersonDTO;
import com.digitalinnovationone.personapi.entity.Person;
import com.digitalinnovationone.personapi.exception.PersonNotFoundException;
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

    public List<PersonDTO> list(){
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        return personMapper.toDTO(person);
    }

    public void delete(Long id) throws PersonNotFoundException {
        personRepository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

        personRepository.deleteById(id);
    }



}
