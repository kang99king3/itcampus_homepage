package itcampus.com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BannerDto {
	
	int bid;
	String bname;
	String burl;
	String btargeturl;
	String btargetmethod;
	String balt;
  String buse;
	String bregdate;
	
	int mno;
}
