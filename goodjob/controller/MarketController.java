package goodjob.controller;

import java.util.Scanner;

import goodjob.exception.NotExistException;
import goodjob.service.MarketService;
import goodjob.view.EndView;
import goodjob.view.FailView;

public class MarketController {

	private static MarketController instance = new MarketController();
	private MarketService marketService = MarketService.getInstance();

	private MarketController() {

	}

	public static MarketController getInstance() {
		return instance;
	}

	public void jobInterview(int coins) {
		if (coins > 0) {
			try {
				marketService.jobInterview();
				coins--;
			} catch (InterruptedException e) {
				FailView.failMessageView(e.getMessage());
			}
		} else {
			FailView.failMessageView("코인이 부족합니다.");
		}
	}

	public void resumeWordsLengthCheck(String str, int coins) {
		if (coins > 0) {
			try {
				int resumeWordsLength = marketService.resumeWordsLengthCheck(str);
				String result = "자소서의 단어수는 " + resumeWordsLength + "입니다.";
				EndView.messageView(result);
				coins--;
			} catch (NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}
		} else {
			FailView.failMessageView("코인이 부족합니다.");
		}
	}

	public void resumeLengthCheck(String str, int coins) {
		if (coins > 0) {
			try {
				int resumeLength = marketService.resumeLengthCheck(str);
				String result = "자소서의 길이는 " + resumeLength + "입니다.";
				EndView.messageView(result);
				coins--;
			} catch (NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}
		} else {
			FailView.failMessageView("코인이 부족합니다.");
		}
	}

	public void aptitudeTest(int coins) {
		if (coins > 0) {
			try {
				marketService.aptitudeTest();
			} catch (InterruptedException e) {
				FailView.failMessageView(e.getMessage());
			}
			coins--;
		} else {
			FailView.failMessageView("코인이 부족합니다.");
		}
	}
	
	public void marketControllerAll () {
		 MarketService marketService = MarketService.getInstance();
		EndView.messageView("1.모의 면접 2.자소서 단어수 확인 3.자소서 글자수 확인");
		Scanner sc  = new Scanner(System.in);
		String s = sc.nextLine();
		
		
		if(s.equals("1")) {
			try {
				marketService.jobInterview();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (s.equals("2")) {
			try {
				String s1 = sc.nextLine();
				marketService.resumeWordsLengthCheck(s1);
			} catch (NotExistException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(s.equals("3")) {
			String s2 = sc.nextLine();
			try {
				marketService.resumeLengthCheck(s2);
			} catch (NotExistException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} 
//		else if(s.equals("4"){
//			aptitudeTest(0);
//		}
	}
}
