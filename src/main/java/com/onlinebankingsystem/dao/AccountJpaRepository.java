package com.onlinebankingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebankingsystem.account.Account;

@Repository(value = "AccountJpaRepository")
public interface AccountJpaRepository extends InterfaceAccountDao, JpaRepository<Account, Integer> {
}
