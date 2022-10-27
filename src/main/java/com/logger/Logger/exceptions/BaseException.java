package com.logger.Logger.exceptions;

import com.logger.Logger.model.dto.ErrorMessageDTO;

public abstract class BaseException extends Exception{
    private ErrorMessageDTO messageDTO;

    public BaseException(String msg) {
        this.messageDTO = new ErrorMessageDTO(msg);
    }

    public String getMessage() {
        return messageDTO.getMessage();
    }

    public ErrorMessageDTO getMessageDTO() {
        return messageDTO;
    }
}

