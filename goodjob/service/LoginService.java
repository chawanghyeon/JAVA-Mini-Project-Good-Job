package goodjob.service;

import java.util.ArrayList;
import java.util.Scanner;

import goodjob.model.GoodjobModelVirtualDB;
import goodjob.model.dto.UserInfo;
import goodjob.exception.NotExistException;

public class LoginService {
	private static LoginService instance = new LoginService();

	private GoodjobModelVirtualDB userInfoData = GoodjobModelVirtualDB.getInstance();

	public LoginService() {
	}

	public static LoginService getInstance() {
		return instance;
	}

	public String searchId() throws NotExistException {
		ArrayList<UserInfo> userInfo = userInfoData.getUserInfo();
		Scanner scan = new Scanner(System.in);
		System.out.println("ID를 입력하세요:");
		String ID = scan.nextLine();
		System.out.println("비밀번호를 입력하세요:");
		String PW = scan.nextLine();

		int i = 0;

		for (UserInfo u : userInfo) {
			if (u.getId().equals(ID)) {
				i += 1;
				break;
			}
		}
		for (UserInfo u : userInfo) {
			if (u.getId().equals(ID) && u.getPw().equals(PW)) {
				i += 3;
				break;
			}
		}
		if (i == 0) {
			throw new NotExistException("존재하지 않는 ID입니다");
		} else if (i == 1) {
			throw new NotExistException("비밀번호를 잘못 입력하셨습니다.");
		} else if(i == 4) {
			System.out.println("로그인 성공");
			return ID;
		} 
		return null;
	}
}