package itcampus.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itcampus.com.dto.PostCourseDto;
import itcampus.com.repository.AdminPostCourseServiceRepository;
import itcampus.com.service.AdminPostCourseService;
import itcampus.com.vo.PostCourseVO;

@Service
public class AdminPostCourseServiceImpl implements AdminPostCourseService{

	@Autowired
	private AdminPostCourseServiceRepository adminPostCourseServiceRepository;
	
	@Override
	public List<PostCourseVO> postCourseList() {
		return adminPostCourseServiceRepository.findByPuse("Y");
	}

	@Override
	public void insertPostCourse(PostCourseDto postcourseDto) {
		PostCourseVO postCourseVO=new PostCourseVO();
		postCourseVO.setCourseVO(postcourseDto);
		adminPostCourseServiceRepository.save(postCourseVO);
	}

	@Override
	public PostCourseVO postCourseView(int pid) {
		return adminPostCourseServiceRepository.findByPid(pid);
	}
	
	@Override
	public void updatePostCourse(PostCourseDto postcourseDto) {
		PostCourseVO postCourseVO=new PostCourseVO();
		postCourseVO.setCourseVO(postcourseDto);
		adminPostCourseServiceRepository.save(postCourseVO);
	}

	@Override
	public void deletePostCourse(int pid) {
		PostCourseVO postCourseVO = adminPostCourseServiceRepository.findByPid(pid);
		postCourseVO.setPuse("N");
		adminPostCourseServiceRepository.save(postCourseVO);
	}


}
