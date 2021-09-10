package com.onlinebankingsystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebankingsystem.users.AccountHolder;

@Repository(value = "AccountHolderJpaRepository")
public interface AccountHolderJpaRepository extends InterfaceAccountHolderDao, JpaRepository<AccountHolder, Integer> {

}
