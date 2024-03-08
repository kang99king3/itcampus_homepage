package itcampus.com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminCourseController {
	
	Logger logger=LoggerFactory.getLogger(AdminCourseController.class);
	
	//과정목록
	@GetMapping("/course")
	public String courseList() {
		logger.debug("과정목록");
		return "admin/courselist";
	}
	
}
