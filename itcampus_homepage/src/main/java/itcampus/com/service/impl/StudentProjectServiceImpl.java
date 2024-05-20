package itcampus.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itcampus.com.dto.StudentProjectDto;
import itcampus.com.repository.AdminStudentProjectRepository;
import itcampus.com.repository.StudentProjectRepository;
import itcampus.com.service.AdminStudentProjectService;
import itcampus.com.service.StudentProjectService;
import itcampus.com.vo.StudentProjectVO;

@Service
public class StudentProjectServiceImpl implements StudentProjectService{

	@Autowired
	StudentProjectRepository studentProjectRepository;
	
	@Override
	public List<StudentProjectVO> projectList() {
//		return studentProjectRepository.findBySuse("Y");
		return studentProjectRepository.findTop10BySuseOrderBySregdateDesc("Y");
	}

//	@Override
//	public StudentProjectVO projectView(int sid) {
//		return studentProjectRepository.findBySid(sid);
//	}

}
