package com.digitalinnovationone.personapi.dto.request;

import java.time.LocalDate;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;
    
    private String firstname;

    private String lastname;

    private String cpf;

    private LocalDate birthDate;
    
    private List<PhoneDTO> phone;
    
}
