package com.fyesilyurt.passwordgenerator.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PasswordGenerateRequestDTO {

    private Boolean hasUpperCase;
    private Boolean hasLowerCase;
    private Boolean hasNumber;
    private Boolean hasSpecialCharacter;
    private Integer size;
}
