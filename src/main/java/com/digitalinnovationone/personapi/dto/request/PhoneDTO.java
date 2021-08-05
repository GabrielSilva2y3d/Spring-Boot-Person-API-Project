package com.digitalinnovationone.personapi.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

import com.digitalinnovationone.personapi.enums.PhoneType;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhoneDTO {
    private Long id;
    
    @NotEmpty
    private String number;

    @Enumerated(EnumType.STRING)
    private PhoneType type;
}
