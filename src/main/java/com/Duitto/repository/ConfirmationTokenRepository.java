package com.Duitto.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Duitto.model.ConfirmationTokenModel;

import java.util.Optional;
//
@Repository
public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationTokenModel, Long> {

    Optional<ConfirmationTokenModel> findByConfirmationToken(String token);
}