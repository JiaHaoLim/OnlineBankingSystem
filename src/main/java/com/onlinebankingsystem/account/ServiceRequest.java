package com.onlinebankingsystem.account;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "service")
public class ServiceRequest {
	enum Status {
		OPEN,
		FULFILLED,
		DENIED
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	private int id;
	
	public static final String ACCOUNT_ID_COLUMN = "accountID";
	@Column(name = ACCOUNT_ID_COLUMN, nullable = false)
	private int acccountID;
	
	public static final String TYPE_COLUMN = "type";
	@Column(name = TYPE_COLUMN, nullable = false)
	private String type;
	
	public static final String STATUS_COLUMN = "status";
	@Column(name = STATUS_COLUMN, nullable = false)
	private Status status = Status.OPEN;
	
	public static final String DATE_COLUMN = "date";
	@Column(name = DATE_COLUMN, nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date date;

	public ServiceRequest(int acccountID, String type, Status status, Date date) {
		this.acccountID = acccountID;
		this.type = type;
		this.status = status;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAcccountID() {
		return acccountID;
	}

	public void setAcccountID(int acccountID) {
		this.acccountID = acccountID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public String getStatusString() {
		String str = status.name();
		str = str.substring(0, 1) + str.substring(1).toLowerCase();
		
		return str;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
