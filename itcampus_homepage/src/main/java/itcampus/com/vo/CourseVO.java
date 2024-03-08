package itcampus.com.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Entity
@Table(name="course")
@Schema(description = "과정정보 VO")
public class CourseVO {

	@Id
	@Column(name = "C_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "코스번호")
	int cid;
	
	@Schema(description = "과정명")
	@Column(name="C_NAME",length=50)
	String cname;
	
	@Schema(description = "과정구분")
	@Column(name="C_CATE",length=10)
	String ccate;
	
	@Schema(description = "교육시작일정")
	@Column(name="C_SDATE",length=10)
	String csdate;
	
	@Schema(description ="교육종료일정")
	@Column(name="C_EDATE",length=10)
	String cedate;
	
	@Schema(description = "모집인원")
	@Column(name="C_NUMBER")
	int cnumber;
	
	@Schema(description = "훈련수당")
	@Column(name="C_MONEY",length=30)
	String cmoney;
	
	@Schema(description = "본문내용")
	@Column(name="C_CONTENT")
	String ccontent;
	
	@Schema(description = "썸네일 위치(폴더/파일)")
	@Column(name="C_THUMB",length=100)
	String cthumb;
	
	@Schema(description = "사용여부")
	@Column(name="C_USE",length=1)
	String cuse;
	
	@Schema(description = "회원번호")
	@ManyToOne
	@JoinColumn(name="M_NO")
	MemberVO membervo;
}
