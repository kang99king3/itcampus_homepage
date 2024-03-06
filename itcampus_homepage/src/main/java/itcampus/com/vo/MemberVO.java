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
@Table(name="Member")
@Schema(description = "사용자 정보 VO")
public class MemberVO {

	@Id
	@Column(name = "M_NO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "회원번호")
	int m_no;
	
	@Schema(description = "회원ID")
	@Column(name="M_ID",length=20)
	String m_id;
	
	@Schema(description = "회원PW")
	@Column(name="M_PWD",length=20)
	String m_pwd;
	
	@Schema(description = "회원이름")
	@Column(name="M_NAME",length=10)
	String m_name;
	
	@Schema(description ="회원상태")
	@Column(name="M_STATUS",length=1)
	String m_status;
	
	@Schema(description = "가입일")
	@Column(name="M_JOIN_DATE",length=10)
	String m_join_date;
	
	@Schema(description = "회원권한")
	@Column(name="M_ROLE",length=10)
	String m_role;
	
}
