package goodjob.controller;

import java.util.ArrayList;
import java.util.Scanner;

import goodjob.exception.NotExistException;
import goodjob.service.LoginService;
import goodjob.view.EndView;
import goodjob.view.FailView;

public class LoginController {

	private static LoginController instance = new LoginController();
	private LoginService service = LoginService.getInstance();
	
	private LoginController() {
	}

	public static LoginController getInstance() {
		return instance;
	}

	/*
	 * 로그인
	 * 
	 */
	public String loginService() {
		
		try {
			String id = service.searchId();
			EndView.messageView(id);
			return id;
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
			return "null";
		}

	}
}