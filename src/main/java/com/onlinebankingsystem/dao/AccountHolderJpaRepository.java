package com.onlinebankingsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebankingsystem.dao.interfaces.InterfaceAccountHolderDao;
import com.onlinebankingsystem.users.AccountHolder;

@Repository(value = "AccountHolderJpaRepository")
public interface AccountHolderJpaRepository extends InterfaceAccountHolderDao, JpaRepository<AccountHolder, Integer> {

}
