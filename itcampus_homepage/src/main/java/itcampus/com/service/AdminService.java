package itcampus.com.service;

import java.util.List;

import itcampus.com.vo.MemberVO;
import itcampus.com.vo.QnaVO;

public interface AdminService {
	public MemberVO login(MemberVO memberVO);
	public List<QnaVO> list();
}
