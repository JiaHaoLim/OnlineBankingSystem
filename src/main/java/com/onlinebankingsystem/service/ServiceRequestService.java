package com.onlinebankingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.onlinebankingsystem.config.AppConfig;
import com.onlinebankingsystem.dao.AccountJpaRepository;
import com.onlinebankingsystem.dao.interfaces.InterfaceServiceRequestDao;
import com.onlinebankingsystem.service.interfaces.InterfaceServiceRequestService;

public class ServiceRequestService implements InterfaceServiceRequestService {
	@Autowired
	@Qualifier(value = AppConfig.SERVICE_REQUEST_DAO)
	private InterfaceServiceRequestDao serviceRequestDao;
}
