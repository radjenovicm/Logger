package com.logger.Logger.controllers;

import com.logger.Logger.model.Client;
import com.logger.Logger.repository.Interfaces.ClientRepository;

import com.logger.Logger.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class ClientController {

    private ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/api/clients/all")
    public List<Client> findAllClients() {
        return clientService.getAllClients();
    }

    @PostMapping("/api/clients/register")
    public ResponseEntity<Void> registerClient(@RequestBody Client client){
        return clientService.insertClient(client);
    }

    // @PostMapping("/api/clients/login")


}
