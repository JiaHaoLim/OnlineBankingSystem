package com.onlinebankingsystem.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebankingsystem.users.User;

@Repository(value = "UserJpaRepository")
public interface UserJpaRepository extends InterfaceUserDao, JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);

}
