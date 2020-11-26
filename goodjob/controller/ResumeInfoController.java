package goodjob.controller;

import java.util.Scanner;

import goodjob.exception.DuplicateException;
import goodjob.exception.NotExistException;
import goodjob.model.dto.UserInfo;
import goodjob.service.MarketService;
import goodjob.service.ResumeInfoService;
import goodjob.view.EndView;
import goodjob.view.FailView;

public class ResumeInfoController {

	private static ResumeInfoController instance = new ResumeInfoController();
	private ResumeInfoService resumeService = ResumeInfoService.getInstance();
	private MarketService marketService = MarketService.getInstance();

	private ResumeInfoController() {

	}

	public static ResumeInfoController getInstance() {
		return instance;
	}

	// TO DO
	/**
	 * 프로젝트 이름으로 특정 프로젝트 검색
	 * 
	 * @param projectName
	 */
	public void getUserId(String id) {
		if (id != null) {
			UserInfo userInfo = resumeService.searchUserId(id);
			if (userInfo != null) {
				EndView.projectView(userInfo);
			} else {
				FailView.failMessageView("현재 검색한 id에 대한 정보는 존재하지 않습니다.");
			}
		}
	}

	// TO DO
	/**
	 * 새로운 Career, job 저장
	 * 
	 * @param newCareer, newJob
	 */
	public void insertResumeNewCareer(String id, String newCareer) {
		if (id != null && newCareer != null) {
			try {
				resumeService.resumeNewCareerInsert(id, newCareer);

			} catch (DuplicateException e) {
				FailView.failMessageView(e.getMessage());
			}
		} else {
			FailView.failMessageView("삽입할 경력이 존재하지 않습니다.");
		}
	}

	public void insertResumeNewJob(String id, String newJob) {
		if (id != null && newJob != null) {
			try {
				resumeService.resumeNewJobInsert(id, newJob);
			} catch (DuplicateException e) {
				FailView.failMessageView(e.getMessage());
			}
		} else {
			FailView.failMessageView("삽입할 직무가 존재하지 않습니다.");
		}
	}

	/**
	 * 존재하는 유저의 id로 검색해서 해당하는 유저의 career, job 수정
	 * 
	 * @param id
	 * @param newCareer, newJob
	 */
	public void updateResumeNewCareer(String id, String newCareer) {
		if (id != null && newCareer != null) {
			try {
				resumeService.resumeNewCareerUpdate(id, newCareer);
			} catch (NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}
		} else if (newCareer == null) {
			FailView.failMessageView("수정하고자 하는 경력의 정보가 무효합니다, 재 확인 해 주세요");
		} else {
			FailView.failMessageView("무효한 id입니다. 재 확인 해 주세요");
		}
	}

	public void updateResumeNewJob(String id, String newJob) {
		if (id != null && newJob != null) {
			try {
				resumeService.resumeNewJobUpdate(id, newJob);
			} catch (NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}
		} else if (newJob == null) {
			FailView.failMessageView("수정하고자 하는 경력의 직무가 무효합니다, 재 확인 해 주세요");
		} else {
			FailView.failMessageView("무효한 id입니다. 재 확인 해 주세요");
		}
	}

	// TO DO
	/**
	 * id으로 해당하는 Career, Job 삭제(null값으로 변환)
	 * 
	 * @param id
	 */
	public void deleteUserCareer(String id) {
		if (id != null) {
			try {
				resumeService.UserCareerDelete(id);
			} catch (NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}
		} else {
			FailView.failMessageView("무효한 id 입니다, 재 확인 해 주세요");
		}
	}

	public void deleteUserJob(String id) {
		if (id != null) {
			try {
				resumeService.UserJobDelete(id);
			} catch (NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}
		} else {
			FailView.failMessageView("무효한 id 입니다, 재 확인 해 주세요");
		}
	}

	public void resumeInfoAll(String id) throws NotExistException {
		ResumeInfoController resumeInfoController = ResumeInfoController.getInstance();
		System.out.println("1-1.Job 저장 1-2.Career 저장\n2-1.Job 수정 2-2.Career 수정\n3-1.Job 삭제 3-2.Career 삭제");
		Scanner sc = new Scanner(System.in);
		String choice = sc.nextLine();
		String newJob;
		String newCareer;
		switch (choice) {
		case "1-1":
			System.out.println("저장하실 직무를 입력해주세요.");
			newJob = sc.nextLine();
			resumeInfoController.insertResumeNewJob(id, newJob);
			break;
		case "1-2":
			System.out.println("저장하실 Career를 입력해주세요.");
			newCareer = sc.nextLine();
			resumeInfoController.insertResumeNewCareer(id, newCareer);
			break;
		case "2-1":
			System.out.println("수정하실 직무를 입력해주세요.");
			newJob = sc.nextLine();
			resumeInfoController.updateResumeNewJob(id, newJob);
			break;
		case "2-2":
			System.out.println("수정하실 Career를 입력해주세요.");
			newCareer = sc.nextLine();
			resumeInfoController.updateResumeNewCareer(id, newCareer);
			break;
		case "3-1":
			System.out.println("삭제하실 직무를 입력해주세요.");
			resumeInfoController.deleteUserJob(id);
			break;
		case "3-2":
			System.out.println("삭제하실 Career를 입력해주세요.");
			resumeInfoController.deleteUserCareer(id);
			break;
		default:
			throw new NotExistException("잘 못 입력했습니다.");
		}
	}

}