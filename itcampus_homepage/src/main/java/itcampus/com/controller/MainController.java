package itcampus.com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import itcampus.com.service.PostCourseService;
import itcampus.com.vo.PostCourseVO;

@Controller
public class MainController {
	
	Logger logger=LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private PostCourseService postCourseService;
	
	@GetMapping("/")
	public String main(Model model) {
		logger.info("후기목록실행:");
		List<PostCourseVO> pList = postCourseService.findTop10ByPuseOrderByPregdateDesc();
		
		logger.info("후기목록:"+pList.toString());
		model.addAttribute("plist", pList);
		
		return "main"; 
	}
	
}
