package com.onlinebankingsystem.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebankingsystem.users.User;

//@Repository(value = "JpaRepository")
//public interface UserJpaRepository extends IDao, JpaRepository<User, Integer> {
//
//}

@Repository(value = "UserJpaRepository")
public interface UserJpaRepository extends IDao, JpaRepository<User, Integer> {

	Optional<User> findByLoginUsername(String loginUsername);
	Optional<User> findById(long id);
	Optional<User> deleteById(long id);

}
