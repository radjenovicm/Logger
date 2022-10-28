package com.logger.Logger.controllers;

import com.logger.Logger.exceptions.LogException;
import com.logger.Logger.exceptions.ValidationException;
import com.logger.Logger.model.Log;
import com.logger.Logger.repository.Interfaces.ClientRepository;
import com.logger.Logger.repository.Interfaces.LogRepository;
import com.logger.Logger.services.ClientLogService;
import lombok.AllArgsConstructor;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.logger.Logger.enums.LogTypeEnum.*;


@AllArgsConstructor
@RestController
@RequestMapping("/api/logs")
public class LogsController {
    private ClientRepository clientRepository;
    private ClientLogService clientLogService;
    private LogRepository logRepository;

    @Autowired
    public LogsController(ClientRepository clientRepository, ClientLogService clientLogService, LogRepository logRepository) {
        this.clientRepository = clientRepository;
        this.clientLogService = clientLogService;
        this.logRepository = logRepository;
    }

    EmailValidator emailValidator = EmailValidator.getInstance();

    @PostMapping("create")
    public ResponseEntity<Void> createLog(@RequestHeader("Id") UUID id, @RequestBody Log log) {
        if (log.getLogType().getValue() != ERROR.getValue() &&
                log.getLogType().getValue() != WARNING.getValue() &&
                log.getLogType().getValue() != INFO.getValue()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else if (log.getMessage().length() > 1024) {
            return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).body(null);
        } else if (clientRepository.findId(id) == 0) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        log.setCreatedDate(LocalDate.now());
        logRepository.save(log);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }
    @GetMapping("search")
    public ResponseEntity<List> searchLogs(@RequestHeader("Id") UUID id,
                                           @RequestParam(value = "dateFrom", required = false) Optional<String> dateFrom,
                                           @RequestParam(value = "dateTo", required = false) Optional<String> dateTo,
                                           @RequestParam(value = "logType", required = false) Optional<Integer> logTypeEnum,
                                           @RequestBody Log log) throws LogException.IncorrectLogTypeException, ValidationException.InvalidDateException {
        if (dateFrom == null && dateTo == null && log.getLogType().getValue() != com.logger.Logger.enums.LogTypeEnum.ERROR.getValue() &&
                log.getLogType().getValue() != com.logger.Logger.enums.LogTypeEnum.WARNING.getValue() &&
                log.getLogType().getValue() != com.logger.Logger.enums.LogTypeEnum.INFO.getValue()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else if (clientRepository.findId(id) == 0) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(logRepository.searchLogs(dateFrom, dateTo, logTypeEnum));
    }

}