package com.fyesilyurt.passwordgenerator.controller;

import com.fyesilyurt.passwordgenerator.model.PasswordGenerateRequestDTO;
import com.fyesilyurt.passwordgenerator.model.PasswordGenerateResponseDTO;
import com.fyesilyurt.passwordgenerator.service.GeneratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/password-generator")
public class PasswordGeneratorController {

    private final GeneratorService service;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<PasswordGenerateResponseDTO> generate (@RequestBody PasswordGenerateRequestDTO requestDTO) {
        var response =  service.generate(requestDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
