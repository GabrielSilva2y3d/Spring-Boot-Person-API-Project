package com.digitalinnovationone.personapi.controller;

import java.util.List;

import javax.validation.Valid;

import com.digitalinnovationone.personapi.dto.request.PersonDTO;
import com.digitalinnovationone.personapi.dto.response.MessageResponseDTO;
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
    public MessageResponseDTO createPersonDTO(@RequestBody @Valid PersonDTO personDTO){
        return personService.create(personDTO);
    }
    
    @GetMapping
    public List<PersonDTO> listPersonDTO(){
        return personService.list();
    }

    @GetMapping("/{personDTOId}")
    public ResponseEntity<PersonDTO> getWorkdayById(@PathVariable("personDTOId") Long personDTOId) throws Exception{
        return ResponseEntity.ok(personService.getById(personDTOId).orElseThrow(() -> new Exception("Person not found")));
    }

    @PutMapping
    public MessageResponseDTO updatePersonDTO(@RequestBody @Valid PersonDTO personDTO){
        return personService.update(personDTO);
    }

    @DeleteMapping("/{personDTOIdDel}")
    public ResponseEntity deleteById(@PathVariable("personDTOIdDel") Long personDTOId) throws Exception{
        try{
            personService.delete(personDTOId);
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
        return (ResponseEntity) ResponseEntity.ok();
        }
}
