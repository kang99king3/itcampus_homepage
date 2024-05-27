package itcampus.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itcampus.com.repository.PostCourseRepository;
import itcampus.com.service.PostCourseService;
import itcampus.com.vo.PostCourseVO;

@Service
public class PostCourseServiceImpl implements PostCourseService{

	@Autowired
	PostCourseRepository postCourseRepository;
	
	@Override
	public List<PostCourseVO> findTop20ByPuseOrderByPregdateDesc() {
		return postCourseRepository.findTop20ByPuseOrderByPregdateDesc("Y");
	}

	
}
