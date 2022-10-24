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
    EmailValidator emailValidator = EmailValidator.getInstance();
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public ResponseEntity<Void> insertClient(Client client) {
        if (clientRepository.existsByUsername(client.getUsername()) != 0 || clientRepository.existsByEmail(client.getEmail()) != 0) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        if (!(emailValidator.isValid(client.getEmail())) || client.getUsername().length() < 3 || client.getPassword().length() < 8) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
//        if(client.getPassword().length() > 8){
//            for(int i = 0; i< client.getPassword().length();i++){
//                if(Character.isUpperCase(client.getPassword().charAt(i)) && Character.isDigit(client.getPassword().charAt(i))){
//
//                }


        client.setId(UUID.randomUUID());
        clientRepository.save(new Client(client.getId(), client.getUsername(), client.getPassword(), client.getEmail()));
        getAllClients().add(client);
        return ResponseEntity.status(HttpStatus.CREATED).
                body(null);
    }

//RequestEntity for login 200 - ok
//                        400 - bad request
//
//    public  ResponseEntity<> login(String username, String password){
//        if(clientRepository.existsByUsername(username)>=1){
//
//        }
//        clientRepository.
//    }


}
