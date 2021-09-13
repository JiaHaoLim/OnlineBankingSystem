package com.onlinebankingsystem.account;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "service_request")
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
	
	public static final String ACCOUNT_ID_COLUMN = "accountId";
	@Column(name = ACCOUNT_ID_COLUMN, nullable = false)
	private int acccountId;
	
	public static final String TYPE_COLUMN = "type";
	@Column(name = TYPE_COLUMN, nullable = false)
	private String type;
	
	public static final String STATUS_COLUMN = "status";
	@Column(name = STATUS_COLUMN, nullable = false)
	private Status status = Status.OPEN;
	
	public static final String DATE_COLUMN = "date_created";
	@Column(name = DATE_COLUMN, nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date dateCreated;

	public ServiceRequest() {}
	
	public ServiceRequest(int acccountId, String type, Status status) {
		this.acccountId = acccountId;
		this.type = type;
		this.status = status;
		this.dateCreated = new Date();
	}
	
	public ServiceRequest(int acccountId, String type, Status status, Date dateCreated) {
		this.acccountId = acccountId;
		this.type = type;
		this.status = status;
		this.dateCreated = dateCreated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAcccountId() {
		return acccountId;
	}

	public void setAcccountId(int acccountId) {
		this.acccountId = acccountId;
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

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
}
