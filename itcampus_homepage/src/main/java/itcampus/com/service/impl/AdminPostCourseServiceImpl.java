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
		return adminPostCourseServiceRepository.findAll();
	}

	@Override
	public void insertPostCourse(PostCourseDto postcourseDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PostCourseVO postCourseUpdateForm(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePostCourse(PostCourseDto postcourseDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePostCourse(int pid) {
		// TODO Auto-generated method stub
		
	}

}
