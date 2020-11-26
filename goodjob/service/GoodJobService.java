package goodjob.service;
import java.util.ArrayList;
import java.util.Scanner;
import goodjob.exception.BoundException;
import goodjob.exception.NotExistException;
import goodjob.model.GoodjobModelVirtualDB;
import goodjob.model.QnADB;
import goodjob.model.dto.QnA;
import goodjob.model.dto.UserInfo;
import goodjob.view.EndView;
public class GoodJobService {
	private static GoodJobService instance = new GoodJobService();
	private QnADB qnaData =QnADB.getInstance();
	private GoodjobModelVirtualDB userData =GoodjobModelVirtualDB.getInstance();
	Scanner sc = new Scanner(System.in);
	QnADB a = new QnADB();
	GoodjobModelVirtualDB b = new GoodjobModelVirtualDB();
	
	private GoodJobService() {
	}
	public static GoodJobService getInstance() {
		return instance;
	}
	
	
	ArrayList<QnA> qnalist = a.getqnalist();
	ArrayList<UserInfo>	userlist = b.getUserInfo();
	
	
	
	public ArrayList<QnA> getQnAlist(){
		return a.getqnalist();
	}
	
	public ArrayList<UserInfo> getUserlist(){
		return b.getUserInfo();
	}
	
	public void insertQ(String id) throws NotExistException{
		String n = "null";
		EndView.messageView("무엇이 궁금하십니까");
		String message = sc.nextLine();
		EndView.messageView("질문의 분야가 무엇입니까");
		String type = sc.nextLine();
		for (int i=0; i< qnalist.size();i++) {
			String qnaType = qnalist.get(i).getType();
			if(type.equals(qnaType)) {
				break;
			}
			if(i == qnalist.size()-1) {
				throw new NotExistException("잘못된 분야입니다");
			}
		}
		QnA a = new QnA(id, message, n, n, type);
		qnalist.add(a);
	}
	
	public void inserA(String id) throws BoundException, NotExistException  {
		ArrayList<QnA> candi = new ArrayList<>();
		ArrayList<Integer> order = new ArrayList<>();
		int o = 0;
		EndView.messageView("답변할 질문 분야를 입력해주세요");
		String type = sc.nextLine();
		for (int i=0; i< qnalist.size();i++) {
			String qnaType = qnalist.get(i).getType();
			if(type.equals(qnaType)) {
				break;
			}
			if(i == qnalist.size()-1) {
				throw new NotExistException("잘못된 분야입니다");
			}
		}
		
		for(QnA q : qnalist) {
			if(q.getType().equals(type)) {
				candi.add(q);
				order.add(o);
			}
			o++;
		}
		ArrayList<QnA> candi2 = new ArrayList<>();
		for(QnA a : candi) {
			if(!candi2.contains(a)) {
				candi2.add(a);
			}
		}
		int subo = 1;
		for(QnA p : candi2) {
			EndView.messageView(Integer.toString(subo));
			EndView.qView(p);
			subo++;
		}
		EndView.messageView("답변할 질문을 택해주세요");
		String index = sc.nextLine();
		int i = Integer.parseInt(index)-1;
				
		if(i<0 || i>= candi.size()) {
			throw new BoundException();
		}else {
			EndView.messageView("답변할 내용을 입력해주세요");
			String message = sc.nextLine();
			QnA r = new QnA();
			for(QnA p : qnalist) {
				if(p.getMq().equals(candi.get(i).getMq())) {
					if(candi.get(i).getMa() =="null") {
						qnalist.get(order.get(i)).setIda(id);
						qnalist.get(order.get(i)).setMa(message);					
					}else {
						r = candi.get(i);
						r.setIda(id);
						r.setMa(message);
					}
				}
			}
			if(!(r.getIda().equals(null))) {
				qnalist.add(r);
			}
			
		}
		
	}
	
	public void chargeCoin(String id) {
		EndView.messageView("얼마를 충전하시겠습니까");
		String coin = sc.nextLine();
		int c = Integer.parseInt(coin);
		for(UserInfo u : userlist) {
			if(u.getId().equals(id)) {
				int o = u.getCoins();
				u.setCoins(o+c);
			}
		}
	}
	
	public ArrayList<QnA> view(String id) {
		ArrayList<QnA> myq = new ArrayList<>();
		for(QnA q : qnalist) {
			if(q.getIdq().equals(id)) {
				myq.add(q);
			}
		}
		EndView.qnaListView(myq);
		return myq;
	}
	
	public void evaluateStar(String id) {
		ArrayList<QnA> myq = new ArrayList<>();
		myq = view(id);
		
		EndView.messageView("평가할 질문을 선택하세요");
		String index = sc.nextLine();
		int i = Integer.parseInt(index)-1;
		if(checkwarining(myq.get(i).getIda())==1) {
			EndView.messageView("신고가 접수되었습니다.");
		}else {
			EndView.messageView("해당 답변은 몇 점입니까?");
			String rating = sc.nextLine();
			double r = Double.parseDouble(rating);
			int num = 0;
			QnA Answer = myq.get(i);
			for(QnA n : qnalist) {
				if(n.getIda().equals(Answer.getIda())) {
					num++;
				}
			}
			UserInfo target = new UserInfo();
			for(UserInfo u : userlist) {
				if(u.getId().equals(Answer.getIda())) {
					target = u;
				}
			}
			int o = target.getCoins();
			target.setCoins(o+100);
			if(num==0) {
				target.setAvgstr(r);
			}else {
				r = (target.getAvgstr()*(num-1)+r)/(num);
				target.setAvgstr(r);
			}		
		}
		
	}
	
	public int checkwarining(String ida) {
		int i=0;
		EndView.messageView("답변이 적절했나요?? 네 또는 신고(욕설,비방 등)");
		String answer = sc.nextLine();
		UserInfo target = new UserInfo();
		for(UserInfo u : userlist) {
			if(u.getId().equals(ida)) {
				target = u;
			}
		}
		if(answer.equals("신고")) {
			EndView.messageView("자세한 신고 사유를 알려주십시오");
			String message = sc.nextLine();
			int k = target.getReportCount()+1;
			target.setReportCount(k);
			i = 1;
		}
		return i;
	}
	
	public int coinsection() throws BoundException {
		EndView.messageView("1.질문하기 2.답하기 3.평가하기 4.코인충전하기 5.질문확인하기 6.유저확인하기 7.질문전체 8.메뉴종료");
		String input = sc.nextLine();
		int i = Integer.parseInt(input);
		if(i<1||i>8) {
			throw new BoundException();
		}else {
			return i;
		}
		
	}
}