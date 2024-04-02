package itcampus.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itcampus.com.dto.CourseDto;
import itcampus.com.repository.AdminCourseServiceRepository;
import itcampus.com.repository.CourseServiceRepository;
import itcampus.com.service.AdminCourseService;
import itcampus.com.service.CourseService;
import itcampus.com.vo.CourseVO;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseServiceRepository courseServiceRepository;
	
	@Override
	public List<CourseVO> courseList() {
		List<CourseVO> list= courseServiceRepository.findByCuse("Y");
		return list;
	}

	@Override
	public CourseVO courseView(int cid) {
		return courseServiceRepository.findByCid(cid);
	}

}
