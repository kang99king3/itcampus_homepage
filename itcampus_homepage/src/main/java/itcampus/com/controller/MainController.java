package itcampus.com.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import itcampus.com.service.AdminBannerService;
import itcampus.com.service.CourseService;
import itcampus.com.service.PostCourseService;
import itcampus.com.vo.BannerVO;
import itcampus.com.vo.CourseVO;
import itcampus.com.vo.PostCourseVO;

@Controller
public class MainController {
	
	Logger logger=LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private PostCourseService postCourseService;
	
  @Autowired
  AdminBannerService adminBannerService;

	@GetMapping("/")
	public String main(Model model) {
		logger.info("Main페이지");
		
		List<CourseVO> cList=courseService.findTop4ByCuseOrderByCsdateDesc();
		//logger.debug("과정목록:"+cList.toString());
		
		List<PostCourseVO> pList = postCourseService.findTop20ByPuseOrderByPregdateDesc();
		//logger.debug("후기목록:"+pList.toString());
		
		model.addAttribute("clist", cList);
		model.addAttribute("currentDate", LocalDate.now().toString());
		model.addAttribute("plist", pList);

		List<BannerVO> bannerList = adminBannerService.bannerListFilter();

    model.addAttribute("filteredBanners", bannerList);
		
		logger.debug("배너 목록 : " + bannerList.size() );
		return "main"; 
	}

}
