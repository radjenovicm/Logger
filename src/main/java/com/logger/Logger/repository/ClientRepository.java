package com.logger.Logger.repository;

import com.logger.Logger.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;


import java.util.UUID;
@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

    List<Client> findAll();





}