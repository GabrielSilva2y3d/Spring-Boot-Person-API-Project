package com.digitalinnovationone.personapi.controller;

import java.util.List;

import com.digitalinnovationone.personapi.dto.response.MessageResponseDTO;
import com.digitalinnovationone.personapi.entity.Person;
import com.digitalinnovationone.personapi.service.PersonService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/people")
public class PersonController {

    
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person){
        return personService.create(person);
    }
    
    @GetMapping
    public List<Person> listPerson(){
        return personService.list();
    }

    @GetMapping("/{personId}")
    public ResponseEntity<Person> getWorkdayById(@PathVariable("personId") Long personId) throws Exception{
        return ResponseEntity.ok(personService.getById(personId).orElseThrow(() -> new Exception("Person not found")));
    }

    @PutMapping
    public MessageResponseDTO updatePerson(@RequestBody Person person){
        return personService.update(person);
    }

    @DeleteMapping("/{personIdDel}")
    public ResponseEntity deleteById(@PathVariable("personIdDel") Long personId) throws Exception{
        try{
            personService.delete(personId);
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
        return (ResponseEntity) ResponseEntity.ok();
        }
}
