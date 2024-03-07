package itcampus.com.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Entity
@Table(name="member")
@Schema(description = "사용자 정보 VO")
public class MemberVO {

	@Id
	@Column(name = "M_NO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "회원번호")
	int mno;
	
	@Schema(description = "회원ID")
	@Column(name="M_ID",length=20)
	String mid;
	
	@Schema(description = "회원PW")
	@Column(name="M_PWD",length=20)
	String mpwd;
	
	@Schema(description = "회원이름")
	@Column(name="M_NAME",length=10)
	String mname;
	
	@Schema(description ="회원상태")
	@Column(name="M_STATUS",length=1)
	String mstatus;
	
	@Schema(description = "가입일")
	@Column(name="M_JOIN_DATE",length=10)
	String mjoindate;
	
	@Schema(description = "회원권한")
	@Column(name="M_ROLE",length=10)
	String mrole;
	
}
