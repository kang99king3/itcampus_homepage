package itcampus.com.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import itcampus.com.dto.MediaDto;
import itcampus.com.service.AdminMediaService;
import itcampus.com.service.EgovFileMngUtil;
import itcampus.com.service.FileVO;
import itcampus.com.vo.MediaVO;

@Controller
@RequestMapping("/admin")
public class AdminMediaController {

	Logger logger=LoggerFactory.getLogger(AdminCourseController.class);
	
	@Autowired
	private AdminMediaService adminMediaService;
	
	@Resource(name = "EgovFileMngUtil")
	private EgovFileMngUtil fileUtil;
	
	@GetMapping("/media")
	public String mediaList(Model model) {
		logger.debug("미디어 목록");
		
		List<MediaVO> list=adminMediaService.mediaList();
		model.addAttribute("mediaList", list);
		
		return "admin/media_list";
	}
	
	@GetMapping("/media/add")
	public String mediaAddForm() {
		logger.debug("미디어 등록폼");
		
		return "admin/media_add";
	}
	
	@PostMapping("/media/add")
	public String mediaAdd(MultipartHttpServletRequest multiRequest, MediaDto mediaDto) throws Exception {
		logger.debug("미디어 등록");
		List<FileVO> result=null;//업로드된 파일의 정보를 저장
		
		//파일 1개 업로드할때
//		final Map<String, MultipartFile> files = multiRequest.getFileMap();
//		System.out.println("file:"+files.get("mdthumbfile").getOriginalFilename());
//		if (files.get("mdthumbfile").getOriginalFilename()!="") {
////			result=fileUtil.parseFileInf(files, "MD_", 0, "", "C://Users/user/git/itcampus_homepage/itcampus_homepage/src/main/resources/static/media");
//			result=fileUtil.parseFileInf(files, "MD_", 0, "", "/home/itcampus/production/media");
//			String mdthumb = result.get(0).getFileStreCours()+"/"+result.get(0).getStreFileNm();
//			mediaDto.setMdname(result.get(0).getStreFileNm());//파일명저장
//			mediaDto.setMdthumb(mdthumb);
//			System.out.println("filepath:"+mdthumb);
//		}
		
		//파일 여러개 업로드할때
		List<MultipartFile> files = multiRequest.getFiles("mdthumbfile");
		System.out.println("file size:"+files.size());
		for (MultipartFile multipartFile : files) {
			if (multipartFile.getOriginalFilename()!="") {
				Map<String, MultipartFile> file=new HashMap<>();
				file.put("mdthumbfile", multipartFile);
//			result=fileUtil.parseFileInf(file, "MD_", 0, "", "C://Users/user/git/itcampus_homepage/itcampus_homepage/src/main/resources/static/media");
				result=fileUtil.parseFileInf(file, "MD_", 0, "", "/home/itcampus/production/media");
				String mdthumb = result.get(0).getFileStreCours()+"/"+result.get(0).getStreFileNm();
				mediaDto.setMdname(result.get(0).getStreFileNm());//파일명저장
				mediaDto.setMdthumb(mdthumb);
				System.out.println("filepath:"+mdthumb);
			}
			adminMediaService.insertMedia(mediaDto);			
		}
		logger.debug("미디어 성공");
		
		return "redirect:/admin/media";
	}
}
