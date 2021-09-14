package com.onlinebankingsystem.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinebankingsystem.account.ServiceRequest;
import com.onlinebankingsystem.config.AppConfig;
import com.onlinebankingsystem.dao.interfaces.InterfaceServiceRequestDao;

@Repository(value = AppConfig.SERVICE_REQUEST_JPA)
public interface ServiceRequestJpaRepository extends InterfaceServiceRequestDao, JpaRepository<ServiceRequest, Integer> {


}
