package itcampus.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itcampus.com.dto.CourseDto;
import itcampus.com.repository.AdminCourseServiceRepository;
import itcampus.com.service.AdminCourseService;
import itcampus.com.vo.CourseVO;

@Service
public class AdminCourseServiceImpl implements AdminCourseService{

	@Autowired
	AdminCourseServiceRepository adminCourseServiceRepository;
	
	@Override
	public List<CourseVO> courseList() {
		List<CourseVO> list= adminCourseServiceRepository.findAll();
		return list;
	}

	@Override
	public void insertCourse(CourseDto courseDto) {
		CourseVO courseVO=new CourseVO();
		courseVO.setCourseVO(courseDto);
		adminCourseServiceRepository.save(courseVO);
	}

	
}
