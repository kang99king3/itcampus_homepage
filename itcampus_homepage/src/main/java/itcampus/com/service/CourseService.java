package itcampus.com.service;

import java.util.List;

import itcampus.com.dto.CourseDto;
import itcampus.com.vo.CourseVO;

public interface CourseService {

	public List<CourseVO> courseList();//과정목록

	public CourseVO courseView(int cid);//과정상세보기

}
