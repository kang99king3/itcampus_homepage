package itcampus.com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import itcampus.com.service.CourseService;
import itcampus.com.vo.CourseVO;
import itcampus.com.vo.StudentProjectVO;

@Controller
public class CourseController {

	Logger logger=LoggerFactory.getLogger(AdminCourseController.class);
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/course")
	public String courseList(Model model) {
		logger.debug("과정목록보기");
		
		List<CourseVO> clist = courseService.courseList();
		
		//projectvo에 cthumb값에서 "/file/filename"로 추출하여 저장 
		for(CourseVO projectVO:clist) {
			String cthumb=projectVO.getCthumb();
			String cthumbPath=cthumb.substring(cthumb.indexOf("/file"));
			projectVO.setCthumb(cthumbPath);
		}
				
		model.addAttribute("clist", clist);
		
		return "course/c_courselist";
	}
}
