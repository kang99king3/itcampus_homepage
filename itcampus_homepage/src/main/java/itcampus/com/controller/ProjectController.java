package itcampus.com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import itcampus.com.service.StudentProjectService;
import itcampus.com.vo.StudentProjectVO;

@Controller
public class ProjectController {

	Logger logger=LoggerFactory.getLogger(ProjectController.class);
	
	@Autowired
	private StudentProjectService studentProjectService;
	
	//과정목록
	@GetMapping("/project")
	public String projectList(Model model) {
		logger.debug("프로젝트목록");
		List<StudentProjectVO> sList= studentProjectService.projectList();
		model.addAttribute("slist", sList);
		
		//projectvo에 sthumb값에서 "/file/filename"로 추출하여 저장 
//		for(StudentProjectVO projectVO:sList) {
//			String sthumb=projectVO.getSthumb();
//			String sthumbPath=sthumb.substring(sthumb.indexOf("/file"));
//			projectVO.setSthumb(sthumbPath);
//		}
		
		System.out.println("sList size:"+sList.size());
		return "manage/project";
	}
}
