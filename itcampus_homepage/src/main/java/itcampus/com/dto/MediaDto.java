package itcampus.com.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.swagger.v3.oas.annotations.media.Schema;
import itcampus.com.vo.MemberVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MediaDto {
	
	private int mdid;
	private String mdname;
	private String mdcontent;
	private String mdthumb;
	private Date mdregdate;
	private int mno;
}
