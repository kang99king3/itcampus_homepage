package itcampus.com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseInforController {

	Logger logger=LoggerFactory.getLogger(AdminCourseController.class);
	
	@GetMapping("/courseinfo")
	public String courseInfo() {
		return "/course/c_courseinfo";
	}
}
