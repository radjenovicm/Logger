package com.logger.Logger.repository.Interfaces;

import com.logger.Logger.exceptions.GeneralException;
import com.logger.Logger.exceptions.LogException;
import com.logger.Logger.exceptions.ValidationException;
import com.logger.Logger.model.Log;
import com.logger.Logger.model.dto.CreateLogRequest;
import com.logger.Logger.model.dto.LogDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LogRepository extends JpaRepository<Log,Integer> {


    LogDTO createLog(CreateLogRequest log, String client)
            throws GeneralException.UserNotFoundException, LogException.LogPayloadTooLargeException, LogException.IncorrectLogTypeException;
    List<LogDTO> searchLogs(Optional<String> dateFrom, Optional<String> dateTo,  Optional<Integer> logType)
            throws ValidationException.InvalidDateException, LogException.IncorrectLogTypeException;



}

