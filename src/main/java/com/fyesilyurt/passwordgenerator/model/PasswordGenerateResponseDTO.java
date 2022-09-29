package com.fyesilyurt.passwordgenerator.model;

import com.fyesilyurt.passwordgenerator.constant.PasswordStrength;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PasswordGenerateResponseDTO {

    private String generatedPassword;
    private PasswordStrength passwordStrength;
}
