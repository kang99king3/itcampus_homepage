package itcampus.com.service;

import java.util.List;

import itcampus.com.dto.CourseDto;
import itcampus.com.dto.StudentProjectDto;
import itcampus.com.vo.CourseVO;
import itcampus.com.vo.StudentProjectVO;

public interface StudentProjectService {

	public List<StudentProjectVO> projectList();//과정목록

//	public StudentProjectVO projectView(int sid);//과정상세보기

}
