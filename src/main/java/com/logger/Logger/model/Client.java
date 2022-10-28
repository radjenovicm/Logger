package com.logger.Logger.model;


import com.logger.Logger.enums.ClientRoleEnum;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "Clients")
public class Client {
    @Id
    @GeneratedValue(generator = "UUIDGenerator")
    private UUID id;
    private String username;
    private String password;
    private String email;


    @Enumerated(EnumType.STRING)
    private ClientRoleEnum role;
    private Integer logCount;




}
