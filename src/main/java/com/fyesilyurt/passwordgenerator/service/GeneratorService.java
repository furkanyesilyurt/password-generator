package com.fyesilyurt.passwordgenerator.service;

import com.fyesilyurt.passwordgenerator.constant.AllCharacters;
import com.fyesilyurt.passwordgenerator.constant.PasswordStrength;
import com.fyesilyurt.passwordgenerator.model.PasswordGenerateRequestDTO;
import com.fyesilyurt.passwordgenerator.model.PasswordGenerateResponseDTO;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GeneratorService {

    //TODO: checkPasswordStrength
    //TODO: exceptions
    //TODO: swagger documentation
    //TODO: frontend research
    //TODO: make simple frontend
    //TODO: readme.md

    public PasswordGenerateResponseDTO generate(PasswordGenerateRequestDTO request) {

        String generatedPassword = generatePassword(request);
        PasswordStrength strength = checkPasswordStrength(request);
        return PasswordGenerateResponseDTO.builder()
                .generatedPassword(generatedPassword)
                .passwordStrength(strength)
                .build();
    }

    public String generatePassword(PasswordGenerateRequestDTO requestDTO) {
        String chr = "";

        chr += requestDTO.getHasUpperCase() ? AllCharacters.upperCase : "";
        chr += requestDTO.getHasLowerCase() ? AllCharacters.lowerCase : "";
        chr += requestDTO.getHasNumber() ? AllCharacters.digits : "";
        chr += requestDTO.getHasSpecialCharacter() ? AllCharacters.punctuation : "";

        Random random = new Random();
        char[] password = new char[requestDTO.getSize()];
        for (int i = 0; i < password.length; i++) {
            password[i] = chr.charAt(random.nextInt(chr.length()));
        }

        return new String(password);
    }

    public PasswordStrength checkPasswordStrength(PasswordGenerateRequestDTO requestDTO) {
        return null;
    }
}
