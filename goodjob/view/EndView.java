/** 
 * PROJECT  : 재능기부 프로젝트
 * NAME  :  RunningEndView.java
 * DESC  : 재능 기부 정보 출력 클래스
 * 
 * @author  
 * @version 1.0
*/

package goodjob.view;

import java.util.ArrayList;

import goodjob.model.dto.QnA;
import goodjob.model.dto.UserInfo;

public class EndView {

	// 특정 직무 검색 후 출력
	public static void projectView(UserInfo userInfo) {
		if (userInfo != null) {
			System.out.println(userInfo.toString().toString().replaceAll("^\\[", "").replaceAll("\\]$", "").replace(",", ""));
		} else {
			System.out.println("해당 프로젝트는 존재하지 않습니다.");
		}
	}

	// 모든 정보 출력
	public static void projectListView(ArrayList<String> allJob) {
		for (String user : allJob) {
			System.out.println(user);
		}
	}

	// 예외가 아닌 단순 메세지 출력
	public static void messageView(String message) {
		System.out.println(message);
	}
	public static void UserView(UserInfo user) {
		if (user != null) {
			System.out.println(user);
		} else {
			System.out.println("불가");
		}
	}
	public static void UserListView(ArrayList<UserInfo> userlist) {
		for (UserInfo user : userlist) {
			System.out.println(user);
		}
	}
	
	public static void qnaListView(ArrayList<QnA> qnalist) {
		int i = 1;
		for (QnA list : qnalist) {
			System.out.println(i +":"+list);
			i++;
		}
	}
	
	public static void qListView(ArrayList<QnA> qnalist) {
		int i = 1;
		for (QnA list : qnalist) {
			System.out.println(i+ "\n질문id : "+list.getIdq()+"\n"+"질문 : "+ list.getMq());
			i++;
		}
	}
	
	public static void QnAView(QnA q) {
		if (q != null) {
			System.out.println(q);
		} else {
			System.out.println("불가");
		}
	}
	
	public static void qView(QnA q) {
		if (q != null) {
			System.out.println("질문id : "+q.getIdq()+"\n"+"질문 : "+ q.getMq());
		} else {
			System.out.println("불가");
		}
	}
}
