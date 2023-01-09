package com.fyesilyurt.passwordgenerator.service;

import com.fyesilyurt.passwordgenerator.constant.AllCharacters;
import com.fyesilyurt.passwordgenerator.constant.PasswordStrength;
import com.fyesilyurt.passwordgenerator.exception.NotFoundChoice;
import com.fyesilyurt.passwordgenerator.exception.SizeCanNotNullOrEqualToZero;
import com.fyesilyurt.passwordgenerator.model.PasswordGenerateRequestDTO;
import com.fyesilyurt.passwordgenerator.model.PasswordGenerateResponseDTO;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class GeneratorService {

    public PasswordGenerateResponseDTO generate(PasswordGenerateRequestDTO request) {
        if (request.getSize() == null || request.getSize() == 0) {
            throw new SizeCanNotNullOrEqualToZero("Password size can not be null or equal to zero.");
        }

        if (!(request.getHasNumber() || request.getHasLowerCase() || request.getHasUpperCase() || request.getHasSpecialCharacter())) {
            throw new NotFoundChoice("There is no any choice. Please choose at least one option.");
        }

        String generatedPassword = generatePassword(request);
        PasswordStrength strength = checkPasswordStrength(generatedPassword);
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

    public PasswordStrength checkPasswordStrength(String generatedPassword) {
        String strongRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{10,}$";
        String mediumRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,}$";
        Pattern strongPattern = Pattern.compile(strongRegex);
        Matcher strongMatcher = strongPattern.matcher(generatedPassword);
        Pattern mediumPattern = Pattern.compile(mediumRegex);
        Matcher mediumMatcher = mediumPattern.matcher(generatedPassword);
        if (strongMatcher.matches()) {
            return PasswordStrength.STRONG;
        } else if (mediumMatcher.matches()) {
            return PasswordStrength.GOOD;
        } else {
            return PasswordStrength.WEAK;
        }
    }
}
