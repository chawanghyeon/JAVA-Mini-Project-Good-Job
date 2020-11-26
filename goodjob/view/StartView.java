/** 
 * PROJECT  : 재능기부 프로젝트
 * NAME  :  StartView.java
 * DESC  : 실행 클래스
 * 
 * @author  
 * @version 1.0
 */

package goodjob.view;

import goodjob.controller.TotalController;
import goodjob.exception.NotExistException;

public class StartView {

	public static void main(String[] args) throws NotExistException {

		TotalController tController = TotalController.getInstance();

		tController.totalMethod();
//		tController.getLoginController().loginService();
//		tController.getResumeInfoController();
//		tController.getSearchingController();
//
//		System.out.println("\n*** 02. 'dayoung11'라는 이름의 user 검색 ***");
//		tController.getResumeInfoController().getUserId("dayoung11");
//
//		System.out.println("\n*** 03. 미존재하는 Project 검색 ***");
//		tController.getResumeInfoController().getUserId("yskim137");
//
//		// Career, Job이 없는 유저가 새로운 Career,Job 생성해서 저장 및 검색
//		System.out.println("\n*** 04. 'Z사 5년', 건축 이라는 새로운 Career, Job 저장 후  해당 프로젝트 검색 ***");
//
//		System.out.println("\n04-1. 저장 전 프로젝트 검색");
//		tController.getResumeInfoController().getUserId("sungho88");
//
//		tController.getResumeInfoController().insertResumeNewCareer("sungho88", "Z사 5년");
//		tController.getResumeInfoController().insertResumeNewJob("sungho88","건축");
//
//		System.out.println("\n04-2. 저장 후 검색");
//		tController.getResumeInfoController().getUserId("sungho88");
//
//		System.out.println("\n04-3. 이미 저장된 프로젝트 재저장 시도후 유효성 검증의 적합성 검증");
//		tController.getResumeInfoController().insertResumeNewCareer("sungho88", "Z사 5년");
//		tController.getResumeInfoController().insertResumeNewJob("sungho88","건축");
//
//		// 저장 로직의 유효성 처리 로직 검증
//		System.out.println("\n*** 05. 의미없는 데이터인 null로 Career,Job 저장 시도 후 유효성 로직의 적합성 검증 ***");
//		tController.getResumeInfoController().insertResumeNewCareer("sungho88", null);
//		tController.getResumeInfoController().insertResumeNewJob("sungho88",null);
//
//		// 존재하는 Career, Job 값 수정 후 검색
//		System.out.println("\n*** 06. 존재하는 'mingun22'의 Career, Job 변경 후 수정한 내용 검색 ***");
//		System.out.println("06-1. 수정 전 'mingun22' 검색");
//		tController.getResumeInfoController().getUserId("mingun22");
//
//		tController.getResumeInfoController().updateResumeNewCareer("mingun22", "H사 3년");
//		tController.getResumeInfoController().updateResumeNewJob("mingun22", "로봇");
//
//		System.out.println("\n06-2. 수정 후 'mingun22' 검색");
//		tController.getResumeInfoController().getUserId("mingun22");
//
//		System.out.println("\n*** 07. 의미없는 데이터인 null로 'mingun22'의 Career, Job 수정 시도 후 유효성 로직의 적합성 검증 ***");
//		tController.getResumeInfoController().updateResumeNewCareer(null , "H사 3년");
//		tController.getResumeInfoController().updateResumeNewJob("mingun22", null);
//
//		// 'dayoung11' Career, Job 삭제 후 검색
//		System.out.println("\n*** 08. 'dayoung11'의 Carreer 삭제 후 삭제한 Career 검색 ***");
//		System.out.println("08-1. 삭제전 프로젝트 검색");
//		tController.getResumeInfoController().getUserId("dayoung11");
//
//		tController.getResumeInfoController().deleteUserCareer("dayoung11");
//		tController.getResumeInfoController().deleteUserJob("dayoung11");
//
//		System.out.println("\n08-2. 삭제 후 프로젝트 검색 ");
//		tController.getResumeInfoController().getUserId("dayoung11");
//
//		System.out.println("\n08-3. 삭제된 프로젝트 삭제 재시도 후 유효성 로직의 적합성 검증");
//		tController.getResumeInfoController().deleteUserCareer("dayoung11");
//		tController.getResumeInfoController().deleteUserJob("dayoung11");
//
//		System.out.println("\n자소서 단어수 확인");
//		tController.getMarketController().resumeWordsLengthCheck("da as as", 1);
//
//		System.out.println("\n자소서 길이 확인");
//		tController.getMarketController().resumeLengthCheck("da as as", 1);
//
//		System.out.println("\n인적성 검사");
//		tController.getMarketController().aptitudeTest(20);
//
//		System.out.println("\n모의 면접");
//		tController.getMarketController().jobInterview(11);

	}
}
