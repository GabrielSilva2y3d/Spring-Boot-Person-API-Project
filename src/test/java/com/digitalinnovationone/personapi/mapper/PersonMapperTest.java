package com.digitalinnovationone.personapi.mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.digitalinnovationone.personapi.dto.mapper.PersonMapper;
import com.digitalinnovationone.personapi.dto.request.PersonDTO;
import com.digitalinnovationone.personapi.dto.request.PhoneDTO;
import com.digitalinnovationone.personapi.entity.Person;
import com.digitalinnovationone.personapi.entity.Phone;
import com.digitalinnovationone.personapi.utils.PersonUtils;

@SpringBootTest
public class PersonMapperTest {

    @Autowired
    private PersonMapper personMapper;

    @Test
    void testGivenPersonDTOThenReturnPersonEntity() {
        PersonDTO personDTO = PersonUtils.createFakeDTO();
        Person person = personMapper.toModel(personDTO);

        assertEquals(personDTO.getFirstname(), person.getFirstname());
        assertEquals(personDTO.getLastname(), person.getLastname());
        assertEquals(personDTO.getCpf(), person.getCpf());

        Phone phone = person.getPhone().get(0);
        PhoneDTO phoneDTO = personDTO.getPhone().get(0);

        assertEquals(phoneDTO.getType(), phone.getType());
        assertEquals(phoneDTO.getNumber(), phone.getNumber());
    }

    @Test
    void testGivenPersonEntityThenReturnPersonDTO() {
        Person person = PersonUtils.createFakeEntity();
        PersonDTO personDTO = personMapper.toDTO(person);

        assertEquals(person.getFirstname(), personDTO.getFirstname());
        assertEquals(person.getLastname(), personDTO.getLastname());
        assertEquals(person.getCpf(), personDTO.getCpf());

        Phone phone = person.getPhone().get(0);
        PhoneDTO phoneDTO = personDTO.getPhone().get(0);

        assertEquals(phone.getType(), phoneDTO.getType());
        assertEquals(phone.getNumber(), phoneDTO.getNumber());
    }
}