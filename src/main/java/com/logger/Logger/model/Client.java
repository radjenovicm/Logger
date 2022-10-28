package com.logger.Logger.model;


import com.logger.Logger.enums.ClientRoleEnum;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private UUID id;
    private String username;
    private String password;
    private String email;

//    private ClientRoleEnum role;
//    private Long logCount;




}
