package itcampus.com.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import itcampus.com.dto.CourseDto;
import itcampus.com.service.AdminCourseService;
import itcampus.com.service.EgovFileMngUtil;
import itcampus.com.service.FileVO;
import itcampus.com.vo.CourseVO;

@Controller
@RequestMapping("/admin")
public class AdminCourseController {
	
	Logger logger=LoggerFactory.getLogger(AdminCourseController.class);
	
	@Autowired
	AdminCourseService adminCourseService;
	
	@Resource(name = "EgovFileMngUtil")
	private EgovFileMngUtil fileUtil;
	
	//과정목록
	@GetMapping("/course")
	public String courseList(Model model) {
		logger.debug("과정목록");
		List<CourseVO> cList= adminCourseService.courseList();
		model.addAttribute("clist", cList);
		System.out.println("cList size:"+cList.size());
		return "admin/courselist";
	}
	
	//과정등록폼
	@GetMapping("/course/add")
	public String courseAddForm(Model model) {
		logger.debug("과정등록폼");
		
		return "admin/courseadd";
	}
	
	//과정등록폼
	@PostMapping("/course/add")
	public String courseAdd(CourseDto courseDto, Model model
			,final MultipartHttpServletRequest multiRequest) throws Exception {
		logger.debug("과정등록");
		logger.debug("courseDto param:"+courseDto);//입력폼에서 전달된 파라미터를 dto객체로 받음
		
		List<FileVO> result=null;//업로드된 파일의 정보를 저장
		String atchFileId = "";
		
//		this.sampleService.insertSample(sampleVO);//게시글 DB에 추가 요청

		final Map<String, MultipartFile> files = multiRequest.getFileMap();
		System.out.println("file:"+files.get("thumbfile").getName());
		if (!files.isEmpty()) {
//			Map<String, MultipartFile> files, String KeyStr, int fileKeyParam, String atchFileId, String storePath
			result=fileUtil.parseFileInf(files, "BBS_", 0, courseDto.getCid()+"", "");
//			atchFileId = fileMngService.insertFileInfs(result);
		}
		
		String cthumb = result.get(0).getFileStreCours()+"/"+result.get(0).getOrignlFileNm();
		courseDto.setCthumb(cthumb);
		adminCourseService.insertCourse(courseDto);
		return "redirect:/admin/course";
	}
}





