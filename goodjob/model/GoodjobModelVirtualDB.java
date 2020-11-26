/** 
 * PROJECT  : 재능기부 프로젝트
 * NAME  :  DonationModelVirtualDB.java
 * DESC  :  재능 기부 프로젝트에 사용될 test data 제공 클래스
 * 
 * @author  
 * @version 1.0
 */
package goodjob.model;

import java.util.ArrayList;

import goodjob.model.dto.UserInfo;

public class GoodjobModelVirtualDB {
	private ArrayList<UserInfo> userInfo = new ArrayList<UserInfo>();
	private static GoodjobModelVirtualDB instance = new GoodjobModelVirtualDB();
	
	public GoodjobModelVirtualDB() {
		String n = "null";
		userInfo.add(new UserInfo("dayoung11", "123425", 20, 3.0, 500, 0, "IT",  "S사 3년"));
		userInfo.add(new UserInfo("mingun22",  "234533", 20, 4.0, 600, 0, "기계",  "B사 3년"));
		userInfo.add(new UserInfo("kinghyun33",  "345556", 20, 4.5, 400, 0, "IT",  "A사 6년"));
		userInfo.add(new UserInfo("yeonji44",  "245667", 30, 2.3, 500, 1,  "글쓰기",  "A사 3년"));
		userInfo.add(new UserInfo("yeonsic55",  "345678", 30, 3.7, 200, 0,  "마케팅",  "C사 6년"));
		userInfo.add(new UserInfo("jun66",  "11", 40, 4.8, 1000, 0, "회계",  "D사 3년"));
		userInfo.add(new UserInfo("minjae77",  "592042", 30, 4.0, 600, 1,  "일본어",  "F사 2년"));
		userInfo.add(new UserInfo("sungho88",  "12", 30, 4.5, 200, 0, n, n));
		userInfo.add(new UserInfo("ohmin99",  "350956", 50, 5.0, 500, 0,  "기계",  "S사 1년"));
		userInfo.add(new UserInfo("jiwon100",  "506421", 20, 2.7, 800, 0, n, n));

	}

	/* 구조 동일, 타입만 변경 */
	public static GoodjobModelVirtualDB getInstance() {
		return instance;
	}

	public ArrayList<UserInfo> getUserInfo() {
		return userInfo;
	}

	public void insertProject(UserInfo newUserInfo) {
		userInfo.add(newUserInfo);
	}

}