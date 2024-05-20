package itcampus.com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/courseinfo")
public class CourseInforController {

	Logger logger=LoggerFactory.getLogger(CourseInforController.class);
	
	//정부지원사업안내 메인
	@GetMapping("")
	public String courseInfo() {
		logger.info("정부지원사업메인페이지");
		return "courseinfo/courseinfo";
	}
	//K-digital사업
	@GetMapping("/kdigital")
	public String kdigital() {
		logger.info("K-digital사업페이지");
		return "courseinfo/courseinfo-kdigital";
	}
	//국민취업지원제도
	@GetMapping("/kua")
	public String kua() {
		logger.info("국민취업지원제도페이지");
		return "courseinfo/courseinfo-kua";
	}
	//국민내일배움카드
	@GetMapping("/card")
	public String card() {
		logger.info("국민내일배움카드페이지");
		return "courseinfo/courseinfo-card";
	}
	//국가기간전략산업직종훈련
	@GetMapping("/national")
	public String national() {
		logger.info("국가기간전략산업직종훈련페이지");
		return "courseinfo/courseinfo-national";
	}
	//국가인적자원개발 컨소시엄사업
	@GetMapping("/consortium")
	public String consortium() {
		logger.info("국가인적자원개발 컨소시엄사업페이지");
		return "courseinfo/courseinfo-consortium";
	}
}
