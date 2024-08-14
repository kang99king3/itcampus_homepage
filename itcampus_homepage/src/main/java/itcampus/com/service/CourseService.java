package itcampus.com.service;

import java.util.List;

import itcampus.com.dto.CourseDto;
import itcampus.com.vo.CourseVO;

public interface CourseService {

	public List<CourseVO> courseList(int page, int size);//과정목록
	
	public List<CourseVO> findTop4ByCuseOrderByCsdateDesc();//과정목록조회(메인)

	public CourseVO courseView(int cid);//과정상세보기
	
	long countTotalCourses(); //과정전체 개수 보기
}
