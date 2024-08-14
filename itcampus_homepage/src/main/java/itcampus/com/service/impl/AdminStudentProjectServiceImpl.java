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
		return adminStudentProjectRepository.findBySid(sid);
	}

	@Override
	public void updateProject(StudentProjectDto studentProjectDto) {
		StudentProjectVO studentProjectVO=new StudentProjectVO();
		studentProjectVO.setStudentProjectVO(studentProjectDto);
		
		adminStudentProjectRepository.save(studentProjectVO);
	}

	@Override
	public void deleteProject(int sid) {
		StudentProjectVO studentProjectVO=adminStudentProjectRepository.findBySid(sid);
		studentProjectVO.setSuse("N");
		adminStudentProjectRepository.save(studentProjectVO);
	}

	@Override
	public void copyProject(int sid) {
		StudentProjectVO studentProjectVO=adminStudentProjectRepository.findBySid(sid);
		studentProjectVO.setSid(0);
		adminStudentProjectRepository.save(studentProjectVO);
	}

	@Override
	public long countTotalProject() {
		// TODO Auto-generated method stub
		return adminStudentProjectRepository.count();
	}

}
