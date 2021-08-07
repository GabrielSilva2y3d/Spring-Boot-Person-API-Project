package com.digitalinnovationone.personapi.utils;

import java.time.LocalDate;
import java.util.Collections;

import com.digitalinnovationone.personapi.dto.request.PersonDTO;
import com.digitalinnovationone.personapi.entity.Person;

public class PersonUtils {

    private static final String FIRST_NAME = "Gabriel";
    private static final String LAST_NAME = "Silva";
    private static final String CPF_NUMBER = "076.844.615-59";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2000, 28, 4);

    public static PersonDTO createFakeDTO() {
        return PersonDTO.builder()
                .firstname(FIRST_NAME)
                .lastname(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate("04-28-2000")
                .phone(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Person createFakeEntity() {
        return Person.builder()
                .id(PERSON_ID)
                .firstname(FIRST_NAME)
                .lastname(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .phone(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }




}