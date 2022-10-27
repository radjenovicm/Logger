package com.logger.Logger.repository.Interfaces;

import com.logger.Logger.exceptions.GeneralException;
import com.logger.Logger.exceptions.LogException;
import com.logger.Logger.exceptions.ValidationException;
import com.logger.Logger.model.dto.CreateLogRequest;
import com.logger.Logger.model.dto.LogDTO;

import java.util.List;
import java.util.Optional;

public interface LogService {
    LogDTO createLog(CreateLogRequest log, String client)
            throws GeneralException.UserNotFoundException, LogException.LogPayloadTooLargeException, LogException.IncorrectLogTypeException;
    List<LogDTO> searchLogs(Optional<String> dateFrom, Optional<String> dateTo, Optional<String> message, Optional<Integer> logType)
            throws ValidationException.InvalidDateException, LogException.IncorrectLogTypeException;
}
}
