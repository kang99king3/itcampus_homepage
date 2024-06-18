package itcampus.com.vo;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
import itcampus.com.dto.CourseDto;
import itcampus.com.dto.MediaDto;
import lombok.Data;

@Data
@Entity
@Table(name="media")
@Schema(description = "미디어정보 VO")
public class MediaVO {

	@Id
	@Column(name = "MD_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "미디어번호")
	int mdid;
	
	@Schema(description = "파일명")
	@Column(name="MD_NAME",length=50)
	String mdname;
	
	@Schema(description = "설명")
	@Column(name="MD_CONTENT")
	String mdcontent;
	
	@Schema(description = "썸네일 위치(폴더/파일)")
	@Column(name="MD_THUMB",length=100)
	String mdthumb;
	
	@Schema(description = "미디어 등록일")
	@Column(name="MD_REGDATE")
	Date mdregdate;
	
	@Schema(description = "회원번호")
	@ManyToOne
	@JoinColumn(name="M_NO")
	MemberVO membervo;
	
	public void setMediaVO(MediaDto mediaDto) {
		this.mdid=mediaDto.getMdid();
		this.mdname=mediaDto.getMdname();
		this.mdcontent=mediaDto.getMdcontent();
		this.mdthumb=mediaDto.getMdthumb();
		this.mdregdate=mediaDto.getMdregdate();
		
		MemberVO memberVOObj=new MemberVO();
		memberVOObj.setMno(mediaDto.getMno());
		this.membervo=memberVOObj;
	}
}
