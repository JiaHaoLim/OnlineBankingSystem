package com.onlinebankingsystem.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

<<<<<<< Updated upstream
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
@Entity(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
=======
@Entity
@Table(name = "users") // table name is users 
public class User {
	@Id // primary key created
	@GeneratedValue(strategy = GenerationType.AUTO) //specify auto_increment in the definition of table to make it self-incremental
>>>>>>> Stashed changes
	private int id;
	
	public static final String NAME_COLUMN = "name";
	@Column(name = NAME_COLUMN) // giving name to table columns
	private String name;
	
	public static final String LOGIN_USERNAME_COLUMN = "login_username";
	@Column(name = LOGIN_USERNAME_COLUMN, unique = true)
	private String loginUsername;
	
	public static final String LOGIN_PASSWORD_COLUMN = "login_password";
	@Column(name = LOGIN_PASSWORD_COLUMN)
	private String loginPassword;
	
	public static final String SECRET_QUESTION_COLUMN = "secret_question";
	@Column(name = SECRET_QUESTION_COLUMN)
	private String secretQuestion;
	
	public static final String SECRET_ANSWER_COLUMN = "secret_answer";
	@Column(name = SECRET_ANSWER_COLUMN)
	private String secretAnswer;
	
	public static final String NUM_FAILED_LOGINS_COLUMN = "num_failed_logins";
	@Column(name = NUM_FAILED_LOGINS_COLUMN)
	private int numFailedLogins;
	
	public static final String LOCK_STATUS_COLUMN = "lock_status";
	@Column(name = LOCK_STATUS_COLUMN)
	private boolean isLocked;
	
	public User() {}
	
	public User(String name, String loginUsername, String loginPassword, String secretQuestion, String secretAnswer) {
		this.name = name;
		this.loginUsername = loginUsername;
		this.loginPassword = loginPassword;
		this.secretQuestion = secretQuestion;
		this.secretAnswer = secretAnswer;
	}

	public User(String name, String loginUsername, String loginPassword, String secretQuestion, String secretAnswer,
			int numFailedLogins, boolean isLocked) {
		this.name = name;
		this.loginUsername = loginUsername;
		this.loginPassword = loginPassword;
		this.secretQuestion = secretQuestion;
		this.secretAnswer = secretAnswer;
		this.numFailedLogins = numFailedLogins;
		this.isLocked = isLocked;
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

	public String getLoginUsername() {
		return loginUsername;
	}

	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
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
}
