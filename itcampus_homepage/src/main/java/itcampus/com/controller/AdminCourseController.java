package itcampus.com.controller;

import java.io.File;
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
import org.springframework.web.bind.annotation.RequestPart;
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
	
	//과정등록
	@PostMapping("/course/add")
	public String courseAdd( MultipartHttpServletRequest multiRequest
							,CourseDto courseDto) throws Exception {
		logger.debug("과정등록");
		logger.debug("courseDto param:"+courseDto);//입력폼에서 전달된 파라미터를 dto객체로 받음
		
		List<FileVO> result=null;//업로드된 파일의 정보를 저장
		
		final Map<String, MultipartFile> files = multiRequest.getFileMap();
		System.out.println("file:"+files.get("cthumbfile").getOriginalFilename());
		if (files.get("cthumbfile").getOriginalFilename()!="") {
			result=fileUtil.parseFileInf(files, "COS_", 0, "", "");
			String cthumb = result.get(0).getFileStreCours()+"/"+result.get(0).getStreFileNm();
			courseDto.setCthumb(cthumb);
		}
		
		adminCourseService.insertCourse(courseDto);
		
		return "redirect:/admin/course";
	}
	
	//과정수정폼
	@GetMapping("/course/update")
	public String courseUpdateForm(int cid, Model model) {
		logger.debug("과정수정폼");
		CourseVO cDetail= adminCourseService.courseUpdateForm(cid);
		
		String cthumb=cDetail.getCthumb();
		String cthumbPath=cthumb.substring(cthumb.indexOf("/file"));
		cDetail.setCthumb(cthumbPath);
		
		model.addAttribute("cDetail", cDetail);
		System.out.println("cUpdateForm cname:"+cDetail.getCname());
		return "admin/courseupdate";
	}
	
	//과정수정하기
	@PostMapping("/course/update")
	public String courseUpdate(CourseDto courseDto, Model model
			,final MultipartHttpServletRequest multiRequest) throws Exception {
		logger.info("과정수정하기");
		logger.info("courseDto:"+courseDto);
		List<FileVO> result=null;//업로드된 파일의 정보를 저장

		final Map<String, MultipartFile> files = multiRequest.getFileMap();

		if(files.get("cthumbfile").getOriginalFilename()!="") {
			System.out.println("업로드된 파일이 있는경우");
			//업로드를 실행하고 업로드 파일정보를 반환
			result=fileUtil.parseFileInf(files, "COS_", 0, "", "");
			
			//기존 파일 삭제
			String oldName=courseDto.getCthumb().substring(courseDto.getCthumb().lastIndexOf("/"));
			File oldFile=new File(result.get(0).getFileStreCours()+oldName);
			oldFile.delete();
			
			//업로드 파일 정보 저장
			String cthumb = result.get(0).getFileStreCours()+"/"+result.get(0).getStreFileNm();
			courseDto.setCthumb(cthumb);//이미지를 수정하면 수정경로를 저장,수정이 없으면 기존 경로를 사용
		}
		
		//과정정보 수정
		adminCourseService.updateCourse(courseDto);
		return "redirect:/admin/course/update?cid="+courseDto.getCid();
	}
	
	//과정삭제하기
	@GetMapping("/course/delete")
	public String courseDelete(int cid,Model model) throws Exception {
		logger.info("과정삭제하기");
		adminCourseService.deleteCourse(cid);
		return "redirect:/admin/course";
	}
}





