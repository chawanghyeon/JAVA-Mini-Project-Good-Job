/** 
 * PROJECT  : 재능기부 프로젝트
 * NAME  :  NotExistException.java
 * DESC  :  검색 데이터가 없을 경우 발생시키는 사용자 정의 예외 클래스
 * 
 * @author  
 * @version 1.0
*/
package goodjob.exception;

public class NotExistException extends Exception {
	public NotExistException() {
	}

	public NotExistException(String message) {
		super(message);
	}
}
