package com.logger.Logger.model.dto;

import com.logger.Logger.enums.LogTypeEnum;
import lombok.*;
import java.time.LocalDate;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class LogDTO {
    private UUID id;
    private String message;
    private LogTypeEnum logType;
    private LocalDate createdDate;
}
