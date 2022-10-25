package com.logger.Logger.controllers;

import com.logger.Logger.Login;
import com.logger.Logger.repository.Interfaces.ClientRepository;
import com.logger.Logger.services.ClientLogService;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    private ClientRepository clientRepository;
    private ClientLogService clientLogService;

    @Autowired
    public LoginController(ClientRepository clientRepository, ClientLogService clientLogService) {
        this.clientRepository = clientRepository;
        this.clientLogService = clientLogService;
    }

    EmailValidator emailValidator = EmailValidator.getInstance();

    @PostMapping(path = "api/clients/login")
    public ResponseEntity<?> login(@RequestBody Login request) {
        return clientLogService.login(request);
    }

    public ResponseEntity<?> loginClient(Login logRequest) {
        Map<String, String> map = new HashMap<>();
        if (emailValidator.isValid(logRequest.getAccount())) {
            if (clientRepository.existsByUsername(logRequest.getAccount()) != 0) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);

            }


        }
        // Create Log Response (201, 400, 401, 413) @PostMapping("/api/logs/create")
//    public ResponseEntity<Void> createLog(HttpServletRequest request, Log log){
//        Log log1 = new Log(UUID.randomUUID() )
//
//
    }
}