
package goodjob.service;

import java.util.ArrayList;

import goodjob.exception.DuplicateException;
import goodjob.exception.NotExistException;
import goodjob.model.GoodjobModelVirtualDB;
import goodjob.model.dto.UserInfo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResumeInfoService {

	/* 구조 동일, 타입 변경 */
	private static ResumeInfoService instance = new ResumeInfoService();

	private GoodjobModelVirtualDB resumeInfoData = GoodjobModelVirtualDB.getInstance();

	private ArrayList<UserInfo> userInfo = resumeInfoData.getUserInfo();

	private ResumeInfoService() {
	}

	public static ResumeInfoService getInstance() {
		return instance;
	}
	/**
	 * 모든 UserInfo 검색(반환)
	 * 
	 * @return 모든 UserInfo
	 */
	public ArrayList<UserInfo> getResumeInfo() {
		log.trace("모든 유저정보 검색");
		return resumeInfoData.getUserInfo();
	}

	// TO DO
	/**
	 * 
	 * return값 --> userInfo
	 * 
	 * ID검색 - UserInfo 반환
	 * 
	 * @param  ID
	 * @return UserInfo 검색된 유저정보, 검색하고자 하는 유저가 없을 경우 null 반환
	 */
	public UserInfo searchUserId(String id) {
		for (UserInfo t : userInfo) {
			if (t.getId().equals(id)) {
				t.setPw("");
				return t;
			}

		}
		return null;

	}

	// TO DO
	/**
	 * 새로운 Career 추가 1개 이상의 커리어를 추가할 경우 DuplicateException 예외 발생
	 * 
	 * @param newCareer, newJob 새로 저장하고자 하는 경력
	 * @throws DuplicateException
	 */
	public void resumeNewCareerInsert(String id, String newCareer) throws DuplicateException {

		UserInfo resume = searchUserId(id);
		if (resume.getCareer() == "null") {
			resume.setCareer(newCareer);
			log.trace("\n=======저장완료=====" + id + newCareer);
		} else {
			throw new DuplicateException("1개 이상의 직무에 관한 커리어는 추가 할 수 없습니다.");
		}

	}

	public void resumeNewJobInsert(String id, String newJob) throws DuplicateException {

		UserInfo resume = searchUserId(id);
		if (resume.getJob() == "null") {
			resume.setJob(newJob);
			log.trace("\n=======저장완료=====" + id + newJob);
		} else {
			throw new DuplicateException("1개 이상의 직무를  추가 할 수 없습니다.");
		}

	}

	// TO DO
	/**
	 * User의 Career, job 수정 - id로검색해서 해당 유저의 resume의 job,career가 존재하는 경우
	 * NotExistException 발생
	 * 
	 * @param ID
	 * @param newCareer, newJob
	 * @throws NotExistException
	 */
	public void resumeNewCareerUpdate(String id, String newCareer) throws NotExistException {
		UserInfo resume = searchUserId(id);
		if (resume.getCareer() != "null") {
			resume.setCareer(newCareer);
			log.trace("\n=======수정완료=====" + id + newCareer);
		} else {
			throw new NotExistException("수정할 id가 존재하지 않습니다.");
		}
	}

	public void resumeNewJobUpdate(String id, String newJob) throws NotExistException {
		UserInfo resume = searchUserId(id);
		if (resume.getJob() != "null") {
			resume.setJob(newJob);
			log.trace("\n=======수정완료=====" + id + newJob);
		} else {
			throw new NotExistException("수정할 id가 존재하지 않습니다.");
		}
	}

	// TO DO
	/**
	 * Carrer,job 삭제 - id로 검색후 해당 id의 career, job삭젠
	 * 
	 * @param id
	 */
	public void UserCareerDelete(String id) throws NotExistException {
		UserInfo ogId = searchUserId(id);
		if (ogId.getCareer() != null) {
			ogId.setCareer("");
			log.trace("해당 id career 삭제 성공 : " + id);
		} else {
			log.trace("해당 id career 삭제 실패 : " + id);
			throw new NotExistException("삭제할 커리어가 존재하지 않습니다.");
		}
	}

	public void UserJobDelete(String id) throws NotExistException {
		UserInfo ogId = searchUserId(id);
		if (ogId.getJob() != null) {
			ogId.setJob("");
			log.trace("해당 id career 삭제 성공 : " + id);
		} else {
			log.trace("해당 id career 삭제 실패 : " + id);
			throw new NotExistException("삭제할 직무가 존재하지 않습니다.");
		}
	}
}