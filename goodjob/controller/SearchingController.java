/** 
 * PROJECT  : 재능기부 프로젝트
 * NAME  :  TalentDonationController.java
 * DESC  :  사용자로 부터 받은 요청을 처리하는 클래스
 * 			Model 갱신 및 View 제어
 * 
 * @author  
 * @version 1.0
 */

package goodjob.controller;

import java.util.ArrayList;
import java.util.Scanner;

import goodjob.exception.NotExistException;
import goodjob.service.SearchingService;
import goodjob.view.EndView;
import goodjob.view.FailView;

public class SearchingController {

	private static SearchingController instance = new SearchingController();
	private SearchingService service = SearchingService.getInstance();

	private SearchingController() {
	}

	public static SearchingController getInstance() {
		return instance;
	}

	// 특정 직무 검색
	public void getJob() {
		
		System.out.println("직무를 검색해주세요.");
		Scanner sc = new Scanner(System.in);
		String job = sc.nextLine();
		
		if(job.length()!=0) {
			try {
				ArrayList<String> searchingJob = service.getJob(job);
				if (searchingJob != null) {
					EndView.projectListView(searchingJob);
				} 
			} catch (NotExistException e) {
				e.printStackTrace();
				FailView.failMessageView(e.getMessage());
			}
			
		} else {
			FailView.failMessageView("검색어가 입력되지 않았습니다.");
		}
		
	}

}
