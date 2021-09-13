package com.onlinebankingsystem.service.interfaces;

public interface InterfaceAccountHolderService {

	boolean modifyMobile(int accountId, String mobileNumber);

	boolean modifyAddress(int accountId, String address);
	
}
