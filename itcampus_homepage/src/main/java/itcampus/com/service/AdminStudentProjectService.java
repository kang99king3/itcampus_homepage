package itcampus.com.service;

import java.util.List;

import itcampus.com.dto.CourseDto;
import itcampus.com.dto.StudentProjectDto;
import itcampus.com.vo.CourseVO;
import itcampus.com.vo.StudentProjectVO;

public interface AdminStudentProjectService {

	public List<StudentProjectVO> projectList();//과정목록

	public void insertProject(StudentProjectDto studentProjectDto);//과정정보등록

	public StudentProjectVO projectView(int sid);//과정상세보기

	public void updateProject(StudentProjectDto studentProjectDto);//과정수정하기

	public void deleteProject(int sid);//과정삭제하기

	public void copyProject(int sid);//과정복사하기
	
	long countTotalProject(); //전체 개수 보기

}
