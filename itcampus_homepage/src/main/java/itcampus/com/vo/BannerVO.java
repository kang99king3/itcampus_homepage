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
import itcampus.com.dto.BannerDto;
import lombok.Data;

@Data
@Entity
@Table(name="banner")
@Schema(description = "배너정보 VO")
public class BannerVO {

	@Id
	@Column(name = "b_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(description = "배너번호")
	int bid;
	
	@Schema(description = "배너이름")
	@Column(name="b_NAME",length=50)
	String bname;
	
	@Schema(description = "배너URL정보")
	@Column(name="b_URL",length=200)
	String burl;

	@Schema(description = "targetURL정보")
	@Column(name="b_TARGETURL",length=200)
	String btargeturl;

	@Schema(description = "targetURL방식")
	@Column(name="b_TARGETMETHOD",length=10)
	String btargetmethod;

	@Schema(description = "Alt")
	@Column(name="b_ALT",length=100)
	String balt;
	
	@Schema(description = "사용여부")
	@Column(name="b_USE",length=1)
	String buse;

	@Schema(description = "등록일")
	@Column(name="b_REGDATE",length=10)
	String bregdate;
	
	@Schema(description = "회원번호")
	@ManyToOne
	@JoinColumn(name="M_NO")
	MemberVO membervo;
	
	public void setBannerVO(BannerDto bannerDto) {
		this.bid = bannerDto.getBid();
		this.bname = bannerDto.getBname();
		this.burl = bannerDto.getBurl();
		this.balt = bannerDto.getBalt();
		this.buse = bannerDto.getBuse();
		this.bregdate = bannerDto.getBregdate();	
		this.btargeturl = bannerDto.getBtargeturl();
		this.btargetmethod = bannerDto.getBtargetmethod();
		
		MemberVO memberVOObj=new MemberVO();
		memberVOObj.setMno(bannerDto.getMno());
		this.membervo=memberVOObj;
	}
}
