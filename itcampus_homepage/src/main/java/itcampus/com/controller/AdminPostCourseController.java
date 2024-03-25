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

import itcampus.com.dto.PostCourseDto;
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
	
	//후기추가폼
	@GetMapping("/postcourse/add")
	public String postCourseAddForm(Model model) {
		logger.debug("후기추가폼이동");
		return "admin/postcourseadd";
	}
	
	//후기등록
	//1.후기등록시 [과정목록 검색 기능]
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

	//2.후기등록하기
	@PostMapping("/postcourse/add")
	public String postCourseAdd(PostCourseDto postCourseDto, Model model) {
		logger.debug("후기등록");
		System.out.println(postCourseDto);
		adminPostCourseService.insertPostCourse(postCourseDto);
		return "redirect:/admin/postcourse";
	}
	
	//후기상세보기
	@GetMapping("/postcourse/view")
	public String postCourse(int pid, Model model) {
		logger.debug("후기상세보기");
		PostCourseVO pDetail = adminPostCourseService.postCourseView(pid);
		model.addAttribute("pDetail", pDetail);
		System.out.println(pDetail);
		return "admin/postcourseview";
	}
	
	//후기수정하기
	@PostMapping("/postcourse/update")
	public String postCourseUpdate(PostCourseDto postCourseDto,Model model) {
		logger.debug("후기수정하기");
		System.out.println(postCourseDto);
		adminPostCourseService.updatePostCourse(postCourseDto);
		return "redirect:/admin/postcourse/view?pid="+postCourseDto.getPid();
	}
	
	//후기삭제하기
	@GetMapping("/postcourse/delete")
	public String postCourseDelete(int pid,Model model) {
		logger.debug("후기삭제하기");
		adminPostCourseService.deletePostCourse(pid);
		return "redirect:/amdin/postcourse";
	}
}





