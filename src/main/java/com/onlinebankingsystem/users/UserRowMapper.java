package com.onlinebankingsystem.users;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("Inside UserRowMapper at row: "+rowNum);
		String name = rs.getString("name");
		String login_username = rs.getString("login_username");
		String login_password = rs.getString("login_password");
		String secret_question = rs.getString("secret_question");
		String secret_answer = rs.getString("secret_answer");
		int num_failed_logins = rs.getInt("num_failed_logins");
		boolean lock_status = rs.getBoolean("lock_status");
		return new User(name, login_username, login_password, secret_question, secret_answer, num_failed_logins, lock_status);
	}

}
