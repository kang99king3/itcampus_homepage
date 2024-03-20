package itcampus.com.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import io.swagger.v3.oas.annotations.media.Schema;
import itcampus.com.dto.CourseDto;
import itcampus.com.dto.PostCourseDto;
import itcampus.com.repository.AdminCourseServiceRepository;
import itcampus.com.repository.AdminPostCourseServiceRepository;
import lombok.Data;

@Data
@Entity
@Table(name="postcourse")
@Schema(description = "후기 정보 VO")
public class PostCourseVO {

	@Id
	@Column(name = "P_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "후기번호")
	int pid;
	
	@Schema(description = "코스번호")
	@ManyToOne
	@JoinColumn(name="C_ID",nullable = true)
	CourseVO coursevo;
	
	@Schema(description = "후기제목")
	@Column(name="P_TITLE",nullable = true)
	String ptitle;
	
	@Schema(description = "본문내용")
	@Column(name="P_CONTENT",nullable = false)
	String pcontent;
	
	@Schema(description = "후기작성일")
	@Column(name="P_REGDATE",nullable = false)
	String pregdate;
	
	@Schema(description = "회원번호")
	@ManyToOne
	@JoinColumn(name="M_NO",nullable = true)
	MemberVO membervo;
	
	@Schema(description = "사용여부")
	@Column(name="P_USE",nullable = false)
	String puse;
	
	//postcourseDto --> postcourseVO
	public void setCourseVO(PostCourseDto postCourseDto) {
		
		CourseVO courseVOObj=new CourseVO();
		courseVOObj.setCid(postCourseDto.getCid());			
		
		MemberVO memberVOObj=new MemberVO();
		memberVOObj.setMno(postCourseDto.getMno());
		
		this.pid=postCourseDto.getPid();
		
		//cid가 없는 경우(검색작성)와 있는 경우(직접작성)
		if(postCourseDto.getCid()==0) {
			this.coursevo=null; //coursevo 객체가 없는경우에는 null을 저장해야 함
		}else {
			this.coursevo=courseVOObj;			
		}
		this.ptitle=postCourseDto.getPtitle();
		this.pcontent=postCourseDto.getPcontent();
		this.pregdate=postCourseDto.getPregdate();
		this.membervo=memberVOObj;
	}
}









