package com.onlinebankingsystem.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	public static final String NAME_COLUMN = "name";
	@Column(name = NAME_COLUMN)
	private String name;
	
	public static final String LOGIN_PASSWORD_COLUMN = "login_password";
	@Column(name = LOGIN_PASSWORD_COLUMN)
	private String password;
	
	public static final String SECRET_QUESTION_COLUMN = "secret_question";
	@Column(name = SECRET_QUESTION_COLUMN)
	private String secretQuestion;
	
	public static final String TRANSACTION_PASSWORD_COLUMN = "transaction_password";
	@Column(name = TRANSACTION_PASSWORD_COLUMN)
	private String transactionPassword;
	
	public static final String LOCK_STATUS_COLUMN = "lock_status";
	@Column(name = LOCK_STATUS_COLUMN)
	private boolean lockStatus;
	
	public User() {}

	public User(String name, String password, String secret_question, String transactionPassword) {
		this.name = name;
		this.password = password;
		this.secretQuestion = secret_question;
		this.transactionPassword = transactionPassword;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	public String getTransactionPassword() {
		return transactionPassword;
	}

	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}

	public boolean getLockStatus() {
		return lockStatus;
	}

	public void setLockStatus(boolean lockStatus) {
		this.lockStatus = lockStatus;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", secretQuestion=" + secretQuestion
				+ ", transactionPassword=" + transactionPassword + ", lockStatus=" + lockStatus + "]";
	}
}
