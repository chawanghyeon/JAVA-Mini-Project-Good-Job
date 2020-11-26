package goodjob.service;

import java.util.ArrayList;

import goodjob.exception.NotExistException;
import goodjob.model.GoodjobModelVirtualDB;
import goodjob.model.dto.UserInfo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SearchingService {

	/* 구조 동일, 타입 변경 */
	private static SearchingService instance = new SearchingService();

	private GoodjobModelVirtualDB userInfoData = GoodjobModelVirtualDB.getInstance();

	private SearchingService() {
	}

	public static SearchingService getInstance() {
		return instance;
	}

	public ArrayList<String> getJob(String job) throws NotExistException {

		ArrayList<UserInfo> jobList = userInfoData.getUserInfo();
		ArrayList<String> resultList = new ArrayList<String>();

		for (int i = 0; i < jobList.size(); i++) {
			if (jobList.get(i).getJob().equals(job)) {
				//					jobList.get(i).setPw("");
				resultList.add(jobList.get(i).toString());
			} 
		} 
		if(job != null && resultList.size() == 0) {
			throw new NotExistException("해당하는 직무의 데이터가 없습니다.");
		} 
		return resultList;
	} 
}
