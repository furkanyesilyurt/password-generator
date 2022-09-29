package com.fyesilyurt.passwordgenerator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PasswordGenerateRequestDTO {

    private boolean hasUpperCase;
    private boolean hasLowerCase;
    private boolean hasNumber;
    private boolean hasSpecialCharacter;
    private int size;
}
