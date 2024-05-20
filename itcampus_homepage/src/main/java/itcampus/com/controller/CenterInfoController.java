package itcampus.com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/centerinfo")
public class CenterInfoController {
	Logger logger=LoggerFactory.getLogger(CenterInfoController.class);

	@GetMapping("")
	public String centerInfo() {
		logger.debug("교육과정소개");
		return "centerinfo/centerinfo";
	}
	
	@GetMapping("/company")
	public String company() {
		logger.debug("회사소개");
		return "centerinfo/centerinfo-company";
	}
	
	@GetMapping("/direction")
	public String direction() {
		logger.debug("찾아오시는길");
		return "centerinfo/centerinfo-direction";
	} 
	
	@GetMapping("/history")
	public String history() {
		logger.debug("교육사업연혁");
		return "centerinfo/centerinfo-history";
	}
	
	@GetMapping("/info")
	public String info() {
		logger.debug("교육시설안내");
		return "centerinfo/centerinfo-info";
	}
	
	@GetMapping("/itcenter")
	public String itcenter() {
		logger.debug("교육센터소개");
		return "centerinfo/centerinfo-itcenter";
	}
}
