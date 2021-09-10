package com.onlinebankingsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountHolderController {
	public static final String JSP_MINI_STATEMENT = "ministatement";
	public static final String JSP_DETAILED_STATEMENT = "detailedstatement";
	
	public static final String URL_MINI_STATEMENT = "/" + JSP_MINI_STATEMENT;
	public static final String URL_DETAILED_STATEMENT = "/" + JSP_DETAILED_STATEMENT;
	
	@PostMapping(URL_MINI_STATEMENT)
	public String viewMiniStatement() {
		
	}
}
