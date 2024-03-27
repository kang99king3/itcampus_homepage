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
import itcampus.com.dto.StudentProjectDto;
import lombok.Data;

@Data
@Entity
@Table(name="studentproject")
@Schema(description = "학생프로젝트 정보 VO")
public class StudentProjectVO {

	@Id
	@Column(name = "S_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "프로젝트번호")
	int sid;
	
	@Schema(description = "프로젝트제목")
	@Column(name="S_TITLE",length=100,nullable = false)
	String stitle;
	
	@Schema(description = "본문내용")
	@Column(name="S_CONTENT",nullable = false)
	String scontent;
	
	@Schema(description = "썸네일 위치(폴더/파일)")
	@Column(name="S_THUMB",length=1000)
	String sthumb;
	
	@Schema(description = "회원번호")
	@ManyToOne
	@JoinColumn(name="M_NO",nullable = false)
	MemberVO membervo;
	
	@Schema(description = "과정명")
	@Column(name="C_NAME",length=50,nullable = false)
	String cname;
	
	@Schema(description = "등록일")
	@Column(name="S_REGDATE",length=10,nullable = false)
	String sregdate;
	
	@Schema(description = "사용여부")
	@Column(name="S_USE",length=10,nullable = false)
	String suse;
	
	public void setStudentProjectVO(StudentProjectDto studentProjectDto) {
		
		this.sid=studentProjectDto.getSid();
		this.stitle=studentProjectDto.getStitle();
		this.scontent=studentProjectDto.getScontent();
		this.sthumb=studentProjectDto.getSthumb();
		this.cname=studentProjectDto.getCname();
		MemberVO memberVOObj=new MemberVO();
		memberVOObj.setMno(studentProjectDto.getMno());
		this.membervo=memberVOObj;
		this.sregdate=studentProjectDto.getSregdate();
		this.suse=studentProjectDto.getSuse();
		
	}
}
