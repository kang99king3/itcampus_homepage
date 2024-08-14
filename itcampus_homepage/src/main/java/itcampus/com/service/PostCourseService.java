package itcampus.com.service;

import java.util.List;

import itcampus.com.vo.PostCourseVO;

public interface PostCourseService {

	List<PostCourseVO> findTop20ByPuseOrderByPregdateDesc();//후기목록조회
	
	long countTotalPostCourses(); //과정전체 개수 보기

} 					 
