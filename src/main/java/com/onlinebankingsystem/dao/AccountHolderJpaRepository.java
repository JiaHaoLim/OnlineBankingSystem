package com.onlinebankingsystem.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebankingsystem.users.AccountHolder;

@Repository(value = "UserJpaRepository")
public interface AccountHolderJpaRepository extends InterfaceAccountHolderDao, JpaRepository<AccountHolder, Integer> {

}
