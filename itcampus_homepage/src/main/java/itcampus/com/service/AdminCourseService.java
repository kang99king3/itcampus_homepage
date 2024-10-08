package itcampus.com.service;

import java.util.List;

import itcampus.com.dto.CourseDto;
import itcampus.com.vo.CourseVO;

public interface AdminCourseService {

	public List<CourseVO> courseList();//과정목록

	public void insertCourse(CourseDto courseDto);//과정정보등록

	public CourseVO courseView(int cid);//과정상세보기

	public void updateCourse(CourseDto courseDto);//과정수정하기

	public void deleteCourse(int cid);//과정삭제하기

	public void copyCourse(int cid);//과정복사하기

	long countTotalCourses(); //과정전체 개수 보기

}
