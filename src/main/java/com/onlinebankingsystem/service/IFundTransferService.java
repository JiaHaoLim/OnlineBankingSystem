package com.onlinebankingsystem.service;

import com.onlinebankingsystem.account.Account;

public interface IFundTransferService {
	public boolean transfer(String a, String b , double amountXfer);
}
