package itcampus.com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PostCourseDto {

	private int pid;
	
	private int cid;
	
	private String ptitle;
	
	private String pcontent;
	
	private String pregdate;
	
	private int mno;
}
