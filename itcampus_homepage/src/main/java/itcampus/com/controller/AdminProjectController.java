package itcampus.com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminProjectController {

Logger logger=LoggerFactory.getLogger(AdminCourseController.class);
	
	//프로젝트목록
	@GetMapping("/project")
	public String courseList() {
		logger.debug("프로젝트목록");
		return "admin/projectlist";
	}
}
