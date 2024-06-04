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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import itcampus.com.service.CourseService;
import itcampus.com.vo.CourseVO;
import itcampus.com.vo.StudentProjectVO;

@Controller
@RequestMapping("/course")
public class CourseController {

	Logger logger=LoggerFactory.getLogger(CourseController.class);
	
	private int size=6; //한 페이지당 과정목록 수
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("")
	public String courseList(Model model) {
		logger.debug("과정목록보기");
		List<CourseVO> clist = courseService.courseList(1,size);
		
		//projectvo에 cthumb값에서 "/file/filename"로 추출하여 저장 
//		for(CourseVO courseVO:clist) {
//			String cthumb=courseVO.getCthumb();
//			String cthumbPath=cthumb.substring(cthumb.indexOf("/file"));
//			courseVO.setCthumb(cthumbPath);
//		}
				
		model.addAttribute("clist", clist);
	
		
		return "course/course";
	}
	
	@ResponseBody
	@PostMapping("")
	public Map<String, List<CourseVO>> courseListMore(Model model,int page) {
		logger.debug("과정목록 더보기");
		List<CourseVO> clist = courseService.courseList(page,size);
		
		//projectvo에 cthumb값에서 "/file/filename"로 추출하여 저장 
		for(CourseVO courseVO:clist) {
			String cthumb=courseVO.getCthumb();
			String cthumbPath=cthumb.substring(cthumb.indexOf("/file"));
			courseVO.setCthumb(cthumbPath);
		}
				
		Map<String, List<CourseVO>> map=new HashMap<>();
		map.put("clistMore", clist);
		
		return map;
	}
	
	
	@GetMapping("/detail")
	public String courseDetail(Model model,int cid) {
		logger.debug("과정상세보기");
		
		CourseVO cDetail = courseService.courseView(cid);
					
		model.addAttribute("cdetail", cDetail);
		
		return "course/course-detail";
	}
}
