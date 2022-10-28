package com.logger.Logger.controllers;
import com.logger.Logger.model.Client;
import com.logger.Logger.repository.Interfaces.ClientRepository;
import com.logger.Logger.services.ClientService;
import org.apache.commons.validator.routines.EmailValidator;
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
public class ClientsController {
    EmailValidator emailValidator = EmailValidator.getInstance();
    private ClientService clientService;
    private ClientRepository clientRepository;

    @Autowired
    public ClientsController(ClientService clientService, ClientRepository clientRepository) {
        this.clientService = clientService;
        this.clientRepository = clientRepository;
    }

    @GetMapping("/api/clients/all")
    public List<Client> findAllClients() {
        return clientService.getAllClients();
    }

    public ResponseEntity<Void> insertClient(Client client) {
        if (clientRepository.existsByUsername(client.getUsername()) != 0 || clientRepository.existsByEmail(client.getEmail()) != 0) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        if (!(emailValidator.isValid(client.getEmail())) || client.getUsername().length() < 3 || client.getPassword().length() < 8) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        client.setId(UUID.randomUUID());

        clientRepository.save(new Client(client.getId(), client.getUsername(), client.getPassword(), client.getEmail()));
        clientService.getAllClients().add(client);
        return ResponseEntity.status(HttpStatus.CREATED).
                body(null);
    }
    @PostMapping("/api/clients/register")
    public ResponseEntity<Void> registerClient(@RequestBody Client client){
        return insertClient(client);
    }


    @PostMapping("/api/clients/login")
    public ResponseEntity<?> loginClient(@RequestBody Client client){
        if(clientRepository.existsByEmail(client.getEmail()) == 0 && clientRepository.existsByPassword(client.getPassword()) == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        String token = String.valueOf(UUID.randomUUID());
        return ResponseEntity.status(HttpStatus.OK).body("Token: " + token);
    }


}
