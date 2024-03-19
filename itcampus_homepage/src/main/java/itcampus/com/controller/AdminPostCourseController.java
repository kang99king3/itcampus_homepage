package itcampus.com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import itcampus.com.service.AdminCourseService;
import itcampus.com.service.AdminPostCourseService;
import itcampus.com.service.impl.AdminPostCourseServiceImpl;
import itcampus.com.vo.CourseVO;
import itcampus.com.vo.PostCourseVO;

@Controller
@RequestMapping("/admin")
public class AdminPostCourseController {

	Logger logger=LoggerFactory.getLogger(AdminCourseController.class);
	
	@Autowired
	private AdminPostCourseService adminPostCourseService;
	
	@Autowired
	private AdminCourseService adminCourseService;
	
	//후기목록
	@GetMapping("/postcourse")
	public String postCourseList(Model model) {
		logger.debug("후기목록");
		List<PostCourseVO> postCourseList = adminPostCourseService.postCourseList();
		model.addAttribute("plist", postCourseList);
		System.out.println(postCourseList.toString());
		return "admin/postcourselist";
	}
	
	//후기목록
	@GetMapping("/postcourse/add")
	public String postCourseAddForm(Model model) {
		logger.debug("후기추가폼이동");
		return "admin/postcourseadd";
	}
	
	//과정목록
	@ResponseBody
	@GetMapping("/postcourse/search")
	public Map<String,List<CourseVO>> courseList(Model model) {
		logger.debug("후기등록시 과정목록 검색");
		List<CourseVO> cList= adminCourseService.courseList();
		
		Map<String,List<CourseVO>> map=new HashMap<>();
		map.put("clist", cList);
		System.out.println("cList size:"+cList.size());
		return map;
	}
}





