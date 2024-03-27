package itcampus.com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class StudentProjectDto {

	private int sid;
	private String stitle;
	private String scontent;
	private String sthumb;
	private String cname;
	private int mno;
	private String sregdate;
	private String suse;
}
