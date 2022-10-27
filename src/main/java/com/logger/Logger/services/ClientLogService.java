package com.logger.Logger.services;
import com.logger.Logger.controllers.LogsController;
import com.logger.Logger.repository.Interfaces.ClientRepository;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientLogService {
    private final ClientRepository clientRepository;
    private ClientService clientService;

    EmailValidator emailValidator = EmailValidator.getInstance();

    private LogsController loginController;

    @Autowired
    public ClientLogService(ClientRepository clientRepository, ClientService clientService){
        this.clientRepository=clientRepository;
        this.clientService=clientService;
    }
}
