package goodjob.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class UserInfo {
	
	private String id;
	private String pw;
	private int age;

	private double avgstr;
	private int coins;
	private int reportCount = 0;
	
	private String job;
	private String career;

	@Override
	public String toString() {
		return "\n\n <해당 직무를 가진 user정보> \n* 아이디 : " + id + "\n* 연령대 : " + age + "\n* 별점 : " + avgstr 
				+ "\n* 직무 : " + job + "\n* 경력 : " + career;
	}
}
