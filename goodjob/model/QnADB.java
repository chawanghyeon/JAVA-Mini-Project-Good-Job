package goodjob.model;
import java.util.ArrayList;
import goodjob.model.dto.QnA;
public class QnADB {
	private static QnADB instance = new QnADB();
	private ArrayList<QnA> qnalist = new ArrayList<QnA>();
	String n = "null";
	public QnADB() {
		qnalist.add(new QnA("dayoung11","#카카오#면접#엔터프라이즈개발직무#요구역량AI",n,n,"IT"));
		qnalist.add(new QnA("mingun22","#홍보직무#글쓰기#kbs한국어능력시험#학점","yeonji44","#직무강점#한국어능력시험#실용글쓰기#가점없음#자소서강점","글쓰기"));
		qnalist.add(new QnA("kinghyun33","#현대차#박사과정#생산기술개발직무#학력#배터리#반도체","mingun22","#석박사출신#생산기술직무적음#연구소많음#업무연관성","기계"));
		qnalist.add(new QnA("yeonji44","#kb금융#면접#블록체인#디지털R&D랩#디지털자산관리#보안","sungho88","#마곡페이#LGCNS#블록체인#인력부족","데이터분석"));
		qnalist.add(new QnA("yeonsic55","#gs홈쇼핑#편성전략직무#면접#md","yeonsic55","#MD직무#직무이해#MD부터시작","마케팅"));
		qnalist.add(new QnA("jun66","#한진해운#선사부킹담당#운임협상#쉬핑가제트#물류비절감","jiwon100","#가격절감#상호협상#픽업주기단축#항로통합#물량증가","무역실무"));
		qnalist.add(new QnA("minjae77","#SK하이닉스#소자직무#직무면접#소자#공정회로","ohmin99","#직병렬저항#테브낭노턴#Cap원리#도핑#모스펫#격자구조","반도체"));
		qnalist.add(new QnA("sungho88","#대한한공#일본어학과#jlpt#근로환경",n,n,"일본어"));
		qnalist.add(new QnA("ohmin99","#삼성물산#중국어과#hsk#Tsc#해외영업#해외인턴#무역영어자격증",n,n,"중국어"));
		qnalist.add(new QnA("jiwon100","#삼일회계법인#인턴#상경계열#조회서인턴#회계관련자격증#금융기관조회서#영어#컴퓨터활용능력#해외거주경험","jun66","#경험추천#단순인턴업무비추#관심확대","회계"));
	}
	
	public static QnADB getInstance() {
		return instance;
	}
	
	public ArrayList<QnA> getqnalist() {
		return qnalist;
	}
	
	public void insertProject(QnA newProject) {
		qnalist.add(newProject);
	}
}