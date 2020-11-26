package goodjob.service;

import goodjob.exception.NotExistException;
import goodjob.view.EndView;

public class MarketService {
	
	private static MarketService instance = new MarketService();

	private MarketService() {
	}

	public static MarketService getInstance() {
		return instance;
	}

	public void jobInterview() throws InterruptedException {
		EndView.messageView("자기소개 해주세요(1분)");
		Thread.sleep(60000);
		EndView.messageView("왜 우리 회사에서 일하고 싶습니까?(30초)");
		Thread.sleep(30000);
		EndView.messageView("지원자의 장점과 단점은 무엇입니까?(30초)");
		Thread.sleep(30000);
		EndView.messageView("우리 회사에서 귀하를 채용해야 하는 이유를 말해주세요.(30초)");
		Thread.sleep(30000);
		EndView.messageView("모의 면접이 끝났습니다.");

	}

	public int resumeWordsLengthCheck(String input) throws NotExistException {
		if (input == null || input.isEmpty()) {
			throw new NotExistException("자소서의 길이가 0입니다.");
		}
		String[] words = input.split("\\s+");
		return words.length;
	}
	
	public int resumeLengthCheck(String input) throws NotExistException {
		if (input == null || input.isEmpty()) {
			throw new NotExistException("자소서의 길이가 0입니다.");
		}
		return input.length();
	}

	public void aptitudeTest() throws InterruptedException {
		EndView.messageView("<보기>의 조건만으로 알 수 있는 것은?");
		EndView.messageView("<보기>\n 비가 오는 날이면 길동이는 길순이를 생각한다." + "\n비가 오는 날이면 길동이도 길순이를 생각한다.");
		EndView.messageView("\n1. 비가 오는 날이면 갑돌이는 갑순이를 만난 적이 있다.\n" + "2. 길동이도 갑돌이만큼 갑순이를 좋아한 적이 있다.\n"
				+ "3. 갑돌이, 갑순이, 길동이는 서로 알고 지내는 사이다.\n" + "4. 비가 오는 날이면 갑순이를 생각하는 사람들이 있다.");
		Thread.sleep(10000);
		EndView.messageView("정답은 4번 입니다.");
	}

	

	
}