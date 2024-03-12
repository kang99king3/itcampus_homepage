package itcampus.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itcampus.com.repository.AdminServiceRepository;
import itcampus.com.service.AdminService;
import itcampus.com.vo.MemberVO;
import itcampus.com.vo.QnaVO;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminServiceRepository adminServiceRepository;
	
	@Autowired 
	QnaServiceRepository qnaServiceRepository;
	
	@Override
	public MemberVO login(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return adminServiceRepository.findByMidAndMpwd(memberVO.getMid(),memberVO.getMpwd());
		//return null;
	}
	
	@Override
	public List<QnaVO> list() {
		return qnaServiceRepository.findAll();
	}
}
