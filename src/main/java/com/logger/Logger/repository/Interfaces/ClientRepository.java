package com.logger.Logger.repository.Interfaces;

import com.logger.Logger.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Repository
@Validated
public interface ClientRepository extends JpaRepository<Client, UUID> {

    List<Client> findAll();


    @Query(value = "SELECT COUNT(*) FROM CLIENTS WHERE username=:username", nativeQuery = true)
    Integer existsByUsername(@Param("username") String username);

    @Query(value = "SELECT COUNT(*) FROM CLIENTS WHERE email=:email", nativeQuery = true)
    Integer existsByEmail(@Param("email") String email);
}
