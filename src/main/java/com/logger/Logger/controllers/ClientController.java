package com.logger.Logger.controllers;

import com.logger.Logger.model.Client;
import com.logger.Logger.repository.ClientRepository;
import com.logger.Logger.repository.SqlClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.UUID;

@RestController
public class ClientController {

    private ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }


    @GetMapping("/api/client/all")
    public List<Client> findAll(){
        return clientRepository.findAll();
    }


//    @GetMapping("/api/clients/all")
//    public List<Client> getAllClients(){
//        return sqlClientRepository.getAllClients();
//    }








}
