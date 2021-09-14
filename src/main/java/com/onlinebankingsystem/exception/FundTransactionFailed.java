package com.onlinebankingsystem.exception;

public class FundTransactionFailed extends RuntimeException {
	
	private boolean transcationFailed;
	
	public FundTransactionFailed(boolean transcationFailed)
	{
		this.transcationFailed = transcationFailed;
	}
	public boolean getTranscationFailed()
	{
		return transcationFailed;
	}

}
