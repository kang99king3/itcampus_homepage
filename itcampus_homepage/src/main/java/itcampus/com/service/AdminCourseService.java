package itcampus.com.service;

import java.util.List;

import itcampus.com.dto.CourseDto;
import itcampus.com.vo.CourseVO;

public interface AdminCourseService {

	public List<CourseVO> courseList();//과정목록

	public void insertCourse(CourseDto courseDto);//과정정보등록

	
}
