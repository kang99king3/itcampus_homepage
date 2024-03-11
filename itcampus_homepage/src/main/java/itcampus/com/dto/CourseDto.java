package itcampus.com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
	
	int cid;

	String cname;
	
	String ccate;
	
	String csdate;
	
	String cedate;
	
	int cnumber;
	
	String cmoney;
	
	String ccontent;
	
	String cthumb;
	
	String cuse;
	
	int mno;
}
