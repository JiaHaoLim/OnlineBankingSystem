package com.onlinebankingsystem.users;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
@Entity(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User extends Login {
	enum Role {
		ACCOUNT_HOLDER,
		BANK_ADMIN
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	protected int id;
	
	public static final String NAME_COLUMN = "name";
	@Column(name = NAME_COLUMN, nullable = false)
	protected String name;
	
	public static final String SECRET_QUESTION_COLUMN = "secret_question";
	@Column(name = SECRET_QUESTION_COLUMN, nullable = false)
	protected String secretQuestion;
	
	public static final String SECRET_ANSWER_COLUMN = "secret_answer";
	@Column(name = SECRET_ANSWER_COLUMN, nullable = false)
	protected String secretAnswer;
	
	public static final String NUM_FAILED_LOGINS_COLUMN = "num_failed_logins";
	@Column(name = NUM_FAILED_LOGINS_COLUMN)
	protected int numFailedLogins = 0;
	
	public static final String IS_LOCKED_COLUMN = "is_locked";
	@Column(name = IS_LOCKED_COLUMN)
	protected boolean isLocked = false;
	
	public static final String DATE_COLUMN = "date_created";
	@Column(name = DATE_COLUMN, nullable = false)
	@Temporal(value = TemporalType.TIMESTAMP)
	protected Date dateCreated;
	
	public static final String ROLE_COLUMN = "role";
	@Enumerated(EnumType.STRING)
	@Column(name = ROLE_COLUMN, nullable = false)
	protected Role role;
	
	public User() {}
	
	public User(String name, String username, String password, String secretQuestion, String secretAnswer) {
		this();
		this.name = name;
		this.username = username;
		this.password = password;
		this.secretQuestion = secretQuestion;
		this.secretAnswer = secretAnswer;
		dateCreated = new Date();
	}

	public User(String name, String username, String password, String secretQuestion, String secretAnswer,
			int numFailedLogins, boolean isLocked, Date dateCreated) {
		this(name, username, password, secretQuestion, secretAnswer);
		this.numFailedLogins = numFailedLogins;
		this.isLocked = isLocked;
		this.dateCreated = dateCreated;
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

	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	public String getSecretAnswer() {
		return secretAnswer;
	}

	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}

	public int getNumFailedLogins() {
		return numFailedLogins;
	}

	public void setNumFailedLogins(int numFailedLogins) {
		this.numFailedLogins = numFailedLogins;
	}
	
	public void addNumFailedLogins() {
		++numFailedLogins;
	}
	
	// Used by Java
	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}
	
	// Used by Spring
	public boolean getIsLocked() {
		return isLocked();
	}
	
	public void setIsLocked(boolean isLocked) {
		setLocked(isLocked);
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
