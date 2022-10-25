package com.logger.Logger.services;

import com.logger.Logger.model.Client;
import com.logger.Logger.repository.Interfaces.ClientRepository;
import org.apache.commons.validator.routines.EmailValidator;
import org.passay.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class ClientService {

//    PasswordValidator passwordValidator = new PasswordValidator(
//            Arrays.asList(
//                    new LengthRule(8,50),
//                    new CharacterRule(EnglishCharacterData.Alphabetical,1),
//                    new CharacterRule(EnglishCharacterData.Digit,1)
//            )
//    );
//    RuleResult result = passwordValidator.validate(new PasswordData());

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }






}
