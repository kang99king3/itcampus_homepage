package itcampus.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itcampus.com.dto.StudentProjectDto;
import itcampus.com.repository.AdminStudentProjectRepository;
import itcampus.com.service.AdminStudentProjectService;
import itcampus.com.vo.StudentProjectVO;

@Service
public class AdminStudentProjectServiceImpl implements AdminStudentProjectService{

	@Autowired
	AdminStudentProjectRepository adminStudentProjectRepository;
	
	@Override
	public List<StudentProjectVO> projectList() {
		return adminStudentProjectRepository.findBySuse("Y");
	}

	@Override
	public void insertProject(StudentProjectDto studentProjectDto) {
		StudentProjectVO studentProjectVO=new StudentProjectVO();
		studentProjectVO.setStudentProjectVO(studentProjectDto);
		
		adminStudentProjectRepository.save(studentProjectVO);
	}

	@Override
	public StudentProjectVO projectView(int sid) {
		
		return null;
	}

	@Override
	public void updateProject(StudentProjectDto studentProjectDto) {
		
	}

	@Override
	public void deleteProject(int sid) {
		
	}

	@Override
	public void copyProject(int sid) {
		
	}

}
