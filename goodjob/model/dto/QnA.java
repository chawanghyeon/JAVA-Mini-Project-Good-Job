package goodjob.model.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@Data
@NoArgsConstructor
public class QnA {
	private String idq;
	private String mq;
	private String ida;
	private String ma;
	private String type;
	@Override
	public String toString() {
		return "질문자=" + idq + ", 질문내용=" + mq + ", 답변자=" + ida + ", 답변내용=" + ma + ", 분야=" + type;
	}
}