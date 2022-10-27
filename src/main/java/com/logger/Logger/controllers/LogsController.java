package com.logger.Logger.controllers;

import com.logger.Logger.exceptions.GeneralException;
import com.logger.Logger.exceptions.LogException;
import com.logger.Logger.model.dto.CreateLogRequest;
import com.logger.Logger.repository.Interfaces.ClientRepository;
import com.logger.Logger.repository.Interfaces.LogService;
import com.logger.Logger.services.ClientLogService;
import lombok.AllArgsConstructor;
import org.apache.commons.validator.routines.EmailValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@AllArgsConstructor
@RestController
@RequestMapping("/api/logs")
public class LogsController {
    private ClientRepository clientRepository;
    private ClientLogService clientLogService;

    private LogService logService;

    @Autowired
    public LogsController(ClientRepository clientRepository, ClientLogService clientLogService) {
        this.clientRepository = clientRepository;
        this.clientLogService = clientLogService;
    }
    EmailValidator emailValidator = EmailValidator.getInstance();


    @PostMapping("create")
    public ResponseEntity register(@RequestBody CreateLogRequest request)
            throws GeneralException.UserNotFoundException, LogException.LogPayloadTooLargeException, LogException.IncorrectLogTypeException {
//          To do  Authentification



        return new ResponseEntity(HttpStatus.CREATED);
    }





}