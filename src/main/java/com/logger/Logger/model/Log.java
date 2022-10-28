package com.logger.Logger.model;
//3. Корисник може да упише лог
// message
// logType (ERROR,WARNING,INFO)
// createdDate


import com.logger.Logger.enums.LogTypeEnum;
import lombok.*;

import javax.net.ssl.SSLSession;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "ClientLogs")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String token;
    private String message;
    @Enumerated(EnumType.ORDINAL)
    private LogTypeEnum logType;
    private LocalDate createdDate;




}
