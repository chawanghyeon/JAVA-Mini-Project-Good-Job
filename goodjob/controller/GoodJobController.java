package goodjob.controller;
import java.util.ArrayList;
import java.util.Scanner;
import goodjob.exception.BoundException;
import goodjob.exception.NotExistException;
import goodjob.model.dto.QnA;
import goodjob.model.dto.UserInfo;
import goodjob.service.GoodJobService;
import goodjob.view.EndView;
import goodjob.view.FailView;
public class GoodJobController {
	private static GoodJobController instance = new GoodJobController();
	private GoodJobService service = GoodJobService.getInstance();
	Scanner sc = new Scanner(System.in);
	
	ArrayList<QnA> qnalist = service.getQnAlist();
	ArrayList<UserInfo> userlist = service.getUserlist();
	
	
	public GoodJobController() {
	}
	public static GoodJobController getInstance() {
		return instance;
	}
	
	public void coinsection(String id) {
		try {
			int i =0;
			while(i != 8) {
				i = service.coinsection();
				if(i == 1) {
					insertQ(id);
				}else if(i == 2) {
					insertA(id);
				}else if(i == 3) {
					evaluateStar(id);
				}else if(i == 4) {
					chargeCoin(id);
				}else if(i == 5) {
					EndView.qListView(qnalist);
				}else if(i == 6) {
					EndView.UserListView(userlist);
				}else if(i == 7) {
					EndView.qnaListView(qnalist);
				}
				
			}
			EndView.messageView("종료되었습니다");
		} catch (BoundException e) {
			FailView.failMessageView("해당하는 메뉴 번호가 없습니다.");
		}
	}
	public void getQnAList() {
		if (qnalist.size() != 0) {
			EndView.qnaListView(qnalist);
		} else {
			EndView.messageView("불가");
		}
	}
	
	public void getUserList() {
		if (userlist.size() != 0) {
			EndView.UserListView(userlist);
		} else {
			EndView.messageView("불가");
		}
	}
	
	public void insertQ(String id) {
		try {
			service.insertQ(id);
			EndView.messageView("답변 입력 성공");
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
		
	}
	
	public void insertA(String id) {
		try {
			try {
				service.inserA(id);
			} catch (NotExistException e) {
				FailView.failMessageView(e.getMessage());
			}
			EndView.messageView("답변 입력 성공");
		} catch (BoundException e) {
			EndView.messageView("존재하지 않는 인덱스입니다.");
		}
	}
	
	public void chargeCoin(String id) {
		service.chargeCoin(id);
	}
	
	public void evaluateStar(String id) {
		service.evaluateStar(id);
	}
}