package com.logger.Logger.services;

import com.logger.Logger.Login;
import com.logger.Logger.controllers.LoginController;
import com.logger.Logger.repository.Interfaces.ClientRepository;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ClientLogService {
    private final ClientRepository clientRepository;
    private ClientService clientService;

    EmailValidator emailValidator = EmailValidator.getInstance();

    private LoginController loginController;

    @Autowired
    public ClientLogService(ClientRepository clientRepository, ClientService clientService){
        this.clientRepository=clientRepository;
        this.clientService=clientService;
    }

    public ResponseEntity<?> login(Login request) {
        return loginController.loginClient(new Login(request.getAccount(),
                request.getPassword()));
    }




}
