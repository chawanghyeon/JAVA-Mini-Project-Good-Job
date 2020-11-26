package goodjob.controller;

import java.util.Scanner;

import goodjob.exception.NotExistException;
import goodjob.view.EndView;

public class TotalController {
	Scanner sc = new Scanner(System.in);
	private static TotalController instance = new TotalController();

	public TotalController() {
	}

	public static TotalController getInstance() {
		return instance;
	}

	// 로그인
	private LoginController loginController = LoginController.getInstance();

	// 이력서관리                  
	private ResumeInfoController resumeInfoController = ResumeInfoController.getInstance();

	// 검색
	private SearchingController searchingController = SearchingController.getInstance();

	// 마켓
	private MarketController marketController = MarketController.getInstance();
	//코인
	private GoodJobController coinController = GoodJobController.getInstance();
	// 통합 구현
	public void totalMethod() throws NotExistException {
		String ID = loginController.loginService();
		if (ID.equals("null")) {
			EndView.messageView("로그인에 실패했습니다");
		} else {
			EndView.messageView("선택하세요");
			EndView.messageView("1.멘토 검색 2.이력서 관리 3.질의응답 4.마켓 5.종료");
			int s = choosesection();
			if(s == 1) {
				searchingController.getJob();
			} else if (s == 2) {
				resumeInfoController.resumeInfoAll(ID);
			} else if(s == 3) {
				coinController.coinsection(ID);
			} else if(s == 4) {
				marketController.marketControllerAll();
			}
		}
	}
	
	public int choosesection() {
		String s =sc.next();
		int i = Integer.parseInt(s);
		return i;
	}

}
