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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import itcampus.com.dto.StudentProjectDto;
import itcampus.com.service.AdminStudentProjectService;
import itcampus.com.service.EgovFileMngUtil;
import itcampus.com.service.FileVO;
import itcampus.com.vo.CourseVO;
import itcampus.com.vo.StudentProjectVO;

@Controller
@RequestMapping("/admin")
public class AdminProjectController {

	Logger logger=LoggerFactory.getLogger(AdminCourseController.class);
	
	@Resource(name = "EgovFileMngUtil")
	private EgovFileMngUtil fileUtil;
	
	@Autowired
	private AdminStudentProjectService adminStudentProjectService;
	
	//프로젝트목록
//	@GetMapping("/project")
//	public String courseList() {
//		logger.debug("프로젝트목록");
//		return "admin/projectlist";
//	}
	
	//과정목록
	@GetMapping("/project")
	public String projectList(Model model) {
		logger.debug("프로젝트목록");
		List<StudentProjectVO> sList= adminStudentProjectService.projectList();
		model.addAttribute("slist", sList);
		System.out.println("sList size:"+sList.size());
		return "admin/projectlist";
	}
	
	//과정등록폼
	@GetMapping("/project/add")
	public String projectAddForm(Model model) {
		logger.debug("과정등록폼");
		
		return "admin/projectadd";
	}
	
	//과정등록
	@PostMapping("/project/add")
	public String projectAdd( MultipartHttpServletRequest multiRequest
							,StudentProjectDto StudentProjectDto) throws Exception {
		logger.debug("과정등록");
		logger.debug("studentProjectDto param:"+StudentProjectDto);//입력폼에서 전달된 파라미터를 dto객체로 받음
		
		List<FileVO> result=null;//업로드된 파일의 정보를 저장
		
		final Map<String, MultipartFile> files = multiRequest.getFileMap();
		System.out.println("file:"+files.get("sthumbfile").getOriginalFilename());
		if (files.get("cthumbfile").getOriginalFilename()!="") {
			result=fileUtil.parseFileInf(files, "PRJ_", 0, "", "");
			String sthumb = result.get(0).getFileStreCours()+"/"+result.get(0).getStreFileNm();
			StudentProjectDto.setSthumb(sthumb);
		}
		
		adminStudentProjectService.insertProject(StudentProjectDto);
		
		return "redirect:/admin/project";
	}
	
	//과정상세보기
	@GetMapping("/project/view")
	public String projectUpdateForm(int sid, Model model) {
		logger.debug("프로젝트상세보기");
		StudentProjectVO sDetail= adminStudentProjectService.projectView(sid);
		
		String sthumb=sDetail.getSthumb();
		String sthumbPath=sthumb.substring(sthumb.indexOf("/file"));
		sDetail.setSthumb(sthumbPath);
		
		model.addAttribute("sDetail", sDetail);
//		System.out.println("sView sname:"+sDetail.getSname());
		return "admin/projectview";
	}
	
	//과정수정하기
	@PostMapping("/project/update")
	public String projectUpdate(StudentProjectDto StudentProjectDto, Model model
			,final MultipartHttpServletRequest multiRequest) throws Exception {
		logger.info("프로젝트수정하기");
		logger.info("StudentProjectDto:"+StudentProjectDto);
		List<FileVO> result=null;//업로드된 파일의 정보를 저장

		final Map<String, MultipartFile> files = multiRequest.getFileMap();

		if(files.get("sthumbfile").getOriginalFilename()!="") {
			System.out.println("업로드된 파일이 있는경우");
			//업로드를 실행하고 업로드 파일정보를 반환
			result=fileUtil.parseFileInf(files, "PRJ_", 0, "", "");
			
			//기존 파일 삭제
			String oldName=StudentProjectDto.getSthumb().substring(StudentProjectDto.getSthumb().lastIndexOf("/"));
			File oldFile=new File(result.get(0).getFileStreCours()+oldName);
			oldFile.delete();
			
			//업로드 파일 정보 저장
			String sthumb = result.get(0).getFileStreCours()+"/"+result.get(0).getStreFileNm();
			StudentProjectDto.setSthumb(sthumb);//이미지를 수정하면 수정경로를 저장,수정이 없으면 기존 경로를 사용
		}
		
		//과정정보 수정
		adminStudentProjectService.updateProject(StudentProjectDto);
		return "redirect:/admin/project/view?sid="+StudentProjectDto.getSid();
	}
	
	//과정삭제하기
	@GetMapping("/project/delete")
	public String projectDelete(int sid,Model model) throws Exception {
		logger.info("프로젝트 삭제하기");
		adminStudentProjectService.deleteProject(sid);
		return "redirect:/admin/project";
	}
	
	//과정복사하기
	@GetMapping("/project/copy")
	public String courseCopy(int sid,Model model) throws Exception {
		logger.info("프로젝트 복사하기");
		adminStudentProjectService.copyProject(sid);
		return "redirect:/admin/project";
	}
}
