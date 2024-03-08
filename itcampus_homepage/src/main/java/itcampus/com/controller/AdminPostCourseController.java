package itcampus.com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminPostCourseController {

Logger logger=LoggerFactory.getLogger(AdminCourseController.class);
	
	//후기목록
	@GetMapping("/postcourse")
	public String courseList() {
		logger.debug("후기목록");
		return "admin/postcourselist";
	}
}
